package com.github.oberdansoldi.studentcrud.service;

import com.github.oberdansoldi.studentcrud.domain.dto.StudentRequestDto;
import com.github.oberdansoldi.studentcrud.domain.dto.StudentResponseDto;
import com.github.oberdansoldi.studentcrud.domain.entity.Student;
import com.github.oberdansoldi.studentcrud.exceptions.StudentNotFoundException;
import com.github.oberdansoldi.studentcrud.repository.StudentRepository;
import com.github.oberdansoldi.studentcrud.service.builder.StudentBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//response: resposta enviada da API para o cliente
//request: resposta enviada do cliente para API

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentBuilder studentBuilder;
    private final StudentRepository studentRepository;

    public StudentResponseDto save(final StudentRequestDto studentRequestDto) {
        final Student studentToSave = studentBuilder.toStudent(studentRequestDto);
        final Student createdStudent = studentRepository.save(studentToSave);
        return studentBuilder.toStudentResponseDto(createdStudent);
    }

    public Optional<StudentResponseDto> getById(final Long id) {
        final Optional<Student> student = studentRepository.findById(id);
        student.orElseThrow(StudentNotFoundException::new);
        return student.map(studentBuilder::toStudentResponseDto);
    }

    public List<StudentResponseDto> getAll() {
        final List<Student> students = studentRepository.findAll();
        return students.stream().map(studentBuilder::toStudentResponseDto).collect(Collectors.toList());
    }

    public StudentResponseDto update(final StudentRequestDto studentRequestDto, final Long id) {
        return studentRepository.findById(id).map(it -> {
            it.setName(studentRequestDto.getName());
            it.setRm(studentRequestDto.getRm());
            it.setCpf(studentRequestDto.getCpf());
            return studentBuilder.toStudentResponseDto(studentRepository.save(it));
        }).orElseThrow(StudentNotFoundException::new);
    }

    public void delete(final Long id) {
        final Student studentRepositoryById = studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
        studentRepository.deleteById(studentRepositoryById.getId());
    }

}
