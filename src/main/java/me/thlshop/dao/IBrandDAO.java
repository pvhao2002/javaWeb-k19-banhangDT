package me.thlshop.dao;

import java.util.List;

import me.thlshop.entity.BrandEntity;

public interface IBrandDAO {
	List<BrandEntity> findAll();
	BrandEntity findOne(Integer brandId);
	Integer insert(BrandEntity brandEntity);
	void update(BrandEntity brandEntity);
	void delete(Integer brandId);
}
