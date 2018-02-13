
package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.domain.*;
import com.example.demo.domain.*;
import com.example.demo.repository.*;
import com.example.demo.services.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/paciente")
@RestController
public class PacienteController {
    
    private final PacienteService pacienteService;
    private final PersonaService personaService;
    private final TurnoService turnoService;
    
    public PacienteController( PacienteService pacienteService, PersonaService personaService,TurnoService turnoService) {
        
        this.pacienteService = pacienteService;
        this.personaService =  personaService;
        this.turnoService =	turnoService;
    }
    
    
    //Login
    
    @GetMapping("/Login/{usuario}/{clave}")

    public List<Persona> login(@PathVariable("usuario")String usuario,@PathVariable("clave")String clave)  {
     
        List<Persona>  p=  personaService.Login(usuario, clave);
     
      
     if (p.size() != 0)
         System.out.println("Acceso exitoso");
         
     else
         System.out.println("Acceso denegado");
         
     
     return null;
     
} 
    
    // registrar turno
    @PostMapping(value= "/nuevoTurno")
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
   
    
    
    
      //Recuperar contraseña
    
   /*     @RequestMapping("/RecuperarContra/{usuario}/{e_mai}")
   
        public Persona recuperarContrasenia(@PathVariable("usuario")String usuario,@PathVariable("e_mail")String e_mail)  {
         
            Persona  p=  personaService.RecuperarContrasenia(usuario, e_mail);
         
          
         if ( p.getClave()!= ""){
             System.out.println("La contraseña es: "+ p.getClave());
             return p;
         } 
         else
             System.out.println("Acceso denegado");
             
         
         return null;
         
    }  */
    
}
