package com.example.secondspringproject.Repository;

import com.example.secondspringproject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    


}
