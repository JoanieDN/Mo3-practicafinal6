
package com.example.demo.repository;

import com.example.demo.domain.Paciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PacienteRepository extends JpaRepository<Paciente,Long> {
 
    @Query("FROM Paciente GROUP BY obra_social_id") 
       List<Paciente> PorObraSocial();

     
   
       
    
}
