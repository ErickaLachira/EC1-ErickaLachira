package com.idat.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.colegio.model.Profesor;
import com.idat.colegio.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	@Autowired
	private ProfesorRepository profrepositorio;

	@Override
	public void guardar(Profesor profesor) {
		// TODO Auto-generated method stub
		profrepositorio.save(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
		profrepositorio.saveAndFlush(profesor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		profrepositorio.deleteById(id);
	}

	@Override
	public List<Profesor> listar() {
		// TODO Auto-generated method stub
		return profrepositorio.findAll();
	}

	@Override
	public Profesor obtener(Integer id) {
		// TODO Auto-generated method stub
		return profrepositorio.findById(id).orElse(null);
	}

}
