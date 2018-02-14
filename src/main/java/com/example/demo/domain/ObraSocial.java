
package com.example.demo.domain;


import java.util.Date;

import javax.persistence.*;

@Entity 
@Cacheable
@Table (name="obras_sociales")
public class ObraSocial {

	@Id
	@Column(name="obra_social_id")
	private long obra_social_id;
	
	@Column(name="nombre")
	private String nombre;

	public long getObra_social_id() {
		return obra_social_id;
	}

	public void setObra_social_id(long obra_social_id) {
		this.obra_social_id = obra_social_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
