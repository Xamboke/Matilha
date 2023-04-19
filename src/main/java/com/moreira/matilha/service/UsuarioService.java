package com.moreira.matilha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moreira.matilha.model.Usuario;
import com.moreira.matilha.model.UsuarioDTO;
import com.moreira.matilha.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario criar(UsuarioDTO dtoUsuario) {

		Usuario usuario = new Usuario();

		usuario.setNome(dtoUsuario.getNome());
		usuario.setSenha(dtoUsuario.getSenha());

		return usuarioRepository.save(usuario);

	}

	public List<Usuario> listarTodos() {

		return usuarioRepository.findAll();

	}
	
	public UsuarioDTO buscarPorId(Long id) {
		
		UsuarioDTO dtoUsuario = new UsuarioDTO();
		
		dtoUsuario.setNome(usuarioRepository.getById(id).getNome());
		dtoUsuario.setSenha(usuarioRepository.getById(id).getSenha());
		
		return dtoUsuario;
		
	}

}
