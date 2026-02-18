package com.example.demo.web;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.entity.Usuario;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioService usuarioService, JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        try {
            Usuario usuario = usuarioService.findByEmail(request.getEmail());
            if (!usuarioService.validarPassword(usuario, request.getPassword())) {
                return ResponseEntity.status(401).body("Credenciales inválidas");
            }
            String token = jwtUtil.generarToken(usuario);
            return ResponseEntity.ok(new LoginResponse(token));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
