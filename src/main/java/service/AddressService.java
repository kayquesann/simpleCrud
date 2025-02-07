package service;

import jakarta.persistence.EntityNotFoundException;
import model.Address;
import model.dto.CreateAddressDTO;
import model.dto.ReadAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    //Method to convert an Address object for DTO
    public ReadAddressDTO convertToReadAddressDTO (Address address) {
        ReadAddressDTO addressDTO = new ReadAddressDTO();
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setPostalCode(address.getPostalCode());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setIdProfessor(address.getProfessor().getId());
        addressDTO.setIdStudent(address.getStudent().getId());
        return addressDTO;
    }

    //Method to get an existing address to be used in other methods
    public Address existingAddress (Integer addressId) {
        Optional<Address> address = addressRepository.findById(addressId);
        if (address.isEmpty()){
            throw new EntityNotFoundException("Endereço não encontrado");
        }
        return address.get();
    }

    //Method to delete an address in database
    public String deleteAddress (Integer addressId){
        addressRepository.deleteById(addressId);
        return "Endereço excluido com sucesso!";
    }

    //Method to update an address in database
    public ReadAddressDTO updateAddress (CreateAddressDTO addressDTO, Integer addressId) {
        Address existindAddress = existingAddress(addressId);
        existindAddress.setStudent(addressDTO.getStudent());
        existindAddress.setProfessor(addressDTO.getProfessor());
        existindAddress.setStreet(addressDTO.getStreet());
        existindAddress.setCity(addressDTO.getCity());
        existindAddress.setState(addressDTO.getState());
        existindAddress.setPostalCode(addressDTO.getPostalCode());
        existindAddress.setCountry(addressDTO.getCountry());
        addressRepository.save(existindAddress);
        return convertToReadAddressDTO(existindAddress);
    }

    //Method to read a specific address
    public ReadAddressDTO readAddressById (Integer addressId) {
        Address existingAddress = existingAddress(addressId);
        return convertToReadAddressDTO(existingAddress);
    }

    //Method to real all existing addresses in database
    public List<ReadAddressDTO> readAllAddresses () {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(this::convertToReadAddressDTO)
                .collect(Collectors.toList());
    }
}
