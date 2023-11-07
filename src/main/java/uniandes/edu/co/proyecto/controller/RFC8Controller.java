package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uniandes.edu.co.proyecto.Repositorio.RFC8Repository;


@Controller
public class RFC8Controller {


    @Autowired
    private RFC8Repository rfc8Repository;

    @GetMapping("/rfc8")
    public String rfc1(Model model) {
        long tiempoInicio = System.nanoTime();
        Collection<Object[]> rta = rfc8Repository.darRta();
        long tiempoFin = System.nanoTime();
        double tiempoEjecucion = (tiempoFin - tiempoInicio)/1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        model.addAttribute("rta", rta);
        
        return "rfc8";
    }
}
