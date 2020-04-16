package es.upm.dit.isst.chor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	private String password;
	private String nombre;
	private boolean esJefe;
	private String empresa;
	
	private long nProyectos;
	private double sueldo;

	
	//(mappedBy = "empleados", fetch = FetchType.EAGER)
	@ManyToOne
	private Proyecto proyecto;

	public Empleado() {
		super();
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	



	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((proyecto == null) ? 0 : proyecto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sueldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (proyecto == null) {
			if (other.proyecto != null)
				return false;
		} else if (!proyecto.equals(other.proyecto))
			return false;
		if (Double.doubleToLongBits(sueldo) != Double.doubleToLongBits(other.sueldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [email=" + email + ", password=" + password + ", nombre=" + nombre + ", empresa=" + empresa
				+ ", nProyectos=" + nProyectos + ", esJefe=" + esJefe + ", proyectos=" + proyecto + "]";
	}

	/*
	 * public Collection<Empleado> getProyectos() { return proyectos; }
	 * 
	 * public void setProyectos(Collection<Empleado> proyectos) { this.proyectos =
	 * proyectos; }
	 */

	
	
	
}
