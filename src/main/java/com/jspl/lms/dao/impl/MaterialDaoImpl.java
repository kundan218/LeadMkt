package com.jspl.lms.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspl.lms.dao.GenericDao;
import com.jspl.lms.dao.MaterialDao;
import com.jspl.lms.model.Material;

@Repository
public class MaterialDaoImpl implements MaterialDao, GenericDao<Material, Integer>{
	
	@Autowired
	private SessionFactory sessionFactory;

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> findAll() {
		Session session=sessionFactory.getCurrentSession();
		List<Material> materials=null;
		try{
			materials=session.createQuery("From Material where status is true ").list();
		}catch(HibernateException he){
			he.printStackTrace();
		}
		return materials;
	}



	@Override
	public Material findById(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Material material=null;
		try{
			material=(Material) session.createQuery("From Material m where m.materialPkId=:id and m.status=1")
					.setParameter("id", id)
					.setFirstResult(0)
					.setMaxResults(1)
					.uniqueResult();
		}catch(HibernateException he){
			he.printStackTrace();
		}
		return material;
	}



	@Override
	public Material saveOrUpdate(Material object) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void delete(Material object) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> getMaterialList() {
		return sessionFactory.openSession().createQuery("FROM Material WHERE status is true").list();
	}


	@Override
	public Material saveMaterial(Material material) {
		 try{
				Session session=sessionFactory.getCurrentSession();
				session.saveOrUpdate(material);
			  }catch(HibernateException he){
				he.printStackTrace();
			}
					return material;
	}



	@Override
	public boolean deleteMaterial(Integer materialId) {
		boolean flag = false;
		Session session= sessionFactory.getCurrentSession();
		try{
			Material material =  (Material) session.load(Material.class, materialId);
			if(material!=null){
				material.setStatus(false);
		    session.update(material);
		    flag=true;
			}
		}catch(HibernateException he){
            he.printStackTrace();
            flag = false;
    }
		return false;
	}



	@Override
	public Material findByMaterialDmsId(String materialDmsId) {
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Material mat where mat.materialDmsId = :materialDmsId");
		query.setParameter("materialDmsId", materialDmsId);
		return (Material) query.uniqueResult();
	}


	
}
