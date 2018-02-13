
package com.example.demo.services;

import com.example.demo.domain.Turno;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TurnoService  {
    
     
    
    void save(Turno turno);
    
    List<Turno> findAll();
    
    List<Turno> RangoFechas( Date fechaInicio, Date fechaFin);

    List<Turno> BuscarFecha( Date fecha);

    List<Turno> FechaObraSocial(Date fecha);
 
    List<Turno> ExistenciaTurno(Long id,Date fecha);
       
}
