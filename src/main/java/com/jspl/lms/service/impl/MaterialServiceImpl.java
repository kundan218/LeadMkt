package com.jspl.lms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspl.lms.dao.MaterialDao;
import com.jspl.lms.model.Material;
import com.jspl.lms.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {
	@Autowired
	private MaterialDao materialDao;

	@Transactional
	@Override
	public List<Material> findAll() {
		return materialDao.findAll();
	}

	@Override
	@Transactional
	public List<Material> getMaterialList() {
		return materialDao.getMaterialList();
	}

	@Override
	@Transactional
	public Material saveMaterial(Material material) {
		material.setStatus(true);
		return materialDao.saveMaterial(material);
	}

	@Override
	@Transactional
	public boolean deleteMaterial(Integer materialId) {
		return materialDao.deleteMaterial(materialId);
	}
	

	@Transactional
	@Override
	public Material findById(Integer id) {
		return materialDao.findById(id);
	}
}
