
package net.skhu.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
