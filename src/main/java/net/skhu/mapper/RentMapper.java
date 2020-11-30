package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.domain.entity.Rent;

@Mapper
public interface RentMapper {

    @Select("SELECT *              "
          + "FROM rent "
          + "ORDER BY rent_id DESC " )
    List<Rent> findAll();

}
