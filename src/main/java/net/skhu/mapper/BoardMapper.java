package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.domain.entity.Board;

@Mapper
public interface BoardMapper {

    @Select("SELECT *              "
          + "FROM board "
          + "ORDER BY id DESC " )
    List<Board> findAll();

    @Select("SELECT count(title)	"
    		+ "FROM board " )
    int getBoardCount();

}
