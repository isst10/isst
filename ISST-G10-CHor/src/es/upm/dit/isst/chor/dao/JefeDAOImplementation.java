package es.upm.dit.isst.chor.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.chor.model.Jefe;


public class JefeDAOImplementation implements JefeDAO {
	
	
	private static JefeDAOImplementation instancia = null;
	private JefeDAOImplementation() {
	}

	public static JefeDAOImplementation getInstance() {
		if( null == instancia ) 
			instancia = new JefeDAOImplementation();
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void create(Jefe jefe) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		session.save(jefe);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Jefe read(String email) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		Jefe j = session.get(Jefe.class, email);
		session.getTransaction().commit();
		session.close();
		return j;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Jefe jefe) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		session.saveOrUpdate(jefe);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Jefe jefe) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		session.delete(jefe);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Jefe> readAll() {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		List<Jefe> jefes = session.createQuery("from Jefe").list();
		session.getTransaction().commit();
		session.close();
		return jefes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Jefe login(String email, String psd) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		// operaciones
		Jefe j = null;
		Query q = session.createQuery("select p from Jefe p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", psd);
		List<Jefe> jefes = q.getResultList();
		if (jefes.size() > 0)
			j = (Jefe) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return j;
	}

}
