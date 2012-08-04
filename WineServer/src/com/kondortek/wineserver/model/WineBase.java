package com.kondortek.wineserver.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WineBase {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
