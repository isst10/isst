package es.upm.dit.isst.chor.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Horas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Date date;
	private String horas;
	private Proyecto proyecto;
	@ManyToOne
	private Empleado empleado;



	public Horas() {
		super();
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
		result = prime * result + ((horas == null) ? 0 : horas.hashCode());
		result = prime * result + ((proyecto == null) ? 0 : proyecto.hashCode());
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
		Horas other = (Horas) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (empleado == null) {
			if (other.empleado != null)
				return false;
		} else if (!empleado.equals(other.empleado))
			return false;
		if (horas == null) {
			if (other.horas != null)
				return false;
		} else if (!horas.equals(other.horas))
			return false;
		if (proyecto == null) {
			if (other.proyecto != null)
				return false;
		} else if (!proyecto.equals(other.proyecto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Horas [date=" + date + ", horas=" + horas + ", proyecto=" + proyecto + ", empleado=" + empleado + "]";
	}



}
