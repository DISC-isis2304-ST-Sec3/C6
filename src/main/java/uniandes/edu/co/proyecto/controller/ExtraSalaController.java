package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Modelo.ExtraSala;
import uniandes.edu.co.proyecto.Repositorio.ExtraSalaRepository;

@RestController
public class ExtraSalaController {

    @Autowired
    private ExtraSalaRepository extraSalaRepository;

    @GetMapping("/ExtraSalas")
    public String extraSalaes(Model model){
        model.addAttribute("ExtraSalas", extraSalaRepository.darExtraSalas());
        return model.toString();
    }

    @GetMapping("/ExtraSalas/new")
    public String extraSalaForm(Model model){
        model.addAttribute("extraSala", new ExtraSala());
        return "extraSalaNueva";
    }

    @PostMapping("/ExtraSalas/new/save")
    public String extraSalaGuardar(@ModelAttribute ExtraSala extraSala){
        extraSalaRepository.insertarExtraSala(extraSala.getNombre(), extraSala.getCosto());
        return "redirect:/ExtraSalas";
    }

    @GetMapping("/ExtraSalas/{id}/edit")
    public String extraSalaEditarForm(@PathVariable("id") int id, Model model){
        ExtraSala extraSala= extraSalaRepository.darExtrasSala(id);
        if(extraSala!=null){
            model.addAttribute("extraSala", extraSala);
            return "extraSalaEditar";
        } else{
            return "redirect:/ExtraSalas";
        }
    }

    @PostMapping("/ExtraSalas/{id}/edit/save")
    public String extraSalaEditarGuardar(@PathVariable("id") int id, @ModelAttribute ExtraSala extraSala){
        extraSalaRepository.actualizarExtraSala(id, extraSala.getNombre(), extraSala.getCosto());
        return "redirect:/ExtraSalas";
    }

    @GetMapping("/ExtraSalas/{id}/delete")
    public String extraSalaEliminar(@PathVariable("id") int id){
        extraSalaRepository.eliminarExtraSala(id);
        return "redirect:/ExtraSalas";
    }

}