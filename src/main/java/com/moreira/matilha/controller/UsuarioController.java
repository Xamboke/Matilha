package com.moreira.matilha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moreira.matilha.model.Usuario;
import com.moreira.matilha.model.UsuarioDTO;
import com.moreira.matilha.service.UsuarioService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/usuario")
@Api
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public Usuario criar(@RequestBody UsuarioDTO dtoUsuario) {

		return usuarioService.criar(dtoUsuario);
	}

	@GetMapping("/get")
	public List<Usuario> listarTodos() {

		return usuarioService.listarTodos();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {

		UsuarioDTO dtoUsuario = usuarioService.buscarPorId(id);
		return new ResponseEntity<>(dtoUsuario, HttpStatus.OK);

	}

}
