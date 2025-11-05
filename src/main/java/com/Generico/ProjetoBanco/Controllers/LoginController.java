package com.Generico.ProjetoBanco.Controllers;

import com.Generico.ProjetoBanco.DTO.DTO_Login;
import com.Generico.ProjetoBanco.DTO.DTO_RESPONSE_Login;
import com.Generico.ProjetoBanco.Infraestrutura.TokenSystem.SERVICE_Token;
import com.Generico.ProjetoBanco.Model.Usuarios.Seguranca.Login_Pessoa;
import com.Generico.ProjetoBanco.Repositorys.LoginRepository;
import com.Generico.ProjetoBanco.Services.SERVICE_Mail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Logins", description = "Controlador de login de usuários com JWT e oAuth")
@RestController
@RequestMapping(path = "/Login")
public class LoginController {

    @Autowired
    SERVICE_Mail mailService;

    @Autowired
    SERVICE_Token tokenService;

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    LoginRepository loginRepository;

    @Operation(summary = "Efetua o login dos usuários")
    @PostMapping
    @RequestMapping(path = "/log")
    public ResponseEntity login(@RequestBody @Valid DTO_Login login){
        var usernamePassword = new UsernamePasswordAuthenticationToken(login.email(), login.senha());
        // O código vai passar por SERVICE_Login
        var auth = authenticationManager.authenticate(usernamePassword);
        // A partir daqui o código vai pra SERVICE_TOKEN!
        var token = tokenService.generateToken((Login_Pessoa) auth.getPrincipal());

        return ResponseEntity.ok(mailService.enviarEmail(login.email(), new DTO_RESPONSE_Login(token).token(), "Token de login ProjetoP4: "));
    }

    @Operation(summary = "Registra logins de usuários", responses = {@ApiResponse(responseCode = "200", description = "Registra um usuário com email, senha e roles")})
    @PostMapping
    @RequestMapping(path = "/reg")
    public ResponseEntity<Login_Pessoa> register(@RequestBody @Valid DTO_Login login){
        return ResponseEntity.ok(loginRepository.save(new Login_Pessoa(login.email(), passwordEncoder.encode(login.senha()), login.roles())));
    }

}
