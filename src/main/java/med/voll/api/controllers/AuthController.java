package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.domain.dto.user.UserDataLoginRequest;
import med.voll.api.domain.entity.TokenService;
import med.voll.api.domain.entity.user.User;
import med.voll.api.infra.security.DataTokenJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserDataLoginRequest userDataLoginRequest){
        var tokenAuth = new UsernamePasswordAuthenticationToken(userDataLoginRequest.username(), userDataLoginRequest.password());
        var auth = manager.authenticate(tokenAuth);

        var tokenJWT = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }

}
