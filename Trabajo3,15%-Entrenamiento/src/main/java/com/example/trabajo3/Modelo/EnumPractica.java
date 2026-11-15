package com.example.trabajo3.Modelo;

public enum EnumPractica {

    CARDIO("Cardio"),
    FUERZA("Fuerza"),
    RESISTENCIA("Resistencia"),
    FLEXIBILIDAD("Flexibilidad"),
    VELOCIDAD("Velocidad");

    private final String nombre;

    EnumPractica(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
