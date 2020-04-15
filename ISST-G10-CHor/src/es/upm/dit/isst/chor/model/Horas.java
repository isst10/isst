package es.upm.dit.isst.chor.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Horas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Date date;
	private String horas;


	private String empresa;
	private String proyecto;
	private String empleado;
	

	public Horas() {
		super();
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmpleado() {
		return empleado;
	}
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
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
		result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
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
		if (empleado == null) {
			if (other.empleado != null)
				return false;
		} else if (!empleado.equals(other.empleado))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Horas [empleado=" + empleado + ", horas=" + horas + ", proyecto=" + proyecto + ", empresa=" + empresa
				+ "]";
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
