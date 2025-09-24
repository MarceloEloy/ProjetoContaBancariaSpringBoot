package com.Generico.ProjetoBanco.Controllers;

import com.Generico.ProjetoBanco.DTO.DTO_Login;
import com.Generico.ProjetoBanco.Infraestrutura.SERVICE_Token;
import com.Generico.ProjetoBanco.Model.Usuarios.Login_Pessoa;
import com.Generico.ProjetoBanco.Repositorys.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Login")
public class LoginController {

    @Autowired
    SERVICE_Token tokenService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    LoginRepository loginRepository;

    @PostMapping
    @RequestMapping(path = "/log")
    public ResponseEntity login(@RequestBody DTO_Login login){
        var usernamePassword = new UsernamePasswordAuthenticationToken(login.login(), login.senha());
        var auth = authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok(tokenService.generateToken((Login_Pessoa) auth.getPrincipal()));
    }

    @PostMapping
    @RequestMapping(path = "/reg")
    public ResponseEntity<Login_Pessoa> register(@RequestBody DTO_Login login){
        return ResponseEntity.ok(loginRepository.save(new Login_Pessoa(login.login(), passwordEncoder.encode(login.senha()))));
    }

}
