package com.example.trabajo3.Controlador;

import com.example.trabajo3.Modelo.EnumPractica;
import com.example.trabajo3.Modelo.PlanificacionDeportiva;
import com.example.trabajo3.Modelo.Practica;
import com.example.trabajo3.Repositories.PlanificacionDeportivaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class PlanificacionDeportivaControlador {

    private final PlanificacionDeportivaRepository repositorio;

    public PlanificacionDeportivaControlador(PlanificacionDeportivaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping({"/", "/planificacion", "/Planificacion", "/entrenamiento"})
    public String mostrar(Model model) {
        Stack<Practica> pila = repositorio.crearNuevasPracticas();
        PlanificacionDeportiva planificacion = repositorio.crearPlanificacion(pila);

        // Punto 2: ListIterator sobre el Stack y Iterator sobre el Deque
        List<String> mensajesPila = new ArrayList<>();
        ListIterator<Practica> listIterator = pila.listIterator();
        while (listIterator.hasNext()) {
            Practica p = listIterator.next();
            mensajesPila.add(describir(p));
        }

        List<String> mensajesDeque = new ArrayList<>();
        Iterator<Practica> iterator = planificacion.getPracticas().iterator();
        while (iterator.hasNext()) {
            Practica p = iterator.next();
            mensajesDeque.add(describir(p));
        }

        // Punto 3: Conversión de Stack a Deque y programación funcional sobre el Deque
        Deque<Practica> dequePila = new ArrayDeque<>(pila);
        System.out.println("Deque convertido desde el Stack, con " + dequePila.size() + " objetos");

        List<String> filtrados = planificacion.getPracticas().stream()
                .filter(p -> p.getTipoPractica() == EnumPractica.FUERZA)
                .map(this::describir)
                .collect(Collectors.toList());
        filtrados.forEach(System.out::println);

        // Punto 4: Function<Practica, Integer> que suma el Stack conteo
        Function<Practica, Integer> sumarConteo = practica -> {
            int suma = 0;
            for (int numero : practica.getConteo()) {
                suma += numero;
            }
            return suma;
        };

        List<String> sumas = new ArrayList<>();
        for (Practica p : pila) {
            sumas.add("Práctica: " + p.getNombreEjercicio()
                    + " - Suma del conteo: " + sumarConteo.apply(p));
        }

        // Punto 5: Llamado al método verTotales desde un objeto Practica
        Practica practicaElegida = pila.get(0);
        String totales = practicaElegida.verTotales(sumarConteo);

        model.addAttribute("planificacion", planificacion);
        model.addAttribute("mensajesPila", mensajesPila);
        model.addAttribute("mensajesDeque", mensajesDeque);
        model.addAttribute("filtrados", filtrados);
        model.addAttribute("sumas", sumas);
        model.addAttribute("totales", totales);

        return "planificacion";
    }

    private String describir(Practica p) {
        return "Ejercicio: " + p.getNombreEjercicio()
                + " | Deportista: " + p.getDeportista()
                + " | Duración: " + p.getDuracionMinutos() + " min"
                + " | Tipo de Práctica: " + p.getTipoPractica().getNombre()
                + " | Categoría: " + p.getCategoria().getNombre()
                + " | Conteo: " + p.getConteo();
    }
}
