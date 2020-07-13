package com.data.scrape;

public class Category {
	private String Name;
	private String Link;
	
	public Category(String Name, String Link) {
		this.Link = Link;
		this.Name = Name;
	}

	@Override
	public String toString() {
		return "Category [Name=" + Name + ", Link=" + Link + "]";
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}
}
