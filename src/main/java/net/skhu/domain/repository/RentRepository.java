package net.skhu.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.entity.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
