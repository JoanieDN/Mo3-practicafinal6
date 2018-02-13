
package com.example.demo.repository;

import com.example.demo.domain.Persona;
import com.example.demo.domain.Turno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
   @Query("FROM Paciente WHERE usuario =:usuario and  clave=:clave") 
    List<Persona> Login(@Param("usuario")String usuario, 
            @Param("clave")String clave); 
   
    @Query("FROM Paciente WHERE usuario= :usuario and e_mail = :e_mail") 
     public Persona RecuperarContrasenia(@Param("usuario")String usuario, 
            @Param("e_mail")String e_mail);
}
