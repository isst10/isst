package es.upm.dit.isst.chor.dao;

import java.util.Collection;

import es.upm.dit.isst.chor.model.Proyecto;

public interface ProyectoDAO {
	public void create(Proyecto proyecto);
	public Proyecto read(String email);
	public void update(Proyecto proyecto);
	public void delete(Proyecto proyecto);
	public Collection<Proyecto> readAll();
	public Proyecto login(String email, String psd);
}
