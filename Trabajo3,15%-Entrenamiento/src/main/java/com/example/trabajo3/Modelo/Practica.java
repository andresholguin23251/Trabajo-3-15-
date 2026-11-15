package com.example.trabajo3.Modelo;

import java.util.Stack;
import java.util.function.Function;

public class Practica {
    private String nombreEjercicio;
    private String deportista;
    private int duracionMinutos;
    private EnumPractica tipoPractica;
    private Categoria categoria;
    private Stack<Integer> conteo;

    public Practica() {
        this.conteo = new Stack<>();
    }

    public Practica(String nombreEjercicio, String deportista, int duracionMinutos,
                    EnumPractica tipoPractica, Categoria categoria) {
        this.nombreEjercicio = nombreEjercicio;
        this.deportista = deportista;
        this.duracionMinutos = duracionMinutos;
        this.tipoPractica = tipoPractica;
        this.categoria = categoria;
        this.conteo = new Stack<>();
    }

    public void agregarConteo(int valor) {
        conteo.push(valor);
    }

    public String verTotales(Function<Practica, Integer> funcion) {
        int total = funcion.apply(this);
        return "La práctica \"" + this.nombreEjercicio + "\" tiene un total de " + total + " repeticiones en su conteo";
    }

    public void setNombreEjercicio(String nombreEjercicio) { this.nombreEjercicio = nombreEjercicio; }
    public void setDeportista(String deportista) { this.deportista = deportista; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public void setTipoPractica(EnumPractica tipoPractica) { this.tipoPractica = tipoPractica; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public void setConteo(Stack<Integer> conteo) { this.conteo = conteo; }

    public String getNombreEjercicio() { return nombreEjercicio; }
    public String getDeportista() { return deportista; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public EnumPractica getTipoPractica() { return tipoPractica; }
    public Categoria getCategoria() { return categoria; }
    public Stack<Integer> getConteo() { return conteo; }
}