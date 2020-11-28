package net.skhu.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class RentComment {
	@Id
	@GeneratedValue
	private int id;

	@Column(length = 10, nullable = false)
    private String rent_comment_content;

	@Column(length = 10, nullable = false)
    private String author;


	@ManyToOne
	@JoinColumn(name = "rent_id")
	Rent rent;


}
