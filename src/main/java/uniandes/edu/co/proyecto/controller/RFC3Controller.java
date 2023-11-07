package uniandes.edu.co.proyecto.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.Repositorio.RFC3Repositoy;


@Controller
public class RFC3Controller {


        @Autowired
        private RFC3Repositoy rfc3Repository;

        @GetMapping("/rfc3")
        public String rfc3(Model model) {
        long tiempoFin = System.nanoTime();

        LocalDate today = LocalDate.now();
        Integer dayOfYear = today.getDayOfYear();

        

        Collection<Object[]> rta = rfc3Repository.darRta(dayOfYear);
        model.addAttribute("rta", rta);
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin)/1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        
        return "rfc3";
        }

}