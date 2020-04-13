package es.upm.dit.isst.chor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	private String password;
	private String nombre;
	private double sueldo;
	private long nProyectos;
	private boolean esJefe;
	
	@ManyToMany(mappedBy = "empleados", fetch = FetchType.EAGER)
	private Collection<Empleado> proyectos;

	public Empleado() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public long getnProyectos() {
		return nProyectos;
	}

	public void setnProyectos(long nProyectos) {
		this.nProyectos = nProyectos;
	}

	public boolean isEsJefe() {
		return esJefe;
	}

	public void setEsJefe(boolean esJefe) {
		this.esJefe = esJefe;
	}

	public Collection<Empleado> getProyectos() {
		return proyectos;
	}

	public void setProyectos(Collection<Empleado> proyectos) {
		this.proyectos = proyectos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
