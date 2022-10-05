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

import com.idat.colegio.model.MallaCurricular;
import com.idat.colegio.service.MallaCurricularService;


@RestController
@RequestMapping("/malla/v1")
public class MallaCurricularController {

	@Autowired
	private MallaCurricularService mallaservice;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<MallaCurricular>> listar(){
		return new ResponseEntity<List<MallaCurricular>>(mallaservice.listar(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaCurricular malla){
		mallaservice.guardar(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/(id)")
	public ResponseEntity<MallaCurricular> obtenerPorId(@PathVariable Integer id){
		MallaCurricular malla = mallaservice.obtener(id);
		
		if(malla != null) {
			return new ResponseEntity<MallaCurricular>(malla, HttpStatus.OK);
		}else {
			return new ResponseEntity<MallaCurricular>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody MallaCurricular malla){
		MallaCurricular m = mallaservice.obtener(malla.getIdMalla());
		if(m != null) {
			mallaservice.actualizar(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		MallaCurricular malla = mallaservice.obtener(id);
		if(malla != null) {
			mallaservice.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
