package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class TopicoRequest {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El mensaje es obligatorio")
    private String mensaje;

    @NotBlank(message = "El nombre del curso es obligatorio")
    private String nombreCurso;

    public TopicoRequest() {
    }

    public TopicoRequest(String titulo, String mensaje, String nombreCurso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.nombreCurso = nombreCurso;
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
}
