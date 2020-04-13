package es.upm.dit.isst.chor.dao;

import java.util.Collection;

import es.upm.dit.isst.chor.model.Empleado;

public interface EmpleadoDAO {
	public void create(Empleado empleado);
	public Empleado read(String email);
	public void update(Empleado empleado);
	public void delete(Empleado empleado);
	public Collection<Empleado> readAll();
	public Empleado login(String email, String psd);
	public boolean buscarEmpleado(Empleado empleado);
}
