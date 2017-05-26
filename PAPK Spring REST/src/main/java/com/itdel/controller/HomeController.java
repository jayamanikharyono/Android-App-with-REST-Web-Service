package com.itdel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itdel.model.Fasilitas;
import com.itdel.model.Kegiatan;
import com.itdel.service.FasilitasService;
import com.itdel.service.KegiatanService;
import com.itdel.service.KegiatanServiceImpl;


@Controller
public class HomeController {
	@Autowired
	KegiatanService kegiatanService;
	@Autowired
	FasilitasService fasilitasService;

	@RequestMapping("/")
	public String index()
	{
		return "indexPage";
	}
	
	@RequestMapping("/kegiatan")
	public String indexKegiatan(Model model)
	{
		model.addAttribute("allkegiatan", kegiatanService.findAllKegiatan());
		return "kegiatan/indexPage";
	}
	
	@RequestMapping("/fasilitas")
	public String indexFasilitas(Model model)
	{
		model.addAttribute("allfasilitas", fasilitasService.findAllFasilitas());
		return "fasilitas/indexPage";
	}
	//kegiatan
	@RequestMapping(value = "/kegiatan/add", method = RequestMethod.GET)
	public String insertKegiatanPage(Model model)
	{
		model.addAttribute("kegiatan", new Kegiatan());
		return "kegiatan/insertPage";
	}
	
	@RequestMapping(value = "/kegiatan/add", method = RequestMethod.POST)
	public String insertKegiatan(@Valid Kegiatan kegiatan)
	{
		kegiatanService.save(kegiatan);
		return "redirect:/kegiatan";
	}
	@RequestMapping("kegiatan/delete/{id}")
	public String deleteKegiatan(@PathVariable Integer id)
	{
		kegiatanService.deleteById(id);
		return "redirect:/kegiatan";
	}
	
	//fasilitas
	@RequestMapping(value = "/fasilitas/add", method = RequestMethod.GET)
	public String insertFasilitasPage(Model model)
	{
		model.addAttribute("fasilitas", new Fasilitas());
		return "fasilitas/insertPage";
	}
	
	@RequestMapping(value = "/fasilitas/add", method = RequestMethod.POST)
	public String insertFasilitas(@Valid Fasilitas fasilitas)
	{
		fasilitasService.save(fasilitas);
		return "redirect:/fasilitas";
	}
	
	@RequestMapping("fasilitas/delete/{id}")
	public String deleteFasilitas(@PathVariable Integer id)
	{
		fasilitasService.deleteById(id);
		return "redirect:/fasilitas";
	}
}
