package com.bolsadeideas.springboot.web.app.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;
@Controller
@RequestMapping("/app")
public class IndexController {
	
 
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	@GetMapping({"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo",textoIndex );
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("Diego");
		usuario.setApellido("Elizalde");
		usuario.setEmail("diegoe@gmail.com");

		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	@RequestMapping("/listar")
	public String listar(Model model) {
		//Se crea la Lista de usuarios

		//Se agrega la lista de usuarios al modelo
		model.addAttribute("titulo",textoListar);
		return "listar";
	}
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios =new ArrayList<>();
		//Se agregan los usuarios a la lista
		usuarios.add(new Usuario("Diego","Elizalde","diegoe@gmail.com"));
		usuarios.add(new Usuario("Alejandro","Ortiz","alejandroO@gmail.com"));
		usuarios.add(new Usuario("Alejandro","Elizalde","Alejandroe@gmail.com"));
		return usuarios;

	}

}
