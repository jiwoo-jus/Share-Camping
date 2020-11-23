package net.skhu.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class Login {
	@Id
	private String author;
	private String user_password;
	private String user_address;
}
