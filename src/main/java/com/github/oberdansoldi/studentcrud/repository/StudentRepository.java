package com.github.oberdansoldi.studentcrud.repository;

import com.github.oberdansoldi.studentcrud.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
