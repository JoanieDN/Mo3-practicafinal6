
package com.example.demo.controller;

import com.example.demo.domain.Turno;
import com.example.demo.services.TurnoService;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@Transactional
public class TurnoController {
    
    private final TurnoService turnoService;
    
    public TurnoController(TurnoService turnoService) {
    
        this.turnoService = turnoService;
    }
    
    
       @GetMapping(value = "/listarTurnos")
    public List<Turno> listarTurnos() {
        
         List<Turno> turnos = turnoService.findAll();
         
       return turnos;
    }
    
    //Módulo paciente: registrar turno
    @PostMapping(value= "/registrarTurno")
    public Turno nuevoTurno(@RequestBody Turno turno) {
       
        boolean exist = existencia(turno.getPaciente_id(),turno.getFecha_turno());
        
        if (exist != false){
        
            try{

                turnoService.save(turno);
                return turno;

            } catch(Exception e){

                System.out.println("Error: " +e);

                 return null;
            }
        
        }
        
        else {
            System.out.println("No es posible registrar dos turnos la misma fecha");
            return null;
        }   
    }
    
    
    public boolean  existencia(Long id, Date fecha){
    
        boolean existencia;
        
        
        if (!turnoService.ExistenciaTurno(id, fecha).isEmpty())
            existencia = false;
        
        else 
            existencia = true;
        
        
        return existencia;
  
    }
    
    
      //e. Consultar los turnos solicitados en un rango de fechas
     @RequestMapping(value= "/rangoFechas/{fechaInicio}/{fechaFin}")
     public List<Turno> rangoFechas( Date fechaInicio, Date fechaFin){
     
         try{
         
             List<Turno> rango = turnoService.RangoFechas(fechaInicio, fechaFin);
       
             return rango;
             
         }catch(Exception e){
         
         System.out.println("Error: " + e);
         
         return null;
         }
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
     
     
     //Modulo Administrador
     
      @RequestMapping(value= "/MaximoObraS/{fecha}")
     public List<Turno> obraSocialTurno( Date fecha){
     
         try{
         
            List<Turno>  os = turnoService.FechaObraSocial(fecha);
       
             return os;
             
         }catch(Exception e){
         
         System.out.println("Error: " + e);
         
         return null;
         }
     }
     
    
    }
    
    

