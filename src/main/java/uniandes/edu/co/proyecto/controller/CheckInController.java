package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.Modelo.CheckIn;
import uniandes.edu.co.proyecto.Modelo.Reserva;
import uniandes.edu.co.proyecto.Repositorio.CheckInRepository;
import uniandes.edu.co.proyecto.Repositorio.ReservaRepository;

@Controller
public class CheckInController {

    @Autowired
    private CheckInRepository repository;

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/checkIn")
    public String checkIn(Model model) {
        model.addAttribute("checkIns", repository.findAllCheckInes());
        return "checkIn";
    }

    @GetMapping("/checkIn/new")
    public String checkInForm(Model model) {
        model.addAttribute("reservas", reservaRepository.findAllReservaes());
        return "checkInNuevo";
    }

    @PostMapping("/checkIn/new/save")
    public String checkInGuardar(@RequestParam(value = "id") String id,
            @RequestParam(value = "idReserva") String idReserva, @RequestParam(value = "fecha") String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaI = LocalDate.parse(fecha, formatter);
        ObjectId objectIdRes = new ObjectId(idReserva);
        Optional<Reserva> res = reservaRepository.findById(idReserva);
        if (res.isPresent() && fechaI.equals(res.get().getFecha_entrada())) {
            repository.save(new CheckIn(objectIdRes, fechaI));
            return "redirect:/checkIn";
        }
        return "redirect:/error";
    }

    @GetMapping("/checkIn/{id}/edit")
    public String checkInEditarForm(@PathVariable("id") String id, Model model) {
        repository.deleteById(id);
        model.addAttribute("reservas", reservaRepository.findAllReservaes());
        return "checkInNuevo";
    }

    @GetMapping("/checkIn/{id}/delete")
    public String checkInEliminar(@PathVariable("id") String id) {
        repository.deleteById(id);
        return "redirect:/checkIn";
    }

}