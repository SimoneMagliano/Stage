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

import com.ecobonus.entity.FineLavoro;
import com.ecobonus.entity.InizioLavoro;
import com.ecobonus.entity.Intervento;
import com.ecobonus.entity.PrimoSal;
import com.ecobonus.entity.Regione;
import com.ecobonus.entity.SecondoSal;
import com.ecobonus.entity.Sede;
import com.ecobonus.entity.TipoIntervento;
import com.ecobonus.service.FineLavoriService;
import com.ecobonus.service.InizioLavoriService;
import com.ecobonus.service.InterventiService;
import com.ecobonus.service.PrimoSalService;
import com.ecobonus.service.RegioneService;
import com.ecobonus.service.SecondoSalService;
import com.ecobonus.service.SediService;
import com.ecobonus.service.TipoInterventoService;

@Controller
@Scope("session")
@SessionAttributes("Intervento")
@RequestMapping("/interventi")
public class ControllerInterventi {

	@Autowired
	private RegioneService regioneService;
	@Autowired
	private InterventiService interventoService;
	@Autowired
	private TipoInterventoService tipoInterventoService;
	@Autowired
	private SediService sediService;
	@Autowired
	private InizioLavoriService inizioLavoriService;
	@Autowired
	private FineLavoriService fineLavoriService;
	@Autowired
	private PrimoSalService primoSalService;
	@Autowired
	private SecondoSalService secondoSalService;
	
	@GetMapping("/list")
	public String listInterventi(Model theModel) {		
		List<Intervento> InterventiList = interventoService.getList();
		theModel.addAttribute("interventi", InterventiList);
		return "list-interventi";
	}
	
	@GetMapping("/delete")
	public String deleteIntervento(@RequestParam("idIntervento") int theIdIntervento) {
		interventoService.deleteIntervento(theIdIntervento);
		return "redirect:/interventi/list";
	}
	@GetMapping("/showFormUpdateIntervento")
	public String showFormUpdateIntervento(@RequestParam("idIntervento") int theIdIntervento,
									Model theModel) {
		List<TipoIntervento> tipiInterventoList = tipoInterventoService.getTipiIntervento();
		Intervento intervento = interventoService.getIntervento(theIdIntervento);	
		List<Regione> regioniList = regioneService.getRegioni();
		List<Sede> sediList = sediService.getSedi();
		theModel.addAttribute("intervento", intervento);
		theModel.addAttribute("tipiIntervento", tipiInterventoList);
		theModel.addAttribute("regioni", regioniList);
		theModel.addAttribute("sedi", sediList);
		return "interventi-form";
	}
	@PostMapping("/saveIntervento")
	public String saveIntervento(@ModelAttribute("interventi") Intervento intervento, @RequestParam("idIntervento") int theIdIntervento,
			@RequestParam("codiceTipoIntervento") String codiceTipoIntervento, @RequestParam("codSede") String codSede,
			@RequestParam("idRegione") int idRegione ) {
		TipoIntervento tipoIntervento = tipoInterventoService.getTipoIntervento(codiceTipoIntervento);
		Regione regione = regioneService.getRegione(idRegione);
		Sede sede = sediService.getSede(codSede);
		intervento.setSede(sede);
		intervento.setRegione(regione);
		intervento.setTipoIntervento(tipoIntervento);
		interventoService.saveIntervento(intervento);		
		return "redirect:/interventi/list";
	}
	@GetMapping("/showFormAddIntervento")
	public String showFormAddIntervento(Model theModel) {
		List<TipoIntervento> tipiInterventoList = tipoInterventoService.getTipiIntervento();
		List<Regione> regioniList = regioneService.getRegioni();
		List<Sede> sediList = sediService.getSedi();
		Intervento theIntervento = new Intervento();	
		theModel.addAttribute("intervento", theIntervento);
		theModel.addAttribute("tipiIntervento", tipiInterventoList);
		theModel.addAttribute("regioni", regioniList);	
		theModel.addAttribute("sedi", sediList);
		return "interventi-form";
	}
	
