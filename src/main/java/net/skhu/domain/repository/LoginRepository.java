package net.skhu.domain.repository;

import org.springframework.data.repository.CrudRepository;

import net.skhu.domain.entity.Login;

public interface LoginRepository extends CrudRepository<Login, String> {
}
