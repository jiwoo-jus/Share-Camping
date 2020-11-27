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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */
public class Rent {

	@Id
    @GeneratedValue
    private Long rent_id;

	@Column(length = 10, nullable = false)
    private String author;

	@Column(length = 100, nullable = false)
    private String rent_title;


	@Column(length = 100, nullable = false)
    private String picture;

	@Column(columnDefinition = "TEXT", nullable = false)
    private String rent_content;

	@CreatedDate
    @Column(updatable = false)
    private LocalDateTime rent_date;

	@OneToMany(mappedBy="rent")
	List<RentComment> rentComment;


    @Builder
    public Rent(Long rent_id, String author, String rent_title, String rent_content, String picture
    	) {
        this.rent_id = rent_id;
        this.author = author;
        this.rent_title = rent_title;
        this.rent_content = rent_content;
        this.picture = picture;

    }

}
