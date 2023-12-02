package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.Modelo.Hotel;
import uniandes.edu.co.proyecto.Modelo.Servicio;
import uniandes.edu.co.proyecto.Repositorio.ServicioRepository;

@Controller
public class ServicioController {

    @Autowired
    private ServicioRepository tiposServicioRepository;

    @GetMapping("/tiposServicio")
    public String tiposServicio(Model model) {
        model.addAttribute("tiposServicio", tiposServicioRepository.findAllServicios());
        return "tiposServicio";
    }

    @GetMapping("/tiposServicio/new")
    public String tiposServicioForm(Model model) {
        return "tiposServicioNuevo";
    }

    @PostMapping("/tiposServicio/new/save")
    public String tiposServicioGuardar(@RequestParam(value = "Tipo_Servicio") String Tipo_Servicio,
            @RequestParam(value = "Nombre") String Nombre,
            @RequestParam(value = "Precio") Integer precio,
            @RequestParam(value = "Hotel_Id") Hotel Hotel_Id,
            @RequestParam(value = "id") String id) {
        tiposServicioRepository.save(new Servicio(id, Nombre, Tipo_Servicio, precio, Hotel_Id));
        return "redirect:/tiposServicio";
    }

    @GetMapping("/tiposServicio/{tipo}/edit")
    public String tiposServicioEditarForm(@PathVariable("tipo") String tipo, Model model) {
        model.addAttribute("tiposServicio", new Servicio());
        tiposServicioRepository.deleteByTipo(tipo);
        return "tiposServicioNuevo";
    }

    @GetMapping("/tiposServicio/{tipo}/delete")
    public String tiposServicioEliminar(@PathVariable("tipo") String tipo) {
        tiposServicioRepository.deleteByTipo(tipo);
        return "redirect:/tiposServicio";
    }

}