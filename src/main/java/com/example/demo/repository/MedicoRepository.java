package com.example.demo.repository;

import com.example.demo.domain.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MedicoRepository extends JpaRepository<Medico, Long> {

 

}