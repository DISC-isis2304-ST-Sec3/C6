package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.Repositorio.RFC6Repository;




@Controller
public class RFC6Controller {
    

    @Autowired
        private RFC6Repository rfc6Repository;

        @GetMapping("/rfc6")
        public String rfc6(Model model) {
        long tiempoFin = System.nanoTime();

        Collection<Object[]> primera = rfc6Repository.darPrimeraParte();
        Collection<Object[]> segunda = rfc6Repository.darSegundaParte();
        Collection<Object[]> tercera = rfc6Repository.darTerceraParte();
        
        model.addAttribute("mayor", primera);
        model.addAttribute("ingreso", segunda);
        model.addAttribute("menor", tercera);
        long tiempoInicio = System.nanoTime();
        double tiempoEjecucion = (tiempoInicio - tiempoFin)/1000000000.0;
        model.addAttribute("tiempo", String.format("%.3f", tiempoEjecucion));
        
        return "rfc6";
        }


}
