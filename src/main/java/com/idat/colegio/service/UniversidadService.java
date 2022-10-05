package com.idat.colegio.service;

import java.util.List;

import com.idat.colegio.model.Universidad;

public interface UniversidadService {

	void guardar(Universidad universidad);
	void actualizar(Universidad universidad);
	void eliminar(Integer id);
	List<Universidad> listar();
	Universidad obtener(Integer id);
}
