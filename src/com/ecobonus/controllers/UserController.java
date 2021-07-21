package com.ecobonus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ecobonus.entity.Regione;
import com.ecobonus.entity.TipoUtente;
import com.ecobonus.entity.User;
import com.ecobonus.service.RegioneService;
import com.ecobonus.service.TipoUtenteService;
import com.ecobonus.service.UserService;

@Controller
@Scope("session")
@SessionAttributes("User")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private TipoUtenteService tipoUtenteService;
	@Autowired
	private RegioneService regioneService;
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {		
		List<User> theUsers = userService.getList();
		theModel.addAttribute("users", theUsers);
		return "list-users";
	}
	
	@GetMapping("/showFormAddUser")
	public String showFormAddUser(Model theModel) {
		List<TipoUtente> tipiUtenteList = tipoUtenteService.getTipiUtente();
		List<Regione> regioniList = regioneService.getRegioni();
		User theUser = new User();	
		theModel.addAttribute("user", theUser);
		theModel.addAttribute("tipiUtente", tipiUtenteList);
		theModel.addAttribute("regioni", regioniList);	
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user, @RequestParam("idTipoUtente") int idTipoUtente, 
			@RequestParam("idRegione") int idRegione ) {	
		TipoUtente tipoUtente = tipoUtenteService.getTipoUtente(idTipoUtente);
		Regione regione = regioneService.getRegione(idRegione);
		user.setTipoUtente(tipoUtente);
		user.setRegione(regione);
		userService.saveUser(user);		
		return "redirect:/user/list";
	}
	
	@GetMapping("/showFormUpdateUser")
	public String showFormForUpdate(@RequestParam("idUtente") int theIdUtente,
									Model theModel) {
		List<TipoUtente> tipiUtenteList = tipoUtenteService.getTipiUtente();
		User theUser = userService.getUser(theIdUtente);	
		List<Regione> regioniList = regioneService.getRegioni();
		theModel.addAttribute("user", theUser);
		theModel.addAttribute("tipiUtente", tipiUtenteList);
		theModel.addAttribute("regioni", regioniList);
		return "user-form";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("idUtente") int theIdUtente) {
		userService.deleteUser(theIdUtente);
		return "redirect:/user/list";
	}
	
	@GetMapping("/login")
	public String showLogin(Model theModel) {
		List<TipoUtente> tipiUtenteList = tipoUtenteService.getTipiUtente();
		List<Regione> regioniList = regioneService.getRegioni();
		User theUser = new User();	
		theModel.addAttribute("user", theUser);
		theModel.addAttribute("tipiUtente", tipiUtenteList);
		theModel.addAttribute("regioni", regioniList);
		return "user-login";
	}
	
	@GetMapping("/home")
	public String showHome(Model theModel) {	
		return "home";
	}
}
