
package com.example.demo.repository;


import com.example.demo.domain.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador,Long> {
    
}
