
package com.example.demo.services.impl;

import com.example.demo.domain.Medico;
import com.example.demo.repository.*;
import com.example.demo.services.MedicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Component
@Service
@Transactional
public class MedicoServiceImpl implements MedicoService {

    
    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }
    
    @Override
    public List<Medico> findAll() {
       return medicoRepository.findAll();
    }

    @Override
    public void save(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public Medico findOne(Long id) {
       return medicoRepository.findOne(id);
    }
    
}
