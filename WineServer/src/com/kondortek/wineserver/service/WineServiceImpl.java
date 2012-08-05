
package com.kondortek.wineserver.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.kondortek.wineserver.model.Wine;
import com.kondortek.wineserver.model.Winery;

@Repository
@Transactional
public class WineServiceImpl implements WineService {

	@PersistenceContext
	private EntityManager entityManager;
	
	/*
	 * (non-Javadoc)
	 * @see com.kondortek.wineserver.service.WineService#addWine(com.kondortek.wineserver.model.Wine)
	 */
	public void addWine(Wine wine) {
		entityManager.merge(wine);
	}

	/*
	 * (non-Javadoc)
	 * @see com.kondortek.wineserver.service.WineService#getAllWines()
	 */
	@SuppressWarnings("unchecked")
	public List<Wine> getAllWines() {
		return entityManager.createQuery("select w from Wine w").getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see com.kondortek.wineserver.service.WineService#addWinery(com.kondortek.wineserver.model.Winery)
	 */
	public void addWinery(Winery winery) {
		entityManager.merge(winery);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.kondortek.wineserver.service.WineService#getAllWineries()
	 */
	@SuppressWarnings("unchecked")
	public List<Winery> getAllWineries() {
		return entityManager.createQuery("select w from Winery w").getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see com.kondortek.wineserver.service.WineService#getWineByKey(com.google.appengine.api.datastore.Key)
	 */
	public Wine getWineByKey(Key key) {
		return entityManager.find(Wine.class, key);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.kondortek.wineserver.service.WineService#getWineByName(java.lang.String)
	 */
	public Wine getWineByName(String name) {
		
		Query query = entityManager.createQuery("select w from Wine w where w.name = :name");
		query.setParameter("name", name);
		
		Wine wine = (Wine) query.getSingleResult();
		
		return wine;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.kondortek.wineserver.service.WineService#getWineryByKey(com.google.appengine.api.datastore.Key)
	 */
	public Winery getWineryByKey(Key key) {
		Winery winery = entityManager.find(Winery.class, key);

		// Hack to force datastore to populate the wine list.
		for (Wine wine : winery.getWines());
		
		return winery;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.kondortek.wineserver.service.WineService#getWineryByName(java.lang.String)
	 */
	public Winery getWineryByName(String name) {
		Query query = entityManager.createQuery("select w from Winery w where w.name = :name");
		query.setParameter("name", name);
		
		Winery winery = (Winery) query.getSingleResult();
		
		// Hack to force datastore to populate the wine list.
		for (Wine wine : winery.getWines());
		
		return winery;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.kondortek.wineserver.service.WineService#addWineToWinery(com.kondortek.wineserver.model.Winery, com.kondortek.wineserver.model.Wine)
	 */
	public Winery addWineToWinery(Winery winery, Wine wine) {
		winery.getWines().add(wine);
//		wine.setWinery(winery);
		wine.setWineryKey(KeyFactory.keyToString(winery.getKey()));

		return entityManager.merge(winery);
	}
}
