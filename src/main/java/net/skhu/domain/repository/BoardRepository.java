
package net.skhu.domain.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import net.skhu.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findByTitleContaining(String keyword);
	
	@Override
	@Query("SELECT b FROM Board b ORDER BY b.id DESC")
    Page<Board> findAll(Pageable pageable);

	@Query("SELECT b FROM Board b WHERE b.title LIKE '%'||:keyword||'%' ORDER BY b.id DESC")
	Page<Board> search(Pageable pageable, String keyword);
}
