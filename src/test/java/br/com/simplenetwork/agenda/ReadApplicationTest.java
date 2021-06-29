
package br.com.exemplo.agenda;

import br.com.exemplo.agenda.model.Usuario;
import br.com.exemplo.agenda.service.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ReadApplicationTest{

    @Value("${mongo.user}")
    public String userName;

    @Value("${mongo.password}")
    public String password;

    @Value("${mongo.database}")
    public String database;

    @Test
    public void listApplicationParams(){
        System.out.println(password);
        Assert.assertEquals("Xp13sg13", password);
    }
}