
package com.example.demo.services;

import com.example.demo.domain.Medico;
import java.util.List;


public interface MedicoService { 
     
    public List<Medico> findAll();
         
    void save(Medico medico);
    
    Medico findOne(Long id);
}
