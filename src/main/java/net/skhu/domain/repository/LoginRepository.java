package net.skhu.domain.repository;

import org.springframework.data.repository.CrudRepository;

import net.skhu.domain.entity.User;

public interface LoginRepository extends CrudRepository<User, String> {
}
