package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.skhu.domain.entity.Rent;
import net.skhu.domain.repository.RentRepository;

@Service
public class RentService {

	@Autowired
	RentRepository rentrepository;

	public Page<Rent> findAll(int startAt){
		Pageable pageable = PageRequest.of(startAt, 12);
		return rentrepository.findAll(pageable);
	}

	public Page<Rent> findRendIt2Who(int startAt, String rent_type){
		Pageable pageable = PageRequest.of(startAt, 12);
		return rentrepository.findRendIt2Who(pageable, rent_type);
	}
	
	public Page<Rent> search(int startAt, String keyword){
   		Pageable pageable = PageRequest.of(startAt, 10);
   		return rentrepository.search(pageable, keyword);
   	}
}
