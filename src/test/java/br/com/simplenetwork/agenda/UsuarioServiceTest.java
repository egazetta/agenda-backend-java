package br.com.simplenetwork.agenda;

import br.com.simplenetwork.agenda.model.Usuario;
import br.com.simplenetwork.agenda.service.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

    @Autowired
    UsuarioService service;

    @Test
    public void testarListarUsuarios(){
        final List<Usuario> lista = service.listaUsuarios();
        Assert.assertEquals(1, lista.size());
    }
}
