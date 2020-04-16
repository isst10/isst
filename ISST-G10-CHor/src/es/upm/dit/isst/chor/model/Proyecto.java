package es.upm.dit.isst.chor.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Proyecto {

	private static final long serialVersionUID = 1L;

	@Id
	private String name;
	public String getCliente() {
		return Cliente;
	}

	public void setCliente(String cliente) {
		Cliente = cliente;
	}

	private int nEmpleados;
	private Date fechaInicio;
	private Date fechaFin;
	private String Cliente;
	
	@OneToMany(mappedBy = "proyecto", fetch = FetchType.EAGER)
	private Collection<Empleado> empleados;	
	
	@ManyToOne 
	private Jefe jefe;
	 
	
	public Proyecto() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cliente == null) ? 0 : Cliente.hashCode());
		result = prime * result + ((empleados == null) ? 0 : empleados.hashCode());
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((jefe == null) ? 0 : jefe.hashCode());
		result = prime * result + nEmpleados;
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
		if (Cliente == null) {
			if (other.Cliente != null)
				return false;
		} else if (!Cliente.equals(other.Cliente))
			return false;
		if (empleados == null) {
			if (other.empleados != null)
				return false;
		} else if (!empleados.equals(other.empleados))
			return false;
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (jefe == null) {
			if (other.jefe != null)
				return false;
		} else if (!jefe.equals(other.jefe))
			return false;
		if (nEmpleados != other.nEmpleados)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proyecto [name=" + name + ", nEmpleados=" + nEmpleados + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", Cliente=" + Cliente + ", empleados=" + empleados + ", jefe=" + jefe + "]";
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
	 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
