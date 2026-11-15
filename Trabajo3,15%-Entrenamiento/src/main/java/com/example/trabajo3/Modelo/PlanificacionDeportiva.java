package com.example.trabajo3.Modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class PlanificacionDeportiva {
    private String entrenador;
    private String sede;
    private EnumPractica tipoPractica;
    private Categoria categoria;
    private Deque<Practica> practicas;

    public PlanificacionDeportiva() {
        this.practicas = new ArrayDeque<>();
    }

    public PlanificacionDeportiva(String entrenador, String sede,
                                  EnumPractica tipoPractica, Categoria categoria) {
        this.entrenador = entrenador;
        this.sede = sede;
        this.tipoPractica = tipoPractica;
        this.categoria = categoria;
        this.practicas = new ArrayDeque<>();
    }

    public void agregarPractica(Practica practica) {
        practicas.add(practica);
    }

    public void setEntrenador(String entrenador) { this.entrenador = entrenador; }
    public void setSede(String sede) { this.sede = sede; }
    public void setTipoPractica(EnumPractica tipoPractica) { this.tipoPractica = tipoPractica; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setPracticas(Deque<Practica> practicas) { this.practicas = practicas; }

    public String getEntrenador() { return entrenador; }
    public String getSede() { return sede; }
    public EnumPractica getTipoPractica() { return tipoPractica; }
    public Categoria getCategoria() { return categoria; }
    public Deque<Practica> getPracticas() { return practicas; }
}
 