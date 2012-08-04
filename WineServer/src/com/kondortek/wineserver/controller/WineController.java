package com.kondortek.wineserver.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.datastore.KeyFactory;
import com.kondortek.wineserver.model.Wine;
import com.kondortek.wineserver.model.Winery;
import com.kondortek.wineserver.service.WineService;

@Controller
@RequestMapping("/wines")
public class WineController {

	@Resource
	WineService wineService;
	
	@RequestMapping("/list")
	public String getWines(ModelMap model) {

		List<Wine> wines = wineService.getAllWines();
		model.put("wines", wines);
		
		System.out.println("wines: " + wines);
		
		return "wine_list";
	}

	@RequestMapping(value = "/view/{keyAsString}", method = RequestMethod.GET)
	public String viewWine(@PathVariable String keyAsString, ModelMap model) {
		Wine wine = wineService.getWineByKey(KeyFactory.stringToKey(keyAsString));
		Winery winery = wineService.getWineryByKey(KeyFactory.stringToKey(wine.getWineryKey()));
		model.put("wine", wine);
		model.put("winery", winery);
		
		return "wine";
	}

	@RequestMapping(value = "/add/{name}", method = RequestMethod.GET)
	public String addWine(@PathVariable String name) {
		Wine wine = new Wine();
		wine.setName(name);
		wine.setType(name);
		
		Winery winery = wineService.getWineryByName("Husch");
		
		System.out.println("Wine to add: " + wine.getName());
		
		wineService.addWineToWinery(winery, wine);
		
		return "redirect:/wineries/view/" + wine.getWineryKey();
	}
	
}
