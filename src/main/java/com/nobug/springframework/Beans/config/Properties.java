package com.nobug.springframework.Beans.config;

import java.util.ArrayList;
import java.util.List;

public class Properties {
	private final List<Property> properties = new ArrayList<Property>();

	public int getSize(){
		return properties.size();
	}
	public void addProperty(Property property) {
		this.properties.add(property);
	}

	public Property[] getPropertyValues() {
		return this.properties.toArray(new Property[0]);
	}

	public Property getPropertyValue(String propertyName) {
		return properties.stream().filter(property -> property.getName().equals(propertyName)).findFirst().orElse(null);
	}
}
