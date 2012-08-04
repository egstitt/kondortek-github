package com.kondortek.wineserver.service;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.kondortek.wineserver.model.Wine;
import com.kondortek.wineserver.model.Winery;

public interface WineService {

	public void addWine(Wine wine);
	
	public List<Wine> getAllWines();

	public void addWinery(Winery winery);
	
	public List<Winery> getAllWineries();

	public Wine getWineByKey(Key key);

	public Wine getWineByName(String name);
	
	public Winery getWineryByKey(Key key);
	
	public Winery getWineryByName(String name);
	
	public Winery addWineToWinery(Winery winery, Wine wine);
}
