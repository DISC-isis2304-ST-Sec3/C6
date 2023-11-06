package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Modelo.Servicio;
import uniandes.edu.co.proyecto.Repositorio.ServicioRepository;

@RestController
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/Servicios")
    public String servicioes(Model model){
        model.addAttribute("Servicios", servicioRepository.darServicios());
        return model.toString();
    }

    // @GetMapping("/Servicios/new")
    // public String servicioForm(Model model){
    //     model.addAttribute("servicio", new Servicio());
    //     return "servicioNueva";
    // }

    // @PostMapping("/Servicios/new/save")
    // public String servicioGuardar(@ModelAttribute Servicio servicio){
    //     servicioRepository.insertarServicio(servicio.getNombre(), servicio.getTipoServicio(),servicio.getPrecio());
    //     return "redirect:/Servicios";
    // }

    // @GetMapping("/Servicios/{id}/edit")
    // public String servicioEditarForm(@PathVariable("id") int id, Model model){
    //     Servicio servicio= servicioRepository.darServicio(id);
    //     if(servicio!=null){
    //         model.addAttribute("servicio", servicio);
    //         return "servicioEditar";
    //     } else{
    //         return "redirect:/Servicios";
    //     }
    // }

    // @PostMapping("/Servicios/{id}/edit/save")
    // public String servicioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Servicio servicio){
    //     servicioRepository.actualizarServicio(id, servicio.getNombre(), servicio.getTipoServicio(), servicio.getPrecio());
    //     return "redirect:/Servicios";
    // }

    // @GetMapping("/Servicios/{id}/delete")
    // public String servicioEliminar(@PathVariable("id") int id){
    //     servicioRepository.eliminarServicio(id);
    //     return "redirect:/Servicios";
    // }

}