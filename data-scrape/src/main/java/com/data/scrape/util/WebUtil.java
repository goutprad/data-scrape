package com.data.scrape.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.data.scrape.Books;
import com.data.scrape.Category;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebUtil {
	public List<Category> categoryList = null;
	public List<Books> bookList = null;
	public void getWebDetails() {
		categoryList = new ArrayList<>();
		bookList = new ArrayList<>();
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		try {
			HtmlPage page = client.getPage("http://books.toscrape.com/catalogue/category/books_1/page-1.html");
			List<HtmlElement> itemList = page.getByXPath(".//article[@class='product_pod']");

			for (HtmlElement htmlElement : itemList) {
				HtmlElement tittleTag = htmlElement.getFirstByXPath(".//h3/a");
				HtmlElement imageTag = htmlElement.getFirstByXPath(".//div[@class='image_container']/a");
				HtmlElement RatingTag = htmlElement.getFirstByXPath(".//p");
				HtmlElement priceTag = htmlElement.getFirstByXPath(".//div[@class='product_price']/p");
				HtmlElement instockTag = htmlElement
						.getFirstByXPath(".//div[@class='product_price']/p[@class='instock availability']");

				String Link = imageTag.getAttribute("href").replace("../..", "http://books.toscrape.com/catalogue");
				HtmlPage detailsPage = client.getPage(Link);
				HtmlElement categoryDet = detailsPage.getFirstByXPath(".//ul[@class='breadcrumb']/li[3]/a");

				String Name = tittleTag.getAttribute("title");
				String ImageLink = Link;
				String Rating = RatingTag.getAttribute("class").split(" ")[1];
				String Price = priceTag.getTextContent();
				String InStockOrNot = instockTag.getTextContent().trim();
				String Category_Name = categoryDet.getTextContent();
				bookList.add(new Books(Name, ImageLink, Rating, Price, InStockOrNot, Category_Name));

				String Cat_ImageLink = categoryDet.getAttribute("href").replace("..",
						"http://books.toscrape.com/catalogue");
				categoryList.add(new Category(Category_Name, Cat_ImageLink));

			}
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		}
	}

}
