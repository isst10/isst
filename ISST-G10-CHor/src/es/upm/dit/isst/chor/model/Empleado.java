package es.upm.dit.isst.chor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	private String password;
	private String nombre;
	private double sueldo;		

	@ManyToOne
	private Proyecto proyecto;
	
	@OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER)
	private Collection<Horas> horas;

	public Collection<Horas> getHoras() {
		return horas;
	}

	public void setHoras(Collection<Horas> horas) {
		this.horas = horas;
	}

	public Empleado() {
		super();
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

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}


	@Override
	public String toString() {
		return "Empleado [email=" + email + ", password=" + password + ", nombre=" + nombre + ", sueldo=" + sueldo
				+ ", proyecto=" + proyecto + ", horas=" + horas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		return true;
	}


	
	
	
}
