package com.data.scrape.driver;

import java.util.List;

import com.data.scrape.Books;
import com.data.scrape.Category;
import com.data.scrape.util.CSVUtil;
import com.data.scrape.util.SQLUtil;
import com.data.scrape.util.WebUtil;

public class Scrapper {
	public static void main(String[] args) {
		WebUtil det = new WebUtil();
		det.getWebDetails();
		List<Books> bookList = det.bookList;
		List<Category> categoryList = det.categoryList;
		CSVUtil csvwriter = new CSVUtil();
		csvwriter.writeBooksToCSV("target/books.csv", bookList);
		csvwriter.writeCategoryToCSV("target/category.csv", categoryList);

		SQLUtil sqlWriter = new SQLUtil();
		sqlWriter.insertToBookstable(bookList, "<URL>", "<dbname>", "<UserName>", "<Password>");
		 sqlWriter.insertToCategoryTable(categoryList, "<URL>", "<dbname>", "<UserName>", "<Password>");
	}
}
