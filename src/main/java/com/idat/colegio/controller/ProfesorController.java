package com.idat.colegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.colegio.model.Profesor;
import com.idat.colegio.service.ProfesorService;

@RestController
@RequestMapping("/profesor/v1")
public class ProfesorController {

	@Autowired
	private ProfesorService profservice;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listar(){
		return new ResponseEntity<List<Profesor>>(profservice.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Profesor profesor){
		profservice.guardar(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/(id)")
	public ResponseEntity<Profesor> obtenerPorId(@PathVariable Integer id){
		Profesor profesor = profservice.obtener(id);
		
		if(profesor != null) {
			return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);
		}else {
			return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Profesor profesor){
		Profesor p = profservice.obtener(profesor.getIdProfesor());
		if(p != null) {
			profservice.actualizar(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		Profesor profesor = profservice.obtener(id);
		if(profesor != null) {
			profservice.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
