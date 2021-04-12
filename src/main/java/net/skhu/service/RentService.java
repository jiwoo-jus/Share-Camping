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
		Pageable pageable = PageRequest.of(startAt, 9);
		return rentrepository.findAll(pageable);
	}

}
