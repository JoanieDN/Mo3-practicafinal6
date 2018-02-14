package com.example.demo.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.*;


@Entity
@Cacheable
@DiscriminatorValue(value = "MEDICO")
public class Medico extends Persona {

        @ManyToOne
	@JoinColumn(name="especialidad_id", referencedColumnName="especialidad_id")
	private Especialidad  especialidad_id;
   
        public Especialidad getEspecialidad() {
        return especialidad_id;
    }

    public void setEspecialidadId(Especialidad especialidad_id) {
        this.especialidad_id = especialidad_id;
    }

    public void setId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
