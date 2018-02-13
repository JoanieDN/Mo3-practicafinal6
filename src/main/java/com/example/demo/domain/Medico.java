package com.example.demo.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.*;


@Entity
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

}
