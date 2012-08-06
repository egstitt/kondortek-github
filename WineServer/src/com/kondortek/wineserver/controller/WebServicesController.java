package com.kondortek.wineserver.controller;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.KeyFactory;
import com.kondortek.wineserver.model.Wine;
import com.kondortek.wineserver.model.Winery;
import com.kondortek.wineserver.service.WineService;

@Controller
@RequestMapping("/ws")
public class WebServicesController {

	
	private static final Logger log = Logger.getLogger(WebServicesController.class.getName());
	
	@Resource
	WineService wineService;

	@RequestMapping(value = "/wine/{keyAsString}", method = RequestMethod.GET )
	public ModelAndView getWine(@PathVariable String keyAsString) {
		Wine wine = wineService.getWineByKey(KeyFactory.stringToKey(keyAsString));
		
		return new ModelAndView("jaxbView", "command", wine);
	}
	
	@RequestMapping(value = "/winery/{keyAsString}", method = RequestMethod.GET, headers="Accept=application/xml" )
	public ModelAndView getWinery(@PathVariable String keyAsString) {
		Winery winery = wineService.getWineryByKey(KeyFactory.stringToKey(keyAsString));
		
		return new ModelAndView("jaxbView", "command", winery);
	}
	
}
