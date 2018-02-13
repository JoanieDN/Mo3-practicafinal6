package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.services.PersonaService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonaController {

    private final PersonaService personaService;

    
    public PersonaController(PersonaService personaService) {
        
        this.personaService = personaService;
  
    }
    
  
    @GetMapping(value = "/")
    public String index() {
        
        return "Practica 6. Diana Joanie Díaz Navarrete";
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



      //Baja lógica  - MEDICO
   
        @PutMapping("/EliminarMedico/{id}")
    public ResponseEntity<Persona> eliminarMedico(@PathVariable("id")Long id) throws Exception{
    
        try{
        
            Persona pe =  personaService.findOne(id);
            // System.out.println("Antes: " + pe + " "  + pe.getEstado());
            pe.setEstado("INHABILITADO");
            personaService.save(pe);
            return ResponseEntity.ok().build();
        
        }catch(Exception e){
        
            System.out.print("Error: "+e);
            return null;
        }
   
    }
 
    
    
    //Baja lógica  - PACIENTE
   
        @PutMapping("/EliminarPaciente/{id}")
    public ResponseEntity<Persona> BorrarPaciente(@PathVariable("id")Long id) throws Exception{
    
        try{
        
            Persona pe =  personaService.findOne(id);
            // System.out.println("Antes: " + pe + " "  + pe.getEstado());
            pe.setEstado("INHABILITADO");
            personaService.save(pe);
            return ResponseEntity.ok().build();
        
        }catch(Exception e){
        
            System.out.print("Error: "+e);
            return null;
        }
   
    }
 
    
}

