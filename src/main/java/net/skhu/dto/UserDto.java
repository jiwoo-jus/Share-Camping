package net.skhu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.skhu.domain.entity.User;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class UserDto {
	private String author;
	private String user_password;
	private String user_password_check;
	private String user_address;
	private String user_email;
	private String user_name;

	public User toEntity() {
        User build = User.builder()
                .author(author)
                .user_password(user_password)
                .user_address(user_address)
                .user_email(user_email)
                .user_name(user_name)
                .user_password_check(user_password_check)
                .build();
        return build;
    }

	 @Builder
	    public UserDto(String author, String user_password, String user_password_check, String user_address, String user_name, String user_email) {
	        this.author = author;
	        this.user_password = user_password;
	        this.user_address = user_address;
	        this.user_email = user_email;
	        this.user_name = user_name;
	        this.user_password_check = user_password_check;
	    }

}
