
package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.services.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@RestController
public class MedicoController {
    
    private final MedicoService medicoService;
    
    public MedicoController(MedicoService medicoService) {
        
        this.medicoService = medicoService;
  
    }
    
    
    //Administrador: . Gestión de Médicos: Listado, búsqueda, Altas, Bajas (lógica), Modificación 
        @GetMapping(value = "/listarMedicos")
    public List<Medico> listAll() {
        
         List<Medico> medicos = medicoService.findAll();
         
       return medicos;
    }
    
    
     @GetMapping(value = "/BuscarMedico/{id}")
    public ResponseEntity<Medico> getMedico(@PathVariable("id") Long id) {
        Medico medico = medicoService.findOne(id);
        if (medico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medico);
    }
    
    
    //Registrar medico
    @PostMapping(value= "/registrarMedico")
    public ResponseEntity<Medico> nuevoMedico(@RequestBody Medico medico) throws URISyntaxException {
     
          if (medico.getId() != null) {
            return ResponseEntity.badRequest().header("X-error", "El id debe ser null").body(null);
        }
        medicoService.save(medico); 
        return ResponseEntity.created(new URI("/medico/" + medico.getId())).body(medico);
        
    }
    
    //Actualizar Medicos
   @PutMapping("/EditarMedico")
    public ResponseEntity<Medico> actualizarMedico(@RequestBody Medico medico) throws Exception {
        if (medico.getId() == null) {
            return ResponseEntity.badRequest().header("X-error", "El id no debe ser null").body(null);
        }
         medicoService.save(medico);
        return ResponseEntity.ok().body(medico);
    }
   
    
    
}
