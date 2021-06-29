package br.com.exemplo.agenda.repository;

import br.com.exemplo.agenda.model.Usuario;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository {

    private final MongoTemplate template;

    public UsuarioRepository(MongoTemplate template) {
        this.template = template;
    }

    public List<Usuario> listaUsuarios(){
        List<Usuario> lista = this.template.findAll(Usuario.class);
        return lista;
    }

    public Usuario salvaUsuario(Usuario usuario){
        return this.template.insert(usuario);
    }

}
