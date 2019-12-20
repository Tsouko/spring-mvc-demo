package gr.hua.dit.springmvc1.dao;

import java.util.List;

import gr.hua.dit.springmvc1.entity.Customer;
import gr.hua.dit.springmvc1.entity.StudentApplications;

public interface StudentApplicationsDAO {
public List<StudentApplications> getStdApps();
	
	public void saveStdApps(StudentApplications studentApplications);
	
	public Customer getStdApps(int id);

	public void deleteStdApps(int id);
}

