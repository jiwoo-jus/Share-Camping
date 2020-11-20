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
	private String user_address;

	public User toEntity() {
        User build = User.builder()

                .author(author)
                .user_password(user_password)
                .user_address(user_address)
                .build();
        return build;
    }

	 @Builder
	    public UserDto(String author, String user_password, String user_address) {
	        this.author = author;
	        this.user_password = user_password;
	        this.user_address = user_address;
	    }
}
