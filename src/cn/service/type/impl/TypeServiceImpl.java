package cn.service.type.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dao.type.TypeMapper;
import cn.pojo.Type;
import cn.service.type.TypeService;

@Service("typeService")
public class TypeServiceImpl implements TypeService{

	@Autowired
	private TypeMapper typeMapper;	
	
	@Override
	public List<Type> getAllType() {
		return typeMapper.getAllType();
	}

}
