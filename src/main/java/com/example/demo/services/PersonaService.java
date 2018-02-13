/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.domain.*;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author dianajoaniediaznavarrete
 */
public interface PersonaService {

    void save(Persona persona);
    
    Persona findAll();

    Persona findOne(Long id);
   
    List<Persona> Login(String usuario, String clave);
    
    
     public Persona RecuperarContrasenia(String usuario,String e_mail);
}


