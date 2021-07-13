package com.ecobonus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecobonus.entity.InizioLavoro;
import com.ecobonus.entity.Intervento;
import com.ecobonus.entity.Regione;
import com.ecobonus.entity.Sede;
import com.ecobonus.entity.TipoIntervento;
import com.ecobonus.service.InizioLavoriService;
import com.ecobonus.service.InterventiService;
import com.ecobonus.service.RegioneService;
import com.ecobonus.service.SediService;
import com.ecobonus.service.TipoInterventoService;

@Controller
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
	
	@GetMapping("/list")
	public String listInizioLavori(Model theModel) {		
		List<InizioLavoro> InizioLavoriList = inizioLavoriService.getList();
		theModel.addAttribute("inizioLavori", InizioLavoriList);
		return "list-interventi";
	}
	@GetMapping("/delete")
	public String deleteInizioLavoro(@RequestParam("idInizioLavori") int theIdInizioLavoro) {
		inizioLavoriService.deleteInizioLavoro(theIdInizioLavoro);
		return "redirect:/interventi/list";
	}
	@GetMapping("/showFormUpdateInizioLavoro")
	public String showFormUpdateInizioLavoro(@RequestParam("idInizioLavoro") int theIdInizioLavoro,
									Model theModel) {
		//List<InizioLavoro> inizioLavoriList = InizioLavoriService.getInizioLavoro();
		//InizioLavoro inizioLavoro = inizioLavoriService.getInizioLavoro(theIdInizioLavoro);	
		//theModel.addAttribute("inizioLavori", inizioLavoriList);
		return "interventi-form";
	}
	//@PostMapping("/saveInizioLavoro")
	//public String saveInizioLavoro(@ModelAttribute("inizioLavoro") InizioLavoro inizioLavoro, @RequestParam("idInizioLavoro") int idIniziolavoro) {
	//	InizioLavoro inizioLavoro = inizioLavoriService.getInizioLavoro(idIniziolavoro);
	//	inizioLavoriService.saveInizioLavoro(inizioLavoro);		
	//	return "redirect:/interventi/list";
//}
	@GetMapping("/showFormAddInizioLavoro")
	public String showFormAddInizioLavoro(@RequestParam("idIntervento") int theIdIntervento, Model theModel) {
		InizioLavoro inizioLavoro = inizioLavoriService.getInizioLavoro(theIdIntervento);
		theModel.addAttribute("inizioLavoro", inizioLavoro);
		return "interventi-form";
	}
}
