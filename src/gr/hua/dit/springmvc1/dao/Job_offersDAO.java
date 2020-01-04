package gr.hua.dit.springmvc1.dao;

import java.util.List;

import gr.hua.dit.springmvc1.entity.Job_offers;
import gr.hua.dit.springmvc1.entity.Office;

public interface Job_offersDAO {
	
	public List<Job_offers> getJob_offers();

	public void saveJob_offers(Job_offers job_offers);
	
	public Job_offers getJob_offer(int id);

	public void deleteJob_offer(int id);
}
