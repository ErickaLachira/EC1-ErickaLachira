package com.idat.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.colegio.model.MallaCurricular;
import com.idat.colegio.repository.MallaCurricularRepository;

@Service
public class MallaCurricularServiceImpl implements MallaCurricularService {

	@Autowired
	private MallaCurricularRepository mallarepositorio;
	@Override
	public void guardar(MallaCurricular malla) {
		// TODO Auto-generated method stub
		mallarepositorio.save(malla);
	}

	@Override
	public void actualizar(MallaCurricular malla) {
		// TODO Auto-generated method stub
		mallarepositorio.saveAndFlush(malla);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		mallarepositorio.deleteById(id);
	}

	@Override
	public List<MallaCurricular> listar() {
		// TODO Auto-generated method stub
		return mallarepositorio.findAll();
	}

	@Override
	public MallaCurricular obtener(Integer id) {
		// TODO Auto-generated method stub
		return mallarepositorio.findById(id).orElse(null);
	}

}
