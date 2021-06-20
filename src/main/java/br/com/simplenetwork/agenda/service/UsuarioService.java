package br.com.simplenetwork.agenda.service;

import br.com.simplenetwork.agenda.repository.UsuarioRepository;
import br.com.simplenetwork.agenda.model.Usuario;
import br.com.simplenetwork.agenda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listaUsuarios(){
        return repository.listaUsuarios();
    }

    public Usuario salvaUsuario(Usuario usuario){
        return repository.salvaUsuario(usuario);
    }
}
