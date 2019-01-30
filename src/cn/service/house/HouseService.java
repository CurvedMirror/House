package cn.service.house;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pojo.House;
import cn.util.Pager;

public interface HouseService {
	public List<House> findHouse(@Param("pager")Pager pager,@Param("title") String title, @Param("type_id") int type_id,
			@Param("priceMax") double priceMax, @Param("priceMin")double priceMin);
	public int getTotalCount(@Param("title") String title, @Param("type_id") int type_id,
			@Param("priceMax") double priceMax, @Param("priceMin")double priceMin);
	int insertHouse(House house);
}
