package net.skhu.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.skhu.domain.entity.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {


	@Override
	@Query("SELECT r FROM Rent r ORDER BY r.rent_id DESC")
    Page<Rent> findAll(Pageable pageable);

}
