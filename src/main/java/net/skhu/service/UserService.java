package net.skhu.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.Setter;
import net.skhu.domain.entity.User;
import net.skhu.domain.repository.UserRepository;
import net.skhu.dto.UserDto;

@Getter
@Setter
@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public String savePost(UserDto userDto) {
        return userRepository.save(userDto.toEntity()).getAuthor();
    }


    @Transactional
    public UserDto getPost(Long author) {
    	User user = userRepository.findById(author).get();

        UserDto userDto = UserDto.builder()

                .author(user.getAuthor())
                .user_password(user.getUser_password())
                .user_password_check(user.getUser_password_check())
                .user_adress(user.getUser_adress())
                .user_email(user.getUser_email())
                .user_name(user.getUser_name())

                .build();
        return userDto;
    }




}