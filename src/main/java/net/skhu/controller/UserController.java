package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.skhu.dto.UserDto;
import net.skhu.service.UserService;

@Controller
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
        this.userService = userService;
    }

	@GetMapping("/signin")
    public String signin() {
        return "board/signin.html";
    }
	@PostMapping("/signin")
    public String singin(UserDto userDto) {
        userService.savePost(userDto);
        return "redirect:/";
    }
}
