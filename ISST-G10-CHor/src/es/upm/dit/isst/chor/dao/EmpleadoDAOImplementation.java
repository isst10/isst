package es.upm.dit.isst.chor.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.chor.model.Empleado;


public class EmpleadoDAOImplementation implements EmpleadoDAO {

	private static EmpleadoDAOImplementation instancia = null;
	private EmpleadoDAOImplementation() {
	}

	public static EmpleadoDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new EmpleadoDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Empleado empleado) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		session.save(empleado);
		session.getTransaction().commit();
		session.close();



	}
	@SuppressWarnings("unchecked")
	@Override
	public Empleado read(String email) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		
		Empleado e = session.get(Empleado.class, email);
		session.getTransaction().commit();
		session.close();
		return e;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Empleado empleado) {
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
	public void delete(Empleado empleado) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		session.delete(empleado);
		session.getTransaction().commit();
		session.close();

	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Empleado> readAll() {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		List<Empleado> empleados = session.createQuery("from Empleado").list();
		session.getTransaction().commit();
		session.close();
		return empleados;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Empleado login(String email, String psd) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		Empleado e = null;
		Query q = session.createQuery("select p from Empleado p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", psd);
		List<Empleado> empleados = q.getResultList();
		if (empleados.size() > 0)
			e = (Empleado) (q.getResultList().get(0));

		session.getTransaction().commit();
		session.close();
		return e;
	}
	
	public boolean buscarEmpleado(String email){
    	List<Empleado> empleados = (List<Empleado>) EmpleadoDAOImplementation.getInstance().readAll();
	    return empleados.stream().anyMatch(emp -> emp.getEmail().equals(email));
	}

}