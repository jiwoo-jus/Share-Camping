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

	@Query("SELECT r FROM Rent r WHERE r.rent_kind = :rent_type ORDER BY r.rent_id DESC")
    Page<Rent> findRendIt2Who(Pageable pageable, String rent_type);

	@Query("SELECT r FROM Rent r WHERE r.rent_title LIKE '%'||:keyword||'%' ORDER BY r.rent_id DESC")
	Page<Rent> search(Pageable pageable, String keyword);
}
