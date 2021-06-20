package br.com.simplenetwork.agenda.controller;

import br.com.simplenetwork.agenda.model.Usuario;
import br.com.simplenetwork.agenda.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
    private Charset charset = Charset.forName("UTF-8");

    @Autowired
    private UsuarioService service;


    @GetMapping( path = "/usuario")
    public ResponseEntity list() {
        System.out.println(service.listaUsuarios());
        return ResponseEntity.ok().body(service.listaUsuarios());
    }

    @PostMapping( path = "/usuario")
    public ResponseEntity save(@RequestBody Usuario usuario) {
        return ResponseEntity.ok().body(service.salvaUsuario(usuario));
    }

}
