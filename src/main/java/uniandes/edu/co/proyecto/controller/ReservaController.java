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

    @GetMapping("/Reservas")
    public String reservaes(Model model){
        model.addAttribute("Reservas", reservaRepository.darReservas());
        return model.toString();
    }

    @GetMapping("/Reservas/new")
    public String reservaForm(Model model){
        model.addAttribute("reserva", new Reserva());
        return "reservaNueva";
    }

    @PostMapping("/Reservas/new/save")
    public String reservaGuardar(@ModelAttribute Reserva reserva){
        reservaRepository.insertarReserva(reserva.getId_usuario(),reserva.getNumero_personas(), reserva.getFecha_entrada(), reserva.getFecha_salida(), reserva.getCosto_total(), reserva.getCheck_in(), reserva.getCheck_out(),reserva.getCont_reservas());
        return "redirect:/Reservas";
    }

    @GetMapping("/Reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") int id, Model model){
        Reserva reserva= reservaRepository.darReserva(id);
        if(reserva!=null){
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else{
            return "redirect:/Reservas";
        }
    }

    @PostMapping("/Reservas/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Reserva reserva){
        reservaRepository.actualizarReserva(id,reserva.getId_usuario(), reserva.getNumero_personas(), reserva.getFecha_entrada(), reserva.getFecha_salida(), reserva.getCosto_total(), reserva.getCheck_in(), reserva.getCheck_out(),reserva.getCont_reservas());
        return "redirect:/Reservas";
    }

    @GetMapping("/Reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") int id){
        reservaRepository.eliminarReserva(id);
        return "redirect:/Reservas";
    }

}