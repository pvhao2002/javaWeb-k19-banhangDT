package me.thlshop.service;

import java.util.List;

import me.thlshop.entity.BrandEntity;

public interface IBrandService {
	List<BrandEntity> findAll();
	BrandEntity findOne(Integer branId);
	Integer save(BrandEntity brandEntity);
	void update(BrandEntity brandEntity);
	void delete(Integer brandId);
}
