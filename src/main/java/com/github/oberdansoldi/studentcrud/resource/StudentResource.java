package com.github.oberdansoldi.studentcrud.resource;

import com.github.oberdansoldi.studentcrud.domain.dto.StudentRequestDto;
import com.github.oberdansoldi.studentcrud.domain.dto.StudentResponseDto;
import com.github.oberdansoldi.studentcrud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student")
public class StudentResource {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<StudentResponseDto>> getById(@PathVariable("id") final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> create(@RequestBody StudentRequestDto studentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") final Long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> update(@PathVariable("id") final Long id, @RequestBody StudentRequestDto studentRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.update(studentRequestDto, id));
    }
}
