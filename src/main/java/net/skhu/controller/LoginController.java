package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.skhu.domain.entity.Login;
import net.skhu.service.LoginService;

@SessionAttributes("user")
@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public String loginView() {
		return "board/login.html";
	}

	@PostMapping("/login")
	public String login(Login user,Model model) {
		Login findUser = loginService.getUser(user);

		if(findUser == null) {
			return "board/rent.html";
		}
		if(findUser != null
				&& findUser.getUser_password().equals(user.getUser_password())) {
			model.addAttribute("user", findUser);
			return "board/list.html";
		}else {
			return "redirect:login";
		}
	}
}
