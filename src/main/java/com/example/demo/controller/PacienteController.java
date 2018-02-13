
package com.example.demo.controller;

import com.example.demo.domain.Medico;
import com.example.demo.domain.Paciente;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.services.PacienteService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PacienteController {
    
      private final PacienteService pacienteService;
    
    public PacienteController(PacienteService pacienteService) {
        
        this.pacienteService = pacienteService;
  
    }
    
    
    
    
    
    
    
    
     @GetMapping(value = "/ObraSocial")
    public List<Paciente> porObraSoc() {
        
         List<Paciente> pacientes = pacienteService.PorObraSocial();
         
       return pacientes;
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
    
}
