package service;

import jakarta.persistence.EntityNotFoundException;
import model.Professor;
import model.dto.CreateProfessorDTO;
import model.dto.ReadProfessorDTO;
import org.springframework.stereotype.Service;
import repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;


    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    //Method to convert a Professor object for ReadProfessorDTO
    public ReadProfessorDTO convertToReadProfessorDTO (Professor professor) {
        ReadProfessorDTO professorDTO = new ReadProfessorDTO();
        professorDTO.setName(professor.getName());
        professorDTO.setPhoneNumber(professor.getPhoneNumber());
        professorDTO.setEmailAddress(professor.getEmailAddress());
        professorDTO.setCityName(professor.getProfessorAddress().getCity());
        professorDTO.setSalary(professor.getSalary());
        return professorDTO;
    }

    //Method to get an existing professor to be used in other methods
    public Professor existingProfessor (Integer professorId) {
        Optional<Professor> professor = professorRepository.findById(professorId);
        if (professor.isEmpty()) {
            throw new EntityNotFoundException("Professor não encontrado!");
        }
        return professor.get();
    }

    //Method to create a professor in database
    public ReadProfessorDTO createProfessor (CreateProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setName(professorDTO.getName());
        professor.setPhoneNumber(professor.getPhoneNumber());
        professor.setEmailAddress(professor.getEmailAddress());
        professor.setProfessorAddress(professor.getProfessorAddress());
        professor.setSalary(professorDTO.getSalary());
        Professor createdPerson = professorRepository.save(professor);
        return convertToReadProfessorDTO(createdPerson);
    }

    //Method to delete a professor in database
    public String deleteProfessor (Integer professorId) {
        professorRepository.deleteById(professorId);
        return "Professor excluido com sucesso!";
    }

    //Method to update a professor in database
    public ReadProfessorDTO updateProfessor (CreateProfessorDTO professorDTO, Integer professorId) {
        Professor existingProfessor = existingProfessor(professorId);
        existingProfessor.setName(professorDTO.getName());
        existingProfessor.setPhoneNumber(professorDTO.getPhoneNumber());
        existingProfessor.setEmailAddress(professorDTO.getEmailAddress());
        existingProfessor.setProfessorAddress(professorDTO.getProfessorAddress());
        professorRepository.save(existingProfessor);
        return convertToReadProfessorDTO(existingProfessor);
    }

    //Method to read a specific professor
    public ReadProfessorDTO readProfessorById (Integer professorId) {
        Professor existingProfessor = existingProfessor(professorId);
        return convertToReadProfessorDTO(existingProfessor);
    }

    //Method to real all existing professors in database
    public List<ReadProfessorDTO> readAllProfessors () {
        List<Professor> professors = professorRepository.findAll();
        return professors.stream()
                .map(this::convertToReadProfessorDTO)
                .collect(Collectors.toList());
    }
}
