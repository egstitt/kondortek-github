package com.kondortek.wineserver.service;

import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.kondortek.wineserver.model.Wine;
import com.kondortek.wineserver.model.Winery;

public interface WineService {

	/**
	 * Adds a Wine to the datastore.
	 * 
	 * @param wine - the Wine to add.
	 */
	public void addWine(Wine wine);

	/**
	 * Gets the list of all Wines.
	 * 
	 * @return - the list of all Wines.
	 */
	public List<Wine> getAllWines();

	/**
	 * Adds a Winery to the datastore.
	 * 
	 * @param winery - the Winery to add.
	 */
	public void addWinery(Winery winery);
	
	/**
	 * Gets the list of all Wineries.
	 * 
	 * @return - the list of all Wineries.
	 */
	public List<Winery> getAllWineries();

	/**
	 * Gets a Wine by its Key.
	 * 
	 * @param key - the Key of the Wine we want.
	 * @return - the Wine.
	 */
	public Wine getWineByKey(Key key);

	/**
	 * Gets a Wine by its name.
	 * 
	 * @param name - the name of the Wine we want.
	 * @return - the Wine.
	 */
	public Wine getWineByName(String name);
	
	/**
	 * Gets a Winery by its Key.
	 * 
	 * @param key - the Key of the Winery we want.
	 * @return - the Winery.
	 */
	public Winery getWineryByKey(Key key);
	
	/**
	 * Gets a Winery by its name.
	 * 
	 * @param name - the name of the Winery we want.
	 * @return - the Winery.
	 */
	public Winery getWineryByName(String name);
	
	/**
	 * Adds the given Wine to the given Winery.
	 * 
	 * @param winery - the Winery to add the Wine to.
	 * @param wine - the Wine to add.
	 * @return - the updated Winery.
	 */
	public Winery addWineToWinery(Winery winery, Wine wine);
}
