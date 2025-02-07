package controller;

import model.dto.CreateAddressDTO;
import model.dto.ReadAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AddressService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("{addressId}")
    public ResponseEntity<ReadAddressDTO> readAddressById (@PathVariable Integer addressId) {
        ReadAddressDTO addressDTO = addressService.readAddressById(addressId);
        addressDTO.add(linkTo(methodOn(AddressController.class).readAllAddresses()).withRel("Lista de Endereços"));
        return ResponseEntity.ok(addressDTO);
    }

    @GetMapping
    public ResponseEntity<List<ReadAddressDTO>> readAllAddresses () {
        List<ReadAddressDTO> addressDTOS = addressService.readAllAddresses();
        addressDTOS.forEach(address -> {
            address.add(linkTo(methodOn(AddressController.class).readAddressById(address.getId())).withSelfRel());
        });
        return ResponseEntity.ok(addressDTOS);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress (@PathVariable Integer addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{addressId}")
    public ResponseEntity<ReadAddressDTO> updateAddress (@PathVariable Integer addressId, @RequestBody CreateAddressDTO addressDTO) {
        ReadAddressDTO address = addressService.updateAddress(addressDTO, addressId);
        return ResponseEntity.ok(address);
    }

}
