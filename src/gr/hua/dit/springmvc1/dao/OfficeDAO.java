package gr.hua.dit.springmvc1.dao;

import java.util.List;

import gr.hua.dit.springmvc1.entity.Job_offers;
import gr.hua.dit.springmvc1.entity.Office;

public interface OfficeDAO {
	public List<Office> getOffices();

	public void saveOffice(Office office);
	
	public Office getOffice(int id);

	public void deleteOffice(int id);
}
