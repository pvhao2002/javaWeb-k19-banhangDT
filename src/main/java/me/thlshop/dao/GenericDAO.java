package me.thlshop.dao;

import java.util.List;

import me.thlshop.mapper.RowMapper;

public interface GenericDAO<T> {
	List<T> query(String sql, RowMapper<T> rowMapper, Object... objects);

	int insert(String sql, Object... objects);

	void update(String sql, Object... parameters);
}
