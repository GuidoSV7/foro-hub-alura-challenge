package com.example.demo.service;

import com.example.demo.dto.TopicoRequest;
import com.example.demo.entity.Topico;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.TopicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public List<Topico> listarTodos() {
        return topicoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Topico obtenerPorId(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado con id: " + id));
    }

    @Transactional
    public Topico crear(TopicoRequest request, Usuario autor) {
        Topico topico = new Topico(
                request.getTitulo(),
                request.getMensaje(),
                request.getNombreCurso(),
                autor
        );
        return topicoRepository.save(topico);
    }

    @Transactional
    public void eliminar(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new IllegalArgumentException("Tópico no encontrado con id: " + id);
        }
        topicoRepository.deleteById(id);
    }
}
