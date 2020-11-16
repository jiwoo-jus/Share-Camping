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
import net.skhu.service.BoardService;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @GetMapping("/")
    public String enter(Model model) {
        return "board/home.html";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "board/home.html";
    }

    @GetMapping("/rent")
    public String rent() {
        return "board/rent.html";
    }

    @GetMapping("/login")
    public String login() {
        return "board/login.html";
    }

    @GetMapping("/signin")
    public String signin() {
        return "board/signin.html";
    }


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
        return "redirect:/";
    }

    @DeleteMapping("/post/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.deletePost(id);
        return "redirect:/";
    }

    //테스트용 매핑
    @GetMapping("/rentPost")
    public String rentPost() {
        return "board/rentPost.html";
    }
    @GetMapping("/rentDetail")
    public String rentDetail() {
        return "board/rentDetail.html";
    }
    @GetMapping("/myPage")
    public String myPage() {
        return "board/myPage.html";
    }
}