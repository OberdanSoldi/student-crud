package com.github.oberdansoldi.studentcrud.service.builder;

import com.github.oberdansoldi.studentcrud.domain.dto.StudentRequestDto;
import com.github.oberdansoldi.studentcrud.domain.dto.StudentResponseDto;
import com.github.oberdansoldi.studentcrud.domain.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentBuilder {

    public StudentResponseDto toStudentResponseDto(Student student) {
        return StudentResponseDto.builder()
                .id(student.getId())
                .rm(student.getRm())
                .name(student.getName())
                .cpf(student.getCpf())
                .build();
    }

    public Student toStudent(StudentRequestDto studentRequestDto) {
        return Student.builder()
                .rm(studentRequestDto.getRm())
                .name(studentRequestDto.getName())
                .cpf(studentRequestDto.getCpf())
                .build();
    }
}
