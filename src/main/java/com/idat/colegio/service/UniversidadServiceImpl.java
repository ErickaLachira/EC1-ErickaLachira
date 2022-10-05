package com.idat.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.colegio.model.Universidad;
import com.idat.colegio.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService {

	@Autowired
	private UniversidadRepository univrepositorio;
	
	@Override
	public void guardar(Universidad universidad) {
		// TODO Auto-generated method stub
		univrepositorio.save(universidad);
	}

	@Override
	public void actualizar(Universidad universidad) {
		// TODO Auto-generated method stub
		univrepositorio.saveAndFlush(universidad);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		univrepositorio.deleteById(id);
	}

	@Override
	public List<Universidad> listar() {
		// TODO Auto-generated method stub
		return univrepositorio.findAll();
	}

	@Override
	public Universidad obtener(Integer id) {
		// TODO Auto-generated method stub
		return univrepositorio.findById(id).orElse(null);
	}

}
