package es.upm.dit.isst.chor.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Jefe extends Empleado {

	private static final long serialVersionUID = 1L;

	
	//(mappedBy = "jefe", fetch = FetchType.EAGER)
	/*
	 * @OneToMany private Collection<Proyecto> proyectosJefe;
	 */

	public Jefe() {
		super();
	}

	/*
	 * public Collection<Proyecto> getProyectosJefe() { return proyectosJefe; }
	 * 
	 * 
	 * public void setProyectosJefe(Collection<Proyecto> proyectosJefe) {
	 * this.proyectosJefe = proyectosJefe; }
	 */

}
