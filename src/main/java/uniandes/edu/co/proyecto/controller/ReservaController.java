package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Modelo.Reserva;
import uniandes.edu.co.proyecto.Repositorio.ReservaRepository;

@RestController
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/reservas")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservaRepository.findAllReservaes());
        return "reservas";
    }

    @GetMapping("/Reservas/new")
    public String reservaForm(Model model){
        model.addAttribute("reserva", new Reserva());
        return "reservaNueva";
    }
}



