package com.example.demo.web;

import com.example.demo.dto.TopicoRequest;
import com.example.demo.dto.TopicoResponse;
import com.example.demo.entity.Topico;
import com.example.demo.entity.Usuario;
import com.example.demo.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    private final TopicoService topicoService;

    public TopicosController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping
    public ResponseEntity<List<TopicoResponse>> listar() {
        List<Topico> topicos = topicoService.listarTodos();
        List<TopicoResponse> response = topicos.stream()
                .map(TopicoResponse::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TopicoResponse> crear(@Valid @RequestBody TopicoRequest request,
                                                  @AuthenticationPrincipal Usuario autor) {
        Topico topico = topicoService.crear(request, autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(TopicoResponse.fromEntity(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            topicoService.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
