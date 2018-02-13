
package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.services.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/medico")
@RestController
public class MedicoController {
    
    
    private final TurnoService turnoService;
   
    public MedicoController(TurnoService turnoService) {
   
        this.turnoService = turnoService;

    }
    
    
    // Módulo del médico: a. Consultar los turnos de una fecha determinada 
     @RequestMapping(value= "/buscarFecha/{fecha}")
     public List<Turno> buscarFecha( Date fecha){
     
         try{
         
             List<Turno> rango = turnoService.BuscarFecha(fecha);
       
             return rango;
             
         }catch(Exception e){
         
         System.out.println("Error: " + e);
         
         return null;
         }
     }
     

}
    
    