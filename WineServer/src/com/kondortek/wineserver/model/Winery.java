package com.kondortek.wineserver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Entity
@XmlRootElement(name = "winery")
public class Winery {

	/******************************** Properties *********************************************/
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
    
    @Basic
	private String name;

    /******************************** Relationships ******************************************/
    
    @OneToMany(mappedBy = "winery", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Wine> wines = new ArrayList<Wine>();
    
    /******************************** Getters/Setters ****************************************/
    
	public Key getKey() {
		return key;
	}

	@Transient
	public String getKeyAsString() {
		return KeyFactory.keyToString(key);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElementWrapper(name = "wines")
	@XmlElement(name = "wine")
	public List<Wine> getWines() {
		return wines;
	}

	public void setWines(List<Wine> wines) {
		this.wines = wines;
	}
}
