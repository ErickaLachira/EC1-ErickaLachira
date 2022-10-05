package com.idat.colegio.service;

import java.util.List;

import com.idat.colegio.model.MallaCurricular;

public interface MallaCurricularService {

	void guardar(MallaCurricular malla);
	void actualizar(MallaCurricular malla);
	void eliminar(Integer id);
	List<MallaCurricular> listar();
	MallaCurricular obtener(Integer id);
}
