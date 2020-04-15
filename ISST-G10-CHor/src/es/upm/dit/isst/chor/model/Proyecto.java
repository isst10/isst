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
@Table(name="Proyecto")
public class Proyecto {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String name;
	private long nEmpleados;
	private Date fechaInicio;
	private Date fechaFin;
	private String chief;

	public String getChief() {
		return chief;
	}

	public void setChief(String chief) {
		this.chief = chief;
	}
	
	@ManyToOne
	private Collection<Asignacion> empleados;	
	
	@ManyToOne 
	private Jefe jefe;
	 
	
	public Proyecto() {
		super();
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

	@Override
	public String toString() {
		return "Proyecto [name=" + name + ", nEmpleados=" + nEmpleados + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", empleados=" + empleados + "]";
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

	public Collection<Asignacion> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Collection<Asignacion> empleados) {
		this.empleados = empleados;
	}

	public Jefe getJefe() { 
		return jefe; 
	}
	  
	public void setJefe(Jefe jefe) {
		this.jefe = jefe; 
	}
	 
	
}
