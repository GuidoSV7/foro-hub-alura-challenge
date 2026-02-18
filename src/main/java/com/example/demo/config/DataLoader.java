package com.example.demo.config;

import com.example.demo.entity.Topico;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.TopicoRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final TopicoRepository topicoRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UsuarioRepository usuarioRepository,
                      TopicoRepository topicoRepository,
                      PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.topicoRepository = topicoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (usuarioRepository.count() > 0) {
            return;
        }

        Usuario ana = new Usuario("Ana Silva", "ana@email.com", passwordEncoder.encode("123456"));
        Usuario carlos = new Usuario("Carlos López", "carlos@email.com", passwordEncoder.encode("123456"));
        Usuario maria = new Usuario("María García", "maria@email.com", passwordEncoder.encode("123456"));

        usuarioRepository.save(ana);
        usuarioRepository.save(carlos);
        usuarioRepository.save(maria);

        topicoRepository.save(new Topico(
                "Duda sobre Spring Boot",
                "¿Cómo configuro un proyecto Spring Boot desde cero?",
                "Spring Boot",
                ana
        ));
        topicoRepository.save(new Topico(
                "API REST con JWT",
                "¿Cuál es la mejor práctica para implementar JWT en una API?",
                "Spring Security",
                carlos
        ));
        topicoRepository.save(new Topico(
                "Base de datos H2",
                "¿H2 es adecuada para producción o solo desarrollo?",
                "Persistencia con JPA",
                maria
        ));
    }
}
