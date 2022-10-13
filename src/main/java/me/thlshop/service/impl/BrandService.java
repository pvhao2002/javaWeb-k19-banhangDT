package me.thlshop.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.thlshop.dao.IBrandDAO;
import me.thlshop.entity.BrandEntity;
import me.thlshop.service.IBrandService;

public class BrandService implements IBrandService{

	@Inject
	private IBrandDAO brandDAO;
	
	@Override
	public List<BrandEntity> findAll() {
		return brandDAO.findAll();
	}

	@Override
	public BrandEntity findOne(Integer branId) {
		return brandDAO.findOne(branId);
	}

	@Override
	public Integer save(BrandEntity brandEntity) {
		return brandDAO.insert(brandEntity);
	}

	@Override
	public void update(BrandEntity brandEntity) {
		brandDAO.update(brandEntity);
	}

	@Override
	public void delete(Integer brandId) {
		brandDAO.delete(brandId);
	}

}
