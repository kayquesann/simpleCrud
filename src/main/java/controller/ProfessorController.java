package controller;

import model.dto.CreateProfessorDTO;
import model.dto.ReadProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.InputType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProfessorService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ReadProfessorDTO> createProfessor (@RequestBody CreateProfessorDTO professorDTO) {
        ReadProfessorDTO newProfessor = professorService.createProfessor(professorDTO);
        return ResponseEntity.ok(newProfessor);
    }

    @DeleteMapping("/{professorId}")
    public ResponseEntity<Void> deleteProfessor (@PathVariable Integer professorId) {
        professorService.deleteProfessor(professorId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{professorId}")
    public ResponseEntity<ReadProfessorDTO> updateProfessor (@PathVariable Integer professorId, @RequestBody CreateProfessorDTO professorDTO) {
        ReadProfessorDTO professor = professorService.updateProfessor(professorDTO, professorId);
        return ResponseEntity.ok(professor);
    }

    @GetMapping({"professorId"})
    public ResponseEntity<ReadProfessorDTO> readProfessor (@PathVariable Integer professorId) {
        ReadProfessorDTO professor = professorService.readProfessorById(professorId);
        professor.add(linkTo(methodOn(ProfessorController.class).readAllProfessors()).withRel("Lista de Professores"));
        return ResponseEntity.ok(professor);
    }

    @GetMapping
    public ResponseEntity<List<ReadProfessorDTO>> readAllProfessors () {
        List<ReadProfessorDTO> professors = professorService.readAllProfessors();
        professors.forEach(user -> {
            user.add(linkTo(methodOn(ProfessorController.class).readProfessor(user.getId())).withSelfRel());
        });
        return ResponseEntity.ok(professors);
    }
}
