package es.upm.dit.isst.chor.dao;

import java.util.Collection;

import es.upm.dit.isst.chor.model.Jefe;

public interface JefeDAO {
	public void create(Jefe jefe);
	public Jefe read(String email);
	public void update(Jefe jefe);
	public void delete(Jefe jefe);
	public Collection<Jefe> readAll();
	public Jefe login(String email, String psd);
	public boolean buscarJefe(String email);
}
