
package com.example.demo.services.impl;

import com.example.demo.domain.Paciente;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.services.PacienteService;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service
@Transactional
public class PacienteServiceImpl  implements PacienteService{

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    
    
    @Override
    public List<Paciente> findAll() {
       return pacienteRepository.findAll();
    }

    @Override
    public void save(Paciente paciente) {
       pacienteRepository.save(paciente);
    }

    @Override
    public Paciente findOne(Long id) {
       return pacienteRepository.findOne(id);
    }
    
    @Override
    public List<Paciente> PorObraSocial(){
        return pacienteRepository.PorObraSocial();
    }
  
    
}

