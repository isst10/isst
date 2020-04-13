package es.upm.dit.isst.chor.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class Proyecto {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String name;
	private long nEmpleados;
	private Date fechaInicio;
	private Date fechaFin;


	@ManyToMany(mappedBy = "proyectos", fetch = FetchType.EAGER)
	private Collection<Empleado> empleados;	
	
	@ManyToOne
	private Jefe jefe;
	
	public Proyecto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getnEmpleados() {
		return nEmpleados;
	}

	public void setnEmpleados(long nEmpleados) {
		this.nEmpleados = nEmpleados;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Collection<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Collection<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Jefe getJefe() {
		return jefe;
	}

	public void setJefe(Jefe jefe) {
		this.jefe = jefe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
