
package com.example.demo.services;

import com.example.demo.domain.*;
import java.util.List;

public interface PacienteService {
    
    public List<Paciente> findAll();
    
    void save(Paciente paciente);
    
    Paciente findOne(Long id);
    
    List<Paciente> PorObraSocial();
    
   
    
}

