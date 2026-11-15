package com.example.trabajo3.Repositories;

import com.example.trabajo3.Modelo.Categoria;
import com.example.trabajo3.Modelo.EnumPractica;
import com.example.trabajo3.Modelo.PlanificacionDeportiva;
import com.example.trabajo3.Modelo.Practica;
import org.springframework.stereotype.Repository;

import java.util.Stack;

@Repository
public class PlanificacionDeportivaRepository {

    public Stack<Practica> crearNuevasPracticas() {
        Stack<Practica> nuevasPracticas = new Stack<>();

        Practica practica1 = new Practica("Press de Banca", "Andrés Felipe Holguín", 45, EnumPractica.FUERZA, Categoria.AVANZADO);
        practica1.agregarConteo(12);
        practica1.agregarConteo(10);
        practica1.agregarConteo(8);

        Practica practica2 = new Practica("Sentadilla Libre", "Carlos Gómez", 50, EnumPractica.FUERZA, Categoria.AVANZADO);
        practica2.agregarConteo(15);
        practica2.agregarConteo(12);

        Practica practica3 = new Practica("Carrera Continua 10K", "Juan Pérez", 60, EnumPractica.CARDIO, Categoria.INTERMEDIO);
        practica3.agregarConteo(30);
        practica3.agregarConteo(25);

        Practica practica4 = new Practica("Estiramiento Dinámico", "Sofía Martínez", 20, EnumPractica.FLEXIBILIDAD, Categoria.PRINCIPIANTE);

        Practica practica5 = new Practica("Sprints en Pista", "María Rodríguez", 35, EnumPractica.VELOCIDAD, Categoria.AVANZADO);
        practica5.agregarConteo(6);
        practica5.agregarConteo(8);
        practica5.agregarConteo(10);

        nuevasPracticas.push(practica1);
        nuevasPracticas.push(practica2);
        nuevasPracticas.push(practica3);
        nuevasPracticas.push(practica4);
        nuevasPracticas.push(practica5);

        return nuevasPracticas;
    }

    public PlanificacionDeportiva crearPlanificacion(Stack<Practica> nuevasPracticas) {
        PlanificacionDeportiva planificacion = new PlanificacionDeportiva(
                "Carlos Ramírez",
                "Centro Deportivo Medellín",
                EnumPractica.FUERZA,
                Categoria.AVANZADO
        );

        for (Practica p : nuevasPracticas) {
            planificacion.agregarPractica(p);
        }
        return planificacion;
    }
}
