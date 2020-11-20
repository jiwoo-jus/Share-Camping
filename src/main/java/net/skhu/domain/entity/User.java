package net.skhu.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

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
public class User {

	@Id
	@Column(length = 20, nullable = false)
	private String author;

	@Column(length = 20, nullable = false)
	private String user_password;

	@Column(columnDefinition = "TEXT", nullable = false)
    private String user_address;

	@Builder
    public User(String author, String user_password, String user_address) {
        this.author = author;
        this.user_password = user_password;
        this.user_address = user_address;
    }









}
