package es.upm.dit.isst.chor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jefe implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	private String password;
	private String nombre;
	
	@OneToMany(mappedBy = "jefe", fetch = FetchType.EAGER)
	private Collection<Proyecto> proyectosJefe;
	
	public Jefe() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((proyectosJefe == null) ? 0 : proyectosJefe.hashCode());
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
		Jefe other = (Jefe) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (proyectosJefe == null) {
			if (other.proyectosJefe != null)
				return false;
		} else if (!proyectosJefe.equals(other.proyectosJefe))
			return false;
		return true;
	}

	


	@Override
	public String toString() {
		return "Jefe [email=" + email + ", password=" + password + ", nombre=" + nombre + ", proyectosJefe="
				+ proyectosJefe + "]";
	}

	public Collection<Proyecto> getProyectosJefe() {
		return proyectosJefe;
	}

	public void setProyectosJefe(Collection<Proyecto> proyectosJefe) {
		this.proyectosJefe = proyectosJefe;
	}


}