	@GetMapping("/listInizioLavori")
	public String listInizioLavori(Model theModel) {		
		List<InizioLavoro> InizioLavoriList = inizioLavoriService.getList();
		theModel.addAttribute("inizioLavori", InizioLavoriList);
		return "list-interventi";
	}
	@GetMapping("/deleteInizioLavoro")
	public String deleteInizioLavoro(@RequestParam("idInizioLavori") int theIdInizioLavoro) {
		inizioLavoriService.deleteInizioLavoro(theIdInizioLavoro);
		return "redirect:/interventi/list";
	}
	@GetMapping("/showFormUpdateInizioLavoro")
	public String showFormUpdateInizioLavoro(@RequestParam("idInizioLavoro") int theIdInizioLavoro,
									Model theModel) {
	
		return "interventi-form";
	}

	@GetMapping("/showFormAddInizioLavoro")
	public String showFormAddInizioLavoro(@RequestParam("idIntervento") int theIdIntervento, Model theModel) {
		InizioLavoro inizioLavoro = inizioLavoriService.getInizioLavoro(theIdIntervento);
		theModel.addAttribute("inizioLavoro", inizioLavoro);
		return "interventi-form";
	}
	
	@GetMapping("/listFineLavori")
	public String listFineLavori(Model theModel) {		
		List<FineLavoro> FineLavoriList = fineLavoriService.getList();
		theModel.addAttribute("fineLavori", FineLavoriList);
		return "list-interventi";
	}
	
	@GetMapping("/deleteFineLavoro")
	public String deleteFineLavoro(@RequestParam("idFineLavori") int theIdFineLavoro) {
		fineLavoriService.deleteFineLavoro(theIdFineLavoro);
		return "redirect:/interventi/list";
	}
	
	@GetMapping("/showFormUpdateFineLavoro")
	public String showFormUpdateFineLavoro(@RequestParam("idFineLavoro") int theIdFineLavoro,
									Model theModel) {
	
		return "interventi-form";
	}
	
	@GetMapping("/showFormAddFineLavoro")
	public String showFormAddFineLavoro(@RequestParam("idIntervento") int theIdIntervento, Model theModel) {
		FineLavoro fineLavoro = fineLavoriService.getFineLavoro(theIdIntervento);
		theModel.addAttribute("fineLavoro", fineLavoro);
		return "interventi-form";
	}
	
	@GetMapping("/listPrimoSal")
	public String listPrimoSal(Model theModel) {		
		List<PrimoSal> PrimoSalList = primoSalService.getList();
		theModel.addAttribute("primoSal", PrimoSalList);
		return "list-interventi";
	}
	
	@GetMapping("/deletePrimoSal")
	public String deletePrimoSal(@RequestParam("idPrimoSal") int theIdPrimoSal) {
		primoSalService.deletePrimoSal(theIdPrimoSal);
		return "redirect:/interventi/list";
	}
	
	@GetMapping("/showFormUpdatePrimoSal")
	public String showFormUpdatePrimoSal(@RequestParam("idPrimoSal") int theIdPrimoSal,
									Model theModel) {
	
		return "interventi-form";
	}
	
	@GetMapping("/showFormAddPrimoSal")
	public String showFormAddPrimoSal(@RequestParam("idIntervento") int theIdIntervento, Model theModel) {
		PrimoSal primoSal = primoSalService.getPrimoSal(theIdIntervento);
		theModel.addAttribute("primoSal", primoSal);
		return "interventi-form";
	}
	
	@GetMapping("/listSecondoSal")
	public String listSecondoSal(Model theModel) {		
		List<SecondoSal> SecondoSalList = secondoSalService.getList();
		theModel.addAttribute("secondoSal", SecondoSalList);
		return "list-interventi";
	}
	
	@GetMapping("/deleteSecondoSal")
	public String deleteSecondoSal(@RequestParam("idSecondoSal") int theIdSecondoSal) {
		secondoSalService.deleteSecondoSal(theIdSecondoSal);
		return "redirect:/interventi/list";
	}
	
	@GetMapping("/showFormUpdateSecondoSal")
	public String showFormUpdateSecondoSal(@RequestParam("idSecondoSal") int theIdSecondoSal,
									Model theModel) {
	
		return "interventi-form";
	}
	
	@GetMapping("/showFormAddSecondoSal")
	public String showFormAddSecondoSal(@RequestParam("idIntervento") int theIdIntervento, Model theModel) {
		SecondoSal secondoSal = secondoSalService.getSecondoSal(theIdIntervento);
		theModel.addAttribute("secondoSal", secondoSal);
		return "interventi-form";
	}
	 @ModelAttribute("session")
     public Intervento getIntervento () {
         return new Intervento(); //get From DB Or Session
     }  
}
