package com.kondortek.wineserver.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
@Entity
@XmlRootElement(name = "wine")
public class Wine {

	/******************************** Properties *********************************************/
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

    @Basic
    private String wineryKey;
    
    @Basic
	private String name;
	
    @Basic
	private String type;
	

	/******************************** Getters/Setters ****************************************/
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWineryKey() {
		return wineryKey;
	}

	public void setWineryKey(String wineryKey) {
		this.wineryKey = wineryKey;
	}
}
