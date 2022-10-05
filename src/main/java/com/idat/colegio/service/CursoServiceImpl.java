package com.idat.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.colegio.model.Curso;
import com.idat.colegio.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursorepositorio;
	@Override
	public void guardar(Curso curso) {
		// TODO Auto-generated method stub
		cursorepositorio.save(curso);
	}

	@Override
	public void actualizar(Curso curso) {
		// TODO Auto-generated method stub
		cursorepositorio.saveAndFlush(curso);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		cursorepositorio.deleteById(id);
	}

	@Override
	public List<Curso> listar() {
		// TODO Auto-generated method stub
		return cursorepositorio.findAll();
	}

	@Override
	public Curso obtener(Integer id) {
		// TODO Auto-generated method stub
		return cursorepositorio.findById(id).orElse(null);
	}

}
