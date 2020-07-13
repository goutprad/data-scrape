package com.data.scrape;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Scrapper {
	public static void main(String[] args) {
		WebUtil det = new WebUtil();
		det.getWebDetails();
		List<Books> bookList = det.bookList;
		List<Category> categoryList = det.categoryList;
		Statement statement = null;
		Connection con = null;

		// Get Connection
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "1234");
			statement = con.createStatement();

			// Insert to RDBMS - Category
			for (Category cat : categoryList) {
				System.out.println(cat.toString());
				statement.executeUpdate(
						"insert ignore into category(Name,Link) values(" + "'" + cat.getName() + "','" + cat.getLink() + "')");
			}

			// Insert to RDBMS-Book
			for (Books book : bookList) {
				System.out.println(book.toString());
				statement.executeUpdate("insert ignore into books(Name,ImageLink,Rating,Price,InStockOrNot,Category) values("
						+ "\"" + book.getName() + "\",'" + book.getImageLink() + "','" + book.getRating() + "','"
						+ book.getPrice() + "','" + book.getInStockOrNot() + "','" + book.getCategory() + "')");
			}

			System.out.println("======Succesfully inserted========");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
