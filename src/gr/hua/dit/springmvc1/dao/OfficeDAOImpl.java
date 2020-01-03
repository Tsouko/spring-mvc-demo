package gr.hua.dit.springmvc1.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springmvc1.entity.Office;
import gr.hua.dit.springmvc1.entity.Student;

@Repository
public class OfficeDAOImpl implements OfficeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Office> getOffices() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Office> query = currentSession.createQuery("from Office order by id", Office.class);

		// execute the query and get the results list
		List<Office> offices = query.getResultList();

		// return the results
		return offices;
	}

	@Override
	@Transactional
	public void saveOffice(Office office) {
		Session currentSession = sessionFactory.getCurrentSession();

		if (office.getId() != 0) {
			// update the customer
			currentSession.update(office);
		} else {
			// save the student
			currentSession.save(office);
		}
	}

	@Override
	public Office getOffice(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Customer
		Office office = currentSession.get(Office.class, id);
		return office;
	}

	@Override
	@Transactional
	public void deleteOffice(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the Customer
		Office office = currentSession.get(Office.class, id);

		// delete Customer
		currentSession.delete(office);

	}

}
