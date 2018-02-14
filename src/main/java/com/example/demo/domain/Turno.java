
package com.example.demo.domain;

import java.util.Date;
import javax.persistence.*;

@Entity 
@Table (name="turnos")
public class Turno {

	@Id
	@Column(name="turno_id")
	private long turno_id;
	
	@Column(name="medico_id")
	private long medico_id;
	
	@Column(name="paciente_id")
	private long paciente_id;
	
	@ManyToOne
	@JoinColumn(name="obra_social_id", referencedColumnName="obra_social_id")
	private ObraSocial obra_social_id;
	
        @Temporal(TemporalType.DATE)
	@Column(name="fecha_turno")
	private Date fecha_turno;
	
        @Temporal(TemporalType.DATE)
	@Column(name="fecha_solicitud_turno")
	private Date fecha_solicitud_turno;
	
	@Column(name="estado")
	private String estado;

	public long getTurno_id() {
		return turno_id;
	}

	public void setTurno_id(long turno_id) {
		this.turno_id = turno_id;
	}

	public long getMedico_id() {
		return medico_id;
	}

	public void setMedico_id(long medico_id) {
		this.medico_id = medico_id;
	}

	public long getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(long paciente_id) {
		this.paciente_id = paciente_id;
	}

	public ObraSocial getObra_social_id() {
		return obra_social_id;
	}

	public void setObra_social_id(ObraSocial obra_social_id) {
		this.obra_social_id = obra_social_id;
	}

	public Date getFecha_turno() {
		return fecha_turno;
	}

	public void setFecha_turno(Date fecha_turno) {
		this.fecha_turno = fecha_turno;
	}

	public Date getFecha_solicitud_turno() {
		return fecha_solicitud_turno;
	}

	public void setFecha_solicitud_turno(Date fecha_solicitud_turno) {
		this.fecha_solicitud_turno = fecha_solicitud_turno;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}