package controller;

import model.dto.CreateProfessorDTO;
import model.dto.CreateStudentDTO;
import model.dto.ReadProfessorDTO;
import model.dto.ReadStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProfessorService;
import service.StudentService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<ReadStudentDTO> createStudent (@RequestBody CreateStudentDTO studentDTO) {
        ReadStudentDTO newStudent = studentService.createStudent(studentDTO);
        return ResponseEntity.ok(newStudent);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent (@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{studentId}")
    public ResponseEntity<ReadStudentDTO> updateStudent (@PathVariable Integer studentId, @RequestBody CreateStudentDTO studentDTO) {
        ReadStudentDTO student = studentService.updateStudent(studentDTO, studentId);
        return ResponseEntity.ok(student);
    }

    @GetMapping({"studentId"})
    public ResponseEntity<ReadStudentDTO> readStudent (@PathVariable Integer studentId) {
        ReadStudentDTO student = studentService.readStudentById(studentId);
        student.add(linkTo(methodOn(ProfessorController.class).readAllProfessors()).withRel("Lista de Estudantes"));
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<ReadStudentDTO>> readAllStudents () {
        List<ReadStudentDTO> students = studentService.readAllStudents();
        students.forEach(student -> {
            student.add(linkTo(methodOn(StudentController.class).readStudent(student.getId())).withSelfRel());
        });
        return ResponseEntity.ok(students);
    }
}
