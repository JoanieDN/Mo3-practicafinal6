
package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.services.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/admin")
@RestController
public class AdministradorController {

    
    private final AdministradorService administradorSerivice;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;
    private final PersonaService personaService;
    private final TurnoService turnoService;
    
    public AdministradorController(MedicoService medicoService,AdministradorService administradorSerivice,PacienteService pacienteService,PersonaService personaService,TurnoService turnoService) {
        
        this.medicoService = medicoService;
        this.administradorSerivice = administradorSerivice;
        this.pacienteService = pacienteService;
        this.personaService  =  personaService;
        this.turnoService=turnoService;
    }

 

    
    
    @GetMapping(value = "/index")
    public String index() {
        
        return "Practica 6. Diana Joanie Díaz Navarrete";
    }
    
    
     @GetMapping(value = "/listar")
    public List<Administrador> listAdmin() {
        List<Administrador> admin = administradorSerivice.findAll();
        System.out.println(admin.size());
        return admin;
    }

    
    //Administrador: . Gestión de Médicos: Listado, búsqueda, Altas, Bajas (lógica), Modificación 
        @GetMapping(value = "/listarMedicos")
    public List<Medico> listAll() {
        
         List<Medico> medicos = medicoService.findAll();
         
       return medicos;
    }
    
    
     @GetMapping(value = "/BuscarId/{id}")
    public ResponseEntity<Medico> getMedico(@PathVariable("id") Long id) {
        Medico medico = medicoService.findOne(id);
        if (medico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medico);
    }
    
    
    //Registrar medico
    @PostMapping(value= "/nuevoMedico")
    public ResponseEntity<Medico> nuevoMedico(@RequestBody Medico medico) throws URISyntaxException {
     
          if (medico.getId() != null) {
            return ResponseEntity.badRequest().header("X-error", "El id debe ser null").body(null);
        }
        medicoService.save(medico); 
        return ResponseEntity.created(new URI("/medico/" + medico.getId())).body(medico);
        
    }
    
    //Actualizar Medicos
   @PutMapping("/editarMedico")
    public ResponseEntity<Medico> actualizarMedico(@RequestBody Medico medico) throws Exception {
        if (medico.getId() == null) {
            return ResponseEntity.badRequest().header("X-error", "El id no debe ser null").body(null);
        }
         medicoService.save(medico);
        return ResponseEntity.ok().body(medico);
    }
   
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
 
    
    @GetMapping(value = "/listarPacientes")
    public List<Paciente> listarPacientes() {
        
         List<Paciente> pacientes = pacienteService.findAll();
         
       return pacientes;
    }
    
    //Registrar paciente
    @PostMapping(value= "/registrarPaciente")
    public ResponseEntity<Paciente> nuevoPaciente(@RequestBody Paciente paciente) throws URISyntaxException {
     
          if (paciente.getId() != null) {
            return ResponseEntity.badRequest().header("X-error", "El id debe ser null").body(null);
        }
        pacienteService.save(paciente); 
        return ResponseEntity.created(new URI("/paciente/" + paciente.getId())).body(paciente);
        
    }
    
    
    //Actualizar Paciente
    @PutMapping("/EditarPaciente")
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente) throws Exception {
        if (paciente.getId() == null) {
            return ResponseEntity.badRequest().header("X-error", "El id no debe ser null").body(null);
        }
         pacienteService.save(paciente);
        return ResponseEntity.ok().body(paciente);
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

    // Listar los pacientes por obra social 
     @GetMapping(value = "/PacienteObra")
    public List<Paciente> porObraSoc() {
        
         List<Paciente> pacientes = pacienteService.PorObraSocial();
         
       return pacientes;
    }
    
    //. Mostrar las obras sociales con mayor número de consultas en una fecha determinada  
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

    
    
    


