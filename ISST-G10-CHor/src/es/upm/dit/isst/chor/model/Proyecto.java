package es.upm.dit.isst.chor.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Proyecto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String name;
	private int nEmpleados;
	private Date fechaInicio;
	private Date fechaFin;
	private String cliente;
	
	@OneToMany(mappedBy = "proyecto", fetch = FetchType.EAGER)
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

	public int getnEmpleados() {
		return nEmpleados;
	}

	public void setnEmpleados(int nEmpleados) {
		this.nEmpleados = empleados.size();
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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Proyecto [name=" + name + ", nEmpleados=" + nEmpleados + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", cliente=" + cliente + ", empleados=" + empleados + ", jefe=" + jefe + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Proyecto other = (Proyecto) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	 
	
}
