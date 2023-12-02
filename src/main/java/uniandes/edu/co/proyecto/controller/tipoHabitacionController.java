package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.Modelo.tipoHabitacion;
import uniandes.edu.co.proyecto.Repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.Repositorio.tipoHabitacionRepository;

    @Controller
    public class tipoHabitacionController {

        @Autowired
        private tipoHabitacionRepository repository;

        // Other methods...

        @PostMapping("/tiposHabitacion/new/save")
        public String tiposHabitacionGuardar(@ModelAttribute("tipo") String tipo,
                @RequestParam(value = "nombre", required = false) String nombre,
                @RequestParam(value = "descripcion", required = false) String descripcion,
                @RequestParam(value = "id", required = false) String id) {

            tipo = (tipo != null) ? tipo : "0";
            nombre = (nombre != null) ? nombre : "0";
            descripcion = (descripcion != null) ? descripcion : "0";
            id = (id != null) ? id : "0";


            repository.save(new tipoHabitacion(id, tipo, nombre, descripcion));
            return "redirect:/tiposHabitacion";
        }
    

    @GetMapping("/tiposHabitacion/{tipo}/delete")
    public String eliminarTipoHabitacion(@PathVariable String tipo) {
        repository.deleteByTipo(tipo);
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{tipo}/edit")
    public String tiposHabitacionEditarForm(@PathVariable("tipo") String tipo, Model model) {
        repository.deleteByTipo(tipo);
        return "tiposhabitacionNuevo";
    }


}

