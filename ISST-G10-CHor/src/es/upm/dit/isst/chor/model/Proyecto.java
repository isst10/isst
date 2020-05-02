package es.upm.dit.isst.chor.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Proyecto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String name;
	public int nEmpleados;
	private Date fechaInicio;
	private Date fechaFin;
	private String cliente;
	private boolean terminado;
	
	@OneToMany(mappedBy = "proyecto", fetch = FetchType.EAGER)
	private Collection<Empleado> empleados;	
	
	@OneToMany(mappedBy = "proyectoHoras", fetch = FetchType.EAGER)
	private Collection<Horas> horas;
	
	public Collection<Horas> getHoras() {
		return horas;
	}

	public void setHoras(Collection<Horas> horas) {
		this.horas = horas;
	}



	@ManyToOne 
	private Jefe jefe;
	 
	public Proyecto() {
		super();
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
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
				+ fechaFin + ", cliente=" + cliente + ", terminado=" + terminado + ", empleados=" + empleados
				+ ", horas=" + horas + ", jefe=" + jefe + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((empleados == null) ? 0 : empleados.hashCode());
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((horas == null) ? 0 : horas.hashCode());
		result = prime * result + ((jefe == null) ? 0 : jefe.hashCode());
		result = prime * result + nEmpleados;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (terminado ? 1231 : 1237);
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
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
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
		if (horas == null) {
			if (other.horas != null)
				return false;
		} else if (!horas.equals(other.horas))
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
		if (terminado != other.terminado)
			return false;
		return true;
	}
	
	
	 
	
}
