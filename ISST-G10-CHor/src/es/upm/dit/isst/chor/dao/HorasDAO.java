package es.upm.dit.isst.chor.dao;

import java.util.Collection;

import es.upm.dit.isst.chor.model.Empleado;
import es.upm.dit.isst.chor.model.Horas;

public interface HorasDAO {
	public void create(Horas empleado);
	public Horas read(String empleado);
	public void update(Horas empleado);
	public void delete(Horas empleado);
	public Collection<Horas> readAllEmpleado(Empleado empleado);
	public Collection<Horas> filtra(String proyecto, Empleado empleado);
	public Collection<Horas> readAllProyecto(String proyecto);
	public Collection<Horas> readAllEmpresa(String empresa);

}
