package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.domain.dto.user.UserDataLoginRequest;
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

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserDataLoginRequest userDataLoginRequest){
        var token = new UsernamePasswordAuthenticationToken(userDataLoginRequest.username(), userDataLoginRequest.password());
        var auth = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
