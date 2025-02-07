package service;

import jakarta.persistence.EntityNotFoundException;
import model.Professor;
import model.Student;
import model.dto.CreateProfessorDTO;
import model.dto.CreateStudentDTO;
import model.dto.ReadProfessorDTO;
import model.dto.ReadStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Method to convert a Student object for ReadProfessorDTO
    public ReadStudentDTO convertToReadStudentDTO (Student student) {
        ReadStudentDTO studentDTO = new ReadStudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setPhoneNumber(student.getPhoneNumber());
        studentDTO.setEmailAddress(student.getEmailAddress());
        studentDTO.setCityName(student.getStudentAddress().getCity());
        studentDTO.setStudentNumber(student.getStudentNumber());
        studentDTO.setAverageMark(student.getAverageMark());
        return studentDTO;
    }

    //Method to get an existing student to be used in other methods
    public Student existingStudent (Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isEmpty()) {
            throw new EntityNotFoundException("Estudante não encontrado!");
        }
        return student.get();
    }

    //Method to create a student in database
    public ReadStudentDTO createStudent (CreateStudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setEmailAddress(studentDTO.getEmailAddress());
        student.setStudentAddress(studentDTO.getStudentAddress());
        student.setStudentNumber(studentDTO.getStudentNumber());
        student.setAverageMark(studentDTO.getAverageMark());
        Student createdStudent = studentRepository.save(student);
        return convertToReadStudentDTO(createdStudent);
    }

    //Method to delete a student in database
    public String deleteStudent (Integer studentId) {
        studentRepository.deleteById(studentId);
        return "Estudante excluido com sucesso!";
    }

    //Method to update a student in database
    public ReadStudentDTO updateStudent (CreateStudentDTO studentDTO, Integer studentId) {
        Student existingStudent = existingStudent(studentId);
        existingStudent.setName(studentDTO.getName());
        existingStudent.setPhoneNumber(studentDTO.getPhoneNumber());
        existingStudent.setEmailAddress(studentDTO.getEmailAddress());
        existingStudent.setStudentAddress(studentDTO.getStudentAddress());
        existingStudent.setStudentNumber(studentDTO.getStudentNumber());
        existingStudent.setAverageMark(studentDTO.getAverageMark());
        studentRepository.save(existingStudent);
        return convertToReadStudentDTO(existingStudent);
    }

    //Method to read a specific student
    public ReadStudentDTO readStudentById (Integer studentId) {
        Student existingStudent = existingStudent(studentId);
        return convertToReadStudentDTO(existingStudent);
    }

    //Method to real all existing students in database
    public List<ReadStudentDTO> readAllStudents () {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(this::convertToReadStudentDTO)
                .collect(Collectors.toList());
    }
}
