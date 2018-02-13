
package com.example.demo.services;

import com.example.demo.domain.*;
import java.util.List;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


public interface AdministradorService {
 
    public List<Administrador> findAll();
}
