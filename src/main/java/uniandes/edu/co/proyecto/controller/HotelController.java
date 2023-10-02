package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Modelo.Hotel;
import uniandes.edu.co.proyecto.Repositorio.HotelRepository;

@RestController
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/Hoteles")
    public String hoteles(Model model){
        model.addAttribute("Hoteles", hotelRepository.darHoteles());
        return model.toString();
    }

    @GetMapping("/Hoteles/new")
    public String hotelForm(Model model){
        model.addAttribute("hotel", new Hotel());
        return "hotelNueva";
    }

    @PostMapping("/Hoteles/new/save")
    public String hotelGuardar(@ModelAttribute Hotel hotel){
        hotelRepository.insertarHotel(hotel.getNombre(), hotel.getTipo(), hotel.getEstrellas());;
        return "redirect:/Hoteles";
    }

    @GetMapping("/Hoteles/{id}/edit")
    public String hotelEditarForm(@PathVariable("id") int id, Model model){
        Hotel hotel= hotelRepository.darHotel(id);
        if(hotel!=null){
            model.addAttribute("hotel", hotel);
            return "hotelEditar";
        } else{
            return "redirect:/Hoteles";
        }
    }

    @PostMapping("/Hoteles/{id}/edit/save")
    public String hotelEditarGuardar(@PathVariable("id") int id, @ModelAttribute Hotel hotel){
        hotelRepository.actualizarHotel(id, hotel.getNombre(), hotel.getTipo(), hotel.getEstrellas());
        return "redirect:/Hoteles";
    }

    @GetMapping("/Hoteles/{id}/delete")
    public String hotelEliminar(@PathVariable("id") int id){
        hotelRepository.eliminarHotel(id);
        return "redirect:/Hoteles";
    }

}