package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.skhu.domain.entity.Board;
import net.skhu.domain.entity.CommunityComment;
import net.skhu.domain.entity.Rent;
import net.skhu.domain.entity.RentComment;
import net.skhu.domain.entity.User;
import net.skhu.domain.repository.BoardRepository;
import net.skhu.domain.repository.CommunityCommentRepository;
import net.skhu.domain.repository.RentCommentRepository;
import net.skhu.domain.repository.RentRepository;
import net.skhu.mapper.BoardMapper;
import net.skhu.mapper.RentMapper;
import net.skhu.service.RentService;

@SessionAttributes("user")
@Controller
public class BoardController {
	@Autowired
	RentRepository rentRepository;
	@Autowired
	RentCommentRepository rentCommentRepository;
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	CommunityCommentRepository communityCommentRepository;
	@Autowired
	BoardMapper boardMapper;
	@Autowired
	RentMapper rentMapper;
	@Autowired
	RentService rentService;



	/*********************************************** 메인페이지 *******************************************************/
	@GetMapping("/")
	public String enter(Model model) {
		return "board/index.html";
	}

	@GetMapping("/home")
	public String home(Model model) {
		return "board/home.html";
	}




	/*********************************************** 커뮤니티페이지 *******************************************************/

	@GetMapping("/list")
	public String list(Model model) {
		int boardPostCount = boardMapper.getBoardCount();
		model.addAttribute("boardPostCount", boardPostCount);
		model.addAttribute("postList", boardMapper.findAll());
		return "board/list.html";
	}


	@GetMapping("/list/search")
	public String search(Model model,@RequestParam(value="keyword", defaultValue = "",required = false) String keyword) {
		List <Board> boardDtoList = boardMapper.search(keyword);
		int boardPostCount = boardMapper.getBoardCount();
		model.addAttribute("boardPostCount", boardPostCount);
		model.addAttribute("postList", boardDtoList);
		return "board/list.html";
	}

	@GetMapping("/post")
	public String post() {
		return "board/post.html";
	}

	@PostMapping("/post")
	public String write(Board board) {
		boardRepository.save(board);

		return "redirect:/list";
	}

	@PostMapping("/communityCommentPost")
	public String communityCommentWrite(@ModelAttribute("post") Board board, CommunityComment communityComment) {
		communityComment.setId(99999);
		communityComment.setBoard(board);
		communityCommentRepository.save(communityComment);

		return "redirect:/post/" + board.getId();
	}

	@GetMapping("/post/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		Board board = boardRepository.getOne(id);
		model.addAttribute("post", board);

		return "board/detail.html";
	}

	@GetMapping("/post/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Board board = boardRepository.getOne(id);
		model.addAttribute("post", board);

		return "board/edit.html";
	}

	@PutMapping("/post/edit/{id}")
	public String update(Board board) {
		boardRepository.save(board);

		return "redirect:/post/" + board.getId();

	}

	@DeleteMapping("/post/{id}")
	public String delete(@PathVariable("id") Long id) {
		boardMapper.deleteBoard(id);

		return "redirect:/list";
	}



	/*********************************************** 렌트페이지 *******************************************************/

	@GetMapping("/rent")
	public String rentlist(@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
		String nullimage = "<img src=\"images/nullimage.png\">";
		model.addAttribute("nullimage", nullimage);
		Page<Rent> rentList = rentService.findAll(page);
		model.addAttribute("pages", rentList);
		model.addAttribute("maxPage", 10);
		return "board/rent.html";
	}

	@GetMapping("/rentPost")
	public String rentPost(Model model) {
		return "board/rentPost.html";
	}

	@PostMapping("/rentPost")
	public String rentPostWrite(@ModelAttribute("user") User user, Rent rentDto) {
		rentRepository.save(rentDto);

		return "redirect:/rent";
	}

	@PostMapping("/rentCommentPost")
	public String rentCommentWrite(@ModelAttribute("rentPost") Rent rent, RentComment rentComment) {
		rentComment.setRent(rent);
		rentCommentRepository.save(rentComment);

		return "redirect:/rentPost/" + rent.getRent_id();
	}

	@GetMapping("/rentPost/{rent_id}")
	public String rentDetail(@PathVariable("rent_id") Long rent_id, Model model) {
		Rent rent = rentRepository.getOne(rent_id);
		model.addAttribute("rentPost", rent);

		return "board/rentDetail.html";
	}

	@GetMapping("/rentPost/rentEdit/{rent_id}")
	public String rentEdit(@PathVariable("rent_id") Long rent_id, Model model,String[] wantRent) {
		Rent rent = rentRepository.getOne(rent_id);
		model.addAttribute("rentPost", rent);

		return "board/rentEdit.html";
	}

	@PutMapping("/rentPost/rentEdit/{rent_id}")
	public String rentUpdate(Rent rentDto) {
		rentRepository.save(rentDto);

		return "redirect:/rentPost/" + rentDto.getRent_id();
	}

	@DeleteMapping("/rentPost/{rent_id}")
	public String deleteRentPost(@PathVariable("rent_id") Long rent_id) {
		rentMapper.deleteRent(rent_id);

		return "redirect:/rent";
	}

	@GetMapping("/rent/search")
	public String rentSearch(Model model, @RequestParam(value="keyword", defaultValue="", required=false)String keyword) {
		List<Rent> rentList = rentMapper.searchRent(keyword);
		int rentPostCount = rentMapper.getRentCount();
		model.addAttribute("RentPostCount", rentPostCount);
		model.addAttribute("rentList", rentList);
		return "board/rent.html";
	}




	/*********************************************** 마이페이지 *******************************************************/
	@GetMapping("/myPage")
	public String myPage(Model model) {
		model.addAttribute("postList", boardRepository.findAll());
		model.addAttribute("postList", boardMapper.findAll());
		model.addAttribute("rentList", rentRepository.findAll());
		model.addAttribute("rentList", rentMapper.findAll());
		model.addAttribute("communityCommentList", communityCommentRepository.findAll());
		model.addAttribute("rentCommentList", rentCommentRepository.findAll());

		return "board/myPage.html";
	}

}