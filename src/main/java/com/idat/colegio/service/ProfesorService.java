package com.idat.colegio.service;

import java.util.List;

import com.idat.colegio.model.Profesor;


public interface ProfesorService {

	void guardar(Profesor profesor);
	void actualizar(Profesor profesor);
	void eliminar(Integer id);
	List<Profesor> listar();
	Profesor obtener(Integer id);
}
