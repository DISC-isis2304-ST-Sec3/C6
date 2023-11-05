package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.Modelo.Usuario;
import uniandes.edu.co.proyecto.Repositorio.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/Usuarios")
    public String usuarios(Model model){
        model.addAttribute("Usuarios", usuarioRepository.darUsuarios());
        return "usuario";
    }

    @GetMapping("/TiposUsuarios")
    public String tipoUsuarios(Model model){
        model.addAttribute("Usuarios", usuarioRepository.darTiposUsuarios());
        return model.toString();
    }

    @GetMapping("/Usuarios/new")
    public String usuarioForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuarioNueva";
    }

    @PostMapping("/Usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario){
        usuarioRepository.insertarUsuario(usuario.getLogin(),usuario.getcontraseña(),usuario.getNombre(),usuario.getNo_documento(),usuario.getTipo_usuario());;
        return "redirect:/Usuarios";
    }

    @GetMapping("/Usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") int id, Model model){
        Usuario usuario= usuarioRepository.darUsuario(id);
        if(usuario!=null){
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else{
            return "redirect:/Usuarios";
        }
    }

    @PostMapping("/Usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Usuario usuario){
        usuarioRepository.actualizarUsuario(id, usuario.getLogin(),usuario.getcontraseña(),usuario.getNombre(),usuario.getNo_documento(),usuario.getTipo_usuario());
        return "redirect:/Usuarios";
    }

    @GetMapping("/Usuarios/{id}/delete")
    public String usuarioEliminar(@PathVariable("id") int id){
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/Usuarios";
    }

    
}