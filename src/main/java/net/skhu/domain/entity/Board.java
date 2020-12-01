package net.skhu.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100, nullable = false)
    private String author;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String picture;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created_date;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy="board")
	List<CommunityComment> communityComment;

    @Builder
    public Board(Long id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }
}