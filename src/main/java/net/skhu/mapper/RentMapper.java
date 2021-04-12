package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.domain.entity.Rent;

@Mapper
public interface RentMapper {

    @Select("SELECT *              "
          + "FROM rent "
          + "ORDER BY rent_id DESC " )
    List<Rent> findAll();

    @Delete("DELETE FROM rent_comment "
    		+ "WHERE rent_id = #{id};"
    		+"DELETE FROM rent "
    		+"WHERE rent_id = #{id}")
    void deleteRent(Long id);
    
    @Select("SELECT * "
            + "FROM rent "
            + "WHERE rent_title LIKE CONCAT('%',#{keyword}, '%') "
            + "ORDER BY rent_id DESC " )
      List<Rent> searchRent(String keyword);
    
    @Select("SELECT count(rent_title) "
    		+ "FROM rent")
    int getRentCount();
}
