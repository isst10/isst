package es.upm.dit.isst.chor.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Jefe extends Empleado {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "jefe", fetch = FetchType.EAGER)
	private Collection<Proyecto> proyectosJefe;

	public Jefe() {
		super();
	}

	public Collection<Proyecto> getProyectosJefe() {
		return proyectosJefe;
	}


	public void setProyectosJefe(Collection<Proyecto> proyectosJefe) {
		this.proyectosJefe = proyectosJefe;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
