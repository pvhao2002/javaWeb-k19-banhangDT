package me.thlshop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import me.thlshop.dao.IBrandDAO;
import me.thlshop.entity.BrandEntity;
import me.thlshop.utils.DBUtil;

public class BrandDAO implements IBrandDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<BrandEntity> findAll() {
		Transaction transaction = null;
		List<BrandEntity> list = null;
		String hql = "FROM BrandEntity";
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
			list = query.list();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BrandEntity findOne(Integer brandId) {
		Transaction transaction = null;
		BrandEntity brandEntity = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			brandEntity = session.get(BrandEntity.class, brandId);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return brandEntity;
	}

	@Override
	public Integer insert(BrandEntity brandEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Integer id = (Integer) session.save(brandEntity);
			transaction.commit();
			session.close();
			return id;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void update(BrandEntity brandEntity) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(brandEntity);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer brandId) {
		Transaction transaction = null;
		try {
			Session session = DBUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			BrandEntity brand = session.get(BrandEntity.class, brandId);
            if (brand != null) {
                session.delete(brand);
            }
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
