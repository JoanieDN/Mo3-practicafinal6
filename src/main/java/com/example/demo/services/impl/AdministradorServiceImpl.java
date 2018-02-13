
package com.example.demo.services.impl;

import com.example.demo.domain.Administrador;
import com.example.demo.repository.AdministradorRepository;
import com.example.demo.services.AdministradorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AdministradorServiceImpl implements AdministradorService {

   
    private final  AdministradorRepository ar;
    
     public AdministradorServiceImpl(AdministradorRepository ar) {
        this.ar = ar;
    }
    
    @Override
    public List<Administrador> findAll() {
      return   ar.findAll();
    }
    
}
