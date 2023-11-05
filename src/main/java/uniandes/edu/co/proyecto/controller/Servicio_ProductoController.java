package uniandes.edu.co.proyecto.controller;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Modelo.Producto;
import uniandes.edu.co.proyecto.Modelo.Servicio;
import uniandes.edu.co.proyecto.Modelo.Servicio_Producto;
import uniandes.edu.co.proyecto.Modelo.Servicio_ProductoPK;
import uniandes.edu.co.proyecto.Repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.Repositorio.Servicio_ProductoRepository;

public class Servicio_ProductoController {



    @GetMapping("/Reservas_Servicios/new")
    public String reservaForm(Model model){
        model.addAttribute("Servicios", servicioRepository.darServicios());
        model.addAttribute("Reservas", reservaRepository.darReservas());
        return "reservaNueva";
    }

    @PostMapping("/Reservas_Servicios/new/save")
    public String reservaGuardar(@ModelAttribute("Reservas_id") Integer idReserva, @ModelAttribute("Servicios_id") Integer idServicio)
             {
        Reserva reserva= reservaRepository.darReserva(idReserva);
        Servicio servicio= servicioRepository.darServicio(idServicio);
        
        Reserva_ServicioPK pk= new Reserva_ServicioPK(reserva, servicio);
        Reserva_Servicio reserva_servicio  = new Reserva_Servicio();
        reserva_servicio.SetSReservas_Servicios(pk);

        reserva_ServiciosRepository.insertarReserva_Servicios(reserva, servicio);

        return "redirect:/Reservas_servicios";
             }    
}
*/