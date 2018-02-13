
package com.example.demo.controller;

import com.example.demo.domain.Administrador;
import com.example.demo.services.AdministradorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AdministradorController {

    @Autowired
    AdministradorService as;
    
    
     @GetMapping(value = "/listarAdmin")
    public List<Administrador> listAdmin() {
        List<Administrador> admin = as.findAll();
        System.out.println(admin.size());
        return admin;
    }

    
}

