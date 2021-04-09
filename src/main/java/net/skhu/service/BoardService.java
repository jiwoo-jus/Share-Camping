package net.skhu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.Setter;
import net.skhu.domain.entity.Board;
import net.skhu.domain.repository.BoardRepository;
import net.skhu.dto.BoardDto;

@Getter
@Setter
@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
/*
    @Transactional
    public List<BoardDto> getBoardList(String keyword) {
        List<Board> boardList = boardRepository.findAll(keyword);
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board : boardList) {
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .author(board.getAuthor())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .createdDate(board.getCreated_date())
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }
    */
    @Transactional
    public List<BoardDto> getBoardList(String keyword) {
        List<Board> boardList = boardRepository.findByTitleContaining(keyword);
        List<BoardDto> boardDtoList = new ArrayList<>();
        
        if (boardList.isEmpty()) return boardDtoList;

        for(Board board : boardList) {
            boardDtoList.add(this.convertEntityToDto(board));
        }
        return boardDtoList;
    }
    
    private BoardDto convertEntityToDto(Board board) {
    	return BoardDto.builder()
        .id(board.getId())
        .author(board.getAuthor())
        .title(board.getTitle())
        .content(board.getContent())
        .createdDate(board.getCreated_date())
        .build();
    	
    }

    @Transactional
    public BoardDto getPost(Long id) {
        Board board = boardRepository.findById(id).get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .author(board.getAuthor())
                .title(board.getTitle())
                .content(board.getContent())
                .createdDate(board.getCreated_date())
                .build();
        return boardDto;
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }
}
