package me.thlshop.converter;

import me.thlshop.dto.BrandDTO;
import me.thlshop.entity.BrandEntity;

public class BrandConverter {
	public BrandEntity toEntity(BrandDTO brandDTO) {
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setBrandName(brandDTO.getBrandName());
		brandEntity.setLogo(brandDTO.getLogo());
		return brandEntity;
	}
	
	public BrandDTO toDto(BrandEntity brandEntity) {
		BrandDTO brandDTO = new BrandDTO();
		brandDTO.setBrandId(brandEntity.getBrandId());
		brandDTO.setBrandName(brandEntity.getBrandName());
		brandDTO.setLogo(brandEntity.getLogo());
		return brandDTO;
	}
}
