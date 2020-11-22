package net.skhu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import net.skhu.dto.BoardDto;
import net.skhu.dto.RentDto;
import net.skhu.service.BoardService;
import net.skhu.service.RentService;

@Controller
public class BoardController {
    private BoardService boardService;
    private RentService rentService;

    public BoardController(BoardService boardService, RentService rentService) {
        this.boardService = boardService;
        this.rentService = rentService;
    }


    @GetMapping("/rent")
    public String rent(Model model) {
    	List<RentDto> rentDtoList = rentService.getRentList();
    	model.addAttribute("rentList", rentDtoList);
    	return "board/rent.html";
    }

    @GetMapping("/rentPost")
    public String rentPost(Model model) {
    	return "board/rentPost.html";
    }

    @PostMapping("/rentPost")
    public String rentPostWrite(RentDto rentDto) {
    	rentService.savePost(rentDto);
    	return "redirect:/rent";
    }

    @GetMapping("/rentPost/{rent_id}")
    public String rentDetail(@PathVariable("rent_id") Long rent_id, Model model) {
    	RentDto rentDto = rentService.getRentPost(rent_id);
    	model.addAttribute("rentPost", rentDto);
    	return "board/rentDetail.html";
    }

    @GetMapping("/rentPost/rentEdit/{rent_id}")
    public String rentEdit(@PathVariable("rent_id") Long rent_id, Model model) {
        RentDto rentDto = rentService.getRentPost(rent_id);
        model.addAttribute("rentPost", rentDto);
    	return "board/rentEdit.html";
    }

    @PutMapping("/rentPost/rentEdit/{rent_id}")
    public String rentUpdate(RentDto rentDto) {
    	rentService.savePost(rentDto);
    	return "redirect:/rent";
    }

    @DeleteMapping("/rentPost/{rent_id}")
    public String deleteRentPost(@PathVariable("rent_id") Long rent_id) {
        rentService.deleteRentPost(rent_id);
        return "redirect:/rent";
    }



    @GetMapping("/")
    public String enter(Model model) {
        return "board/home.html";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "board/home.html";
    }

    @GetMapping("/login")
    public String login() {
        return "board/login.html";
    }

    /*@GetMapping("/signin")
    public String signin() {
        return "board/signin.html";
    }*/


    //오리지널
    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDto> boardDtoList = boardService.getBoardList();
        model.addAttribute("postList", boardDtoList);
        return "board/list.html";
    }

    @GetMapping("/post")
    public String post() {
        return "board/post.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("post", boardDto);
        return "board/detail.html";
    }

    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("post", boardDto);
        return "board/edit.html";
    }

    @PutMapping("/post/edit/{id}")
    public String update(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/list";
    }

    @DeleteMapping("/post/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.deletePost(id);
        return "redirect:/list";
    }


	/*
	 * //테스트용 매핑
	 *
	 * @GetMapping("/rentPost") public String rentPost() { return
	 * "board/rentPost.html"; }
	 *
	 * @GetMapping("/rentDetail") public String rentDetail() { return
	 * "board/rentDetail.html"; }
	 *
	 * @GetMapping("/myPage") public String myPage() { return "board/myPage.html"; }
	 */


}