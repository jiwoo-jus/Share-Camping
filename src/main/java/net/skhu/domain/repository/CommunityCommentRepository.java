package net.skhu.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.entity.CommunityComment;

public interface CommunityCommentRepository extends JpaRepository<CommunityComment, Long> {
}
