package es.upm.dit.isst.chor.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.chor.model.Proyecto;

public class ProyectoDAOImplementation implements ProyectoDAO {

	private static ProyectoDAOImplementation instancia = null;
	private ProyectoDAOImplementation() {
	}

	public static ProyectoDAOImplementation getInstance() {
		if( null == instancia )
			instancia = new ProyectoDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Proyecto proyecto) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		session.save(proyecto);
		session.getTransaction().commit();
		session.close();



	}
	@SuppressWarnings("unchecked")
	@Override
	public Proyecto read(String name) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones

		Proyecto p = session.get(Proyecto.class, name);
		session.getTransaction().commit();
		session.close();
		return p;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Proyecto proyecto) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		session.saveOrUpdate(proyecto);
		session.getTransaction().commit();
		session.close();

	}
//	@SuppressWarnings("unchecked")
//	public void delete(String proyecto) {
//		Session session = SessionFactoryService.get().openSession();
//		try {
//			session.beginTransaction();
//			String query = "delete Proyecto WHERE name = '" + proyecto+"'";
//			Query q = session.createQuery(query);
//			q.executeUpdate();
//			session.getTransaction().commit();
//		} catch (Exception e) {
//
//		} finally {
//			session.close();
//		}
//		return ;
//
//	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Proyecto> readAll() {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		List<Proyecto> proyectos = session.createQuery("from Proyecto").list();
		session.getTransaction().commit();
		session.close();
		return proyectos;
	}@SuppressWarnings("unchecked")
	@Override
	public Proyecto login(String name) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		Proyecto p = null;
		Query q = session.createQuery("select p from Proyecto p where p.name = :name");
		q.setParameter("name", name);
		List<Proyecto> proyectos = q.getResultList();
		if (proyectos.size() > 0)
			p = (Proyecto) (q.getResultList().get(0));

		session.getTransaction().commit();
		session.close();
		return p;
	}
	@Override
	public boolean buscarProyecto(String p) {
    	List<Proyecto> proyectos = (List<Proyecto>) ProyectoDAOImplementation.getInstance().readAll();

	    return proyectos.stream().anyMatch(proyecto -> proyecto.getName().equals(p));
	}

	@Override
	public void delete(Proyecto proyecto) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(proyecto);
		session.getTransaction().commit();
		session.close();
	}
}
