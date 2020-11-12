
package net.skhu.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
