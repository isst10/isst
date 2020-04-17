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
	private String empresa;
	private String proyecto;
	
	@ManyToOne
	private Empleado hEmpleado;

	public Horas() {
		super();
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Empleado gethEmpleado() {
		return hEmpleado;
	}

	public void sethEmpleado(Empleado hEmpleado) {
		this.hEmpleado = hEmpleado;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String  getProyecto() {
		return proyecto;
	}
	public void setProyecto(String  proyecto) {
		this.proyecto = proyecto;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((hEmpleado == null) ? 0 : hEmpleado.hashCode());
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
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (hEmpleado == null) {
			if (other.hEmpleado != null)
				return false;
		} else if (!hEmpleado.equals(other.hEmpleado))
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
		return "Horas [date=" + date + ", horas=" + horas + ", empresa=" + empresa + ", proyecto=" + proyecto
				+ ", hEmpleado=" + hEmpleado + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
