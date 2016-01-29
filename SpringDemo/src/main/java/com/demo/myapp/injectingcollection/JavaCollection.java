package com.demo.myapp.injectingcollection;

import java.util.*;

public class JavaCollection {
	List list;
	Set set;
	Map map;
	Properties properties;

	// Prints and returns all the element of the List
	public List getList() {
		System.out.println("List: " + list);
		return list;
	}

	// set List
	public void setList(List list) {
		this.list = list;
	}

	// Prints and returns all the element of the Set
	public Set getSet() {
		System.out.println("Set: " + set);
		return set;
	}

	// set Set
	public void setSet(Set set) {
		this.set = set;
	}

	// Prints and returns all the element of the Map
	public Map getMap() {
		System.out.println("Map: " + map);
		return map;
	}

	// set Map
	public void setMap(Map map) {
		this.map = map;
	}

	// Prints and returns all the element of the Properties
	public Properties getProperties() {
		System.out.println("Properties: " + properties);
		return properties;
	}

	// set Properties
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
