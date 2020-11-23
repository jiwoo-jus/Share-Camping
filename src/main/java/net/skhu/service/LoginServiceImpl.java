package net.skhu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.entity.Login;
import net.skhu.domain.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginRepository userRepo;

	@Override
	public Login getUser(Login user) {
		Optional<Login> findUser = userRepo.findById(user.getAuthor());
		if(findUser.isPresent())
			return findUser.get();
		else return null;

	}
}
