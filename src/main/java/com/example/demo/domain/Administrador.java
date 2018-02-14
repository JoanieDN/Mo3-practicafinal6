
package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.*;


@Entity
@Cacheable
@DiscriminatorValue(value = "ADMINISTRADOR")
public class Administrador extends Persona {
    
    
}
