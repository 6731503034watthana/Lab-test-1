package com.example.labtest1.student;

import com.example.labtest1.student.Student; // ← เพิ่มบรรทัดนี้
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
