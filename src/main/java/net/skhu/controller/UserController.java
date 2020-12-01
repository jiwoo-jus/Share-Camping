
package net.skhu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.domain.entity.User;
import net.skhu.domain.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/signin")
	public String signin() {
		return "board/signin.html";
	}

	@PostMapping("/signin")
	public String singin(Model model, User userDto, HttpSession session) {
		userRepository.save(userDto);

		String errorMsg = null;
		if (userDto.getAuthor() == null || userDto.getAuthor().length() == 0)
			errorMsg = "사용자 아이디를 입력하세요";
		else if (userDto.getUser_name() == null || userDto.getUser_name().length() == 0)
			errorMsg = "이름을 입력하세요";
		else if (userDto.getUser_password() == null || userDto.getUser_password().length() == 0)
			errorMsg = "비밀번호1을 입력하세요";
		else if (userDto.getUser_password_check() == null || userDto.getUser_password_check().length() == 0)
			errorMsg = "비밀번호2를 입력하세요";
		else if (userDto.getUser_password().equals(userDto.getUser_password_check()) == false)
			errorMsg = "비밀번호 불일치";
		else if (userDto.getUser_email() == null || userDto.getUser_email().length() == 0)
			errorMsg = "이메일 주소를 입력하세요";


		else {
			session.setAttribute("userDto", userDto);
			return "board/signin_success";
		}
		model.addAttribute("userDto", userDto);
		model.addAttribute("errorMsg", errorMsg);

		return "board/signin.html";
	}

	@RequestMapping("/signin_succes")
	public String signin_success(Model model) {
		return "board/signin_succes.html";
	}
}