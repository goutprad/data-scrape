package com.data.scrape;

public class Books {
	private String Name;
	private String ImageLink;
	private String Rating;
	private String Price;
	private String InStockOrNot;
	private String Category;

	public Books(String Name, String ImageLink, String Rating, String Price, String InStockOrNot, String Category) {
		this.Name = Name;
		this.ImageLink = ImageLink;
		this.Rating = Rating;
		this.Price = Price;
		this.InStockOrNot = InStockOrNot;
		this.Category = Category;
	}

	@Override
	public String toString() {
		return "Books [Name=" + Name + ", ImageLink=" + ImageLink + ", Rating=" + Rating + ", Price=" + Price
				+ ", InStockOrNot=" + InStockOrNot + ", Category=" + Category + "]";
	}

	public String getCategory() {
		return Category;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getImageLink() {
		return ImageLink;
	}

	public void setImageLink(String imageLink) {
		ImageLink = imageLink;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getInStockOrNot() {
		return InStockOrNot;
	}

	public void setInStockOrNot(String inStockOrNot) {
		InStockOrNot = inStockOrNot;
	}

	public void setCategory(String category) {
		Category = category;
	}
}
