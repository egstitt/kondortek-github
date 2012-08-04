package com.kondortek.wineserver.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.datastore.KeyFactory;
import com.kondortek.wineserver.model.Winery;
import com.kondortek.wineserver.service.WineService;

@Controller
@RequestMapping("/wineries")
public class WineryController {

	@Resource
	WineService wineService;
	
	@RequestMapping("/list")
	public String getWines(ModelMap model) {

		List<Winery> wineries = wineService.getAllWineries();
		model.put("wineries", wineries);
		
		return "winery_list";
	}

	@RequestMapping(value = "/add/{name}", method = RequestMethod.GET)
	public String addWinery(@PathVariable String name) {
		Winery winery = new Winery();
		winery.setName(name);
		
		System.out.println("Winery: " + winery);
		
		wineService.addWinery(winery);
		
		return "redirect:/wineries/list";
	}

	@RequestMapping(value = "/view/{keyAsString}", method = RequestMethod.GET)
	public String viewWinery(@PathVariable String keyAsString, ModelMap model) {
		Winery winery = wineService.getWineryByKey(KeyFactory.stringToKey(keyAsString));
		model.put("winery", winery);
		
		return "winery";
	}
}
