package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Modelo.Reserva;
import uniandes.edu.co.proyecto.Modelo.Servicio;
import uniandes.edu.co.proyecto.Modelo.Reserva_Servicio;
import uniandes.edu.co.proyecto.Modelo.Reserva_ServicioPK;
import uniandes.edu.co.proyecto.Repositorio.ReservaRepository;
import uniandes.edu.co.proyecto.Repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.Repositorio.Reserva_ServiciosRepository;
import uniandes.edu.co.proyecto.Modelo.Reserva_Servicio;

@RestController
public class Reserva_ServicioController {
    @Autowired
    private Reserva_ServiciosRepository reserva_ServiciosRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ServicioRepository servicioRepository;
    

    @GetMapping("/Reservas_Servicios/new")
    public String reservaForm(Model model){
        model.addAttribute("Servicios", servicioRepository.darServicios());
        model.addAttribute("Reservas", reservaRepository.darReservas());
        return "reservaNueva";
    }

    // @PostMapping("/Reservas_Servicios/new/save")
    // public String reservaGuardar(@ModelAttribute("Reservas_id") Integer idReserva, @ModelAttribute("Servicios_id") Integer idServicio)
    //          {
    //     Reserva reserva= reservaRepository.darReserva(idReserva);
    //     Servicio servicio= servicioRepository.darServicio(idServicio);
        
    //     Reserva_ServicioPK pk= new Reserva_ServicioPK(reserva, servicio);
    //     Reserva_Servicio reserva_servicio  = new Reserva_Servicio();
    //     reserva_servicio.SetSReservas_Servicios(pk);

    //     reserva_ServiciosRepository.insertarReserva_Servicios(reserva, servicio,reserva_servicio.getFecha_consumo(), reserva_servicio.getCont_servicios());

    //     return "redirect:/Reservas_servicios";
    //          }
    //     }

             
//     @GetMapping("/Reservas_Servicios/{id}/edit")
//     public String reservaEditarForm(@PathVariable("Reservas_d") int id, Model model){
//         Reserva_Servicio reserva_Servicio= reserva_ServiciosRepository.darReserva_ServiciosporId(id);
//         if(reserva_Servicio!=null){
//             model.addAttribute("reserva_Servicio", reserva_Servicio);
//             return "reserva_ServiciosEditar";
//         } else{
//             return "redirect:/Reservas_Servicios";
//         }
//     }

//     @PostMapping("/Reservas/{id}/edit/save")
//     public String reservaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Reserva reserva){
//         reservaRepository.actualizarReserva(id, reserva.getNumero_personas(), reserva.getFecha_entrada(), reserva.getFecha_salida(), reserva.getCosto_total(), reserva.getCheck_in(), reserva.getCheck_out());
//         return "redirect:/Reservas";
//     }

//     @GetMapping("/Reservas/{id}/delete")
//     public String reservaEliminar(@PathVariable("id") int id){
//         reservaRepository.eliminarReserva(id);
//         return "redirect:/Reservas";
//     }
 }

