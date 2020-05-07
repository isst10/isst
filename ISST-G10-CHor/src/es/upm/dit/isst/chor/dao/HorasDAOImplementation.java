package es.upm.dit.isst.chor.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.chor.model.Empleado;
import es.upm.dit.isst.chor.model.Horas;

public class HorasDAOImplementation implements HorasDAO {

	private static HorasDAOImplementation instancia = null;
	private HorasDAOImplementation() {
	}

	public static HorasDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new HorasDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Horas horas) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		session.save(horas);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Horas read(String empleado) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		
		Horas e = session.get(Horas.class, empleado);
		session.getTransaction().commit();
		session.close();
		return e;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(Horas empleado) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		session.saveOrUpdate(empleado);
		session.getTransaction().commit();
		session.close();

	}
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Horas horas) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		session.delete(horas);
		session.getTransaction().commit();
		session.close();

	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Horas> readAllEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		Query q = session.createQuery("select p from Horas p where p.empleado = :empleado");
		q.setParameter("empleado", empleado);
		List<Horas> empleados = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return empleados;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Horas> filtra(String proyecto, Empleado empleado) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		Query q = session.createQuery("select p from Horas p where p.proyecto = :proyecto and p.empleado = :empleado");
		q.setParameter("empleado", empleado);
		q.setParameter("proyecto", proyecto);
		List<Horas> empleados = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return empleados;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Horas> readAllProyecto(String proyecto) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		Query q = session.createQuery("select p from Horas p where p.proyecto = :proyecto");
		q.setParameter("proyecto", proyecto);
		List<Horas> empleados = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return empleados;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Horas> readAllEmpresa(String empresa) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		Query q = session.createQuery("select p from Horas p where p.empresa = :proyecto");
		q.setParameter("empresa", empresa);
		List<Horas> empleados = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return empleados;
	}
}
