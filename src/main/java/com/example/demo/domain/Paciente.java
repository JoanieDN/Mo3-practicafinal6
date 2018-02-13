
package com.example.demo.domain;


import javax.persistence.*;




@Entity
@DiscriminatorValue(value = "PACIENTE")
public class Paciente extends Persona {
    
    @ManyToOne
    @JoinColumn(name="obra_social_id", referencedColumnName="obra_social_id")
    private ObraSocial obra_social_id;

     
   
      public ObraSocial getObraSocial() {
        return obra_social_id;
    }

    public void setObraSocialdId(ObraSocial obra_social_id) {
        this.obra_social_id = obra_social_id;
    }
     
     

}
