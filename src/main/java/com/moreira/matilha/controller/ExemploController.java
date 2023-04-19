package com.moreira.matilha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moreira.matilha.model.ExemploDTO;
import com.moreira.matilha.service.ExemploService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/exemplo")
@Api
public class ExemploController {

	@Autowired
	private ExemploService exemploService;

	@GetMapping("/{id}")
	public ResponseEntity<ExemploDTO> buscarPorId(@PathVariable Long id) {
		ExemploDTO exemplo = exemploService.buscarPorId(id);
		return new ResponseEntity<>(exemplo, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ExemploDTO> criar(@RequestBody ExemploDTO exemplo) {
		ExemploDTO exemploCriado = exemploService.criar(exemplo);
		return new ResponseEntity<>(exemploCriado, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExemploDTO> atualizar(@PathVariable Long id, @RequestBody ExemploDTO exemplo) {
		exemplo.setId(id);
		ExemploDTO exemploAtualizado = exemploService.atualizar(exemplo);
		return new ResponseEntity<>(exemploAtualizado, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		exemploService.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
