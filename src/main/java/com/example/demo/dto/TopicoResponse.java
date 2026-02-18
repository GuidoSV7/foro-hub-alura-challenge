package com.example.demo.dto;

import com.example.demo.entity.Topico;

import java.time.LocalDateTime;

public class TopicoResponse {

    private Long id;
    private String titulo;
    private String mensaje;
    private String nombreCurso;
    private LocalDateTime fechaCreacion;
    private Long autorId;
    private String autorNombre;

    public TopicoResponse() {
    }

    public static TopicoResponse fromEntity(Topico topico) {
        TopicoResponse dto = new TopicoResponse();
        dto.setId(topico.getId());
        dto.setTitulo(topico.getTitulo());
        dto.setMensaje(topico.getMensaje());
        dto.setNombreCurso(topico.getNombreCurso());
        dto.setFechaCreacion(topico.getFechaCreacion());
        dto.setAutorId(topico.getAutor().getId());
        dto.setAutorNombre(topico.getAutor().getNombre());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }
}
