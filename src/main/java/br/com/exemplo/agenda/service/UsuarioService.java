package br.com.exemplo.agenda.service;

import br.com.exemplo.agenda.repository.UsuarioRepository;
import br.com.exemplo.agenda.model.Usuario;
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
