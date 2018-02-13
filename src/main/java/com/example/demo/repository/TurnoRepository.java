
package com.example.demo.repository;

import com.example.demo.domain.*;
import java.util.Date;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TurnoRepository extends JpaRepository<Turno,Long> {
    
    @Query("FROM Turno WHERE fecha_solicitud_turno BETWEEN :fechaInicio AND :fechaFin")
    List<Turno> RangoFechas( @Param("fechaInicio")Date fechaInicio,
            @Param("fechaFin")Date fechaFin);

    
    @Query("FROM Turno WHERE fecha_solicitud_turno = :fecha")
    List<Turno> BuscarFecha( @Param("fecha")Date fecha);
    
    
    @Query(" FROM Turno WHERE fecha_turno = :fecha ORDER BY obra_social_id ") 
       List<Turno> FechaObraSocial(@Param("fecha")Date fecha);

       
     @Query(" FROM Turno WHERE paciente_id = :id and fecha_turno =:fecha") 
       List<Turno> ExistenciaTurno(@Param("id")Long id,@Param("fecha")Date fecha);
       
       
       
    
    
}
