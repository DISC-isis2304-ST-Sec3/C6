package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.Modelo.*; 
import uniandes.edu.co.proyecto.Repositorio.*;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class Caract_habitacionController {
    @Autowired
    private Caract_habitacionRepository Caract_habitacionRepository;

    @Autowired
    private HabitacionRepository HabitacionRepository;

    @Autowired
    private Caract_habitacionRepository caract_habitacionRepository;
}
