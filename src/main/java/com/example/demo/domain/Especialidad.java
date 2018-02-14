
package com.example.demo.domain;

import javax.persistence.*;


@Entity 
@Cacheable
@Table (name="especialidades")
public class Especialidad {

	@Id
	@JoinColumn(name="especialidad_id")
	private long especialidad_id;
	
	@Column(name="descripcion")
	private String descripcion;

	public long getEspecialidad_id() {
		return especialidad_id;
	}

	public void setEspecialidad_id(long especialidad_id) {
		this.especialidad_id = especialidad_id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}