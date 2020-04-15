package es.upm.dit.isst.chor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Asignacion")
public class Asignacion implements Serializable{

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "empleados", fetch = FetchType.EAGER)
	private Proyecto asignaProyectos;

	@OneToMany(mappedBy = "empleados", fetch = FetchType.EAGER)
	private Empleado asignaEmpleados;
	
	
	public Asignacion() {
		super();
	}

	public Proyecto getAsignaProyectos() {
		return asignaProyectos;
	}

	public void setAsignaProyectos(Proyecto asignaProyectos) {
		this.asignaProyectos = asignaProyectos;
	}

	public Empleado getAsignaEmpleados() {
		return asignaEmpleados;
	}

	public void setAsignaEmpleados(Empleado asignaEmpleados) {
		this.asignaEmpleados = asignaEmpleados;
	}

}
