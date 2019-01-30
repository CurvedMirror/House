package cn.service.house.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dao.House.HouseMapper;
import cn.pojo.House;
import cn.service.house.HouseService;
import cn.util.Pager;

@Transactional
@Service("houseService")
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	private HouseMapper houseMapper;
	
	@Transactional(readOnly=true)
	@Override
	public List<House> findHouse(Pager pager,String title, int type_id, double priceMax,
			double priceMin) {
		return houseMapper.findHouse(pager,title, type_id, priceMax, priceMin);
	}

	@Override
	public int getTotalCount(String title, int type_id,
			double priceMax, double priceMin) {
		
		return houseMapper.getTotalCount( title, type_id, priceMax, priceMin);
	}

	@Override
	public int insertHouse(House house) {
		// TODO Auto-generated method stub
		return houseMapper.insertHouse(house);
	}
}
