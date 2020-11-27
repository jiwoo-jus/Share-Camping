
package net.skhu.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.entity.RentComment;

public interface RentCommentRepository extends JpaRepository<RentComment, Integer> {
}
