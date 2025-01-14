package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.domain.entity.Board;


@Mapper
public interface BoardMapper {

    @Select("SELECT * "
          + "FROM board "
          + "ORDER BY id DESC " )
    
    List<Board> findAll();
    
    
    @Select("SELECT *              "
            + "FROM board "
            + "WHERE title LIKE CONCAT('%',#{keyword}, '%') "
            + "ORDER BY id DESC " )
   
      List<Board> search(String keyword);

    @Select("SELECT count(title)	"
    		+ "FROM board " )
    int getBoardCount();

    @Delete("DELETE FROM community_comment "
    		+ "WHERE board_id = #{id};"
    		+"DELETE FROM board "
    		+"WHERE id = #{id}")
    void deleteBoard(Long id);

}
