
package com.example.demo.services.impl;

import com.example.demo.domain.Paciente;
import com.example.demo.domain.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.services.PersonaService;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

     private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
    
    
    @Override
    public void save(Persona persona) {
      personaRepository.save(persona);
    }

    @Override
    public Persona findAll() {
        return (Persona) personaRepository.findAll();
    }

    

    @Override
    public Persona findOne(Long id) {
      return personaRepository.findOne(id);
    }

   
    /*@Override
    public Persona Login(String usuario, String clave) {
        return (Persona) personaRepository.Login(usuario, clave);
    }*/

    @Override
    public List<Persona> Login(String usuario, String clave) {
         return personaRepository.Login(usuario, clave);
    }  
    
    
    @Override
    public Persona RecuperarContrasenia(String usuario, String e_mail) {
        return personaRepository.RecuperarContrasenia(usuario, e_mail);
    }
        
}
