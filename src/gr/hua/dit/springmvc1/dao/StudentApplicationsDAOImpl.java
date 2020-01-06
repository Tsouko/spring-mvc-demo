package gr.hua.dit.springmvc1.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springmvc1.entity.Customer;
import gr.hua.dit.springmvc1.entity.Student;
import gr.hua.dit.springmvc1.entity.StudentApplications;


@Repository
public class StudentApplicationsDAOImpl implements StudentApplicationsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<StudentApplications> getStdApps() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<StudentApplications> query = currentSession.createQuery("from StudentApplications order by id", StudentApplications.class);

		// execute the query and get the results list
		List<StudentApplications> Studentapplications = query.getResultList();

		// return the results
		return Studentapplications;
	}

	@Override
	@Transactional
	public void saveStdApps(StudentApplications Studentapplications) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

			currentSession.save(Studentapplications);
		
	}

	@Override
	public StudentApplications getStdApps(int id) {
		// get current hibernate session
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Student
		StudentApplications Studentapplications = currentSession.get(StudentApplications.class, id);
		
		return Studentapplications;
	}

	@Override
	public void deleteStdApps(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// find the Student
		StudentApplications Studentapplications = currentSession.get(StudentApplications.class, id);

		// delete Student
		currentSession.delete(Studentapplications);
	}

}



