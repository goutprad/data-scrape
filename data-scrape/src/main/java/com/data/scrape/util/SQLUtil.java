package com.data.scrape.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.data.scrape.Books;
import com.data.scrape.Category;

public class SQLUtil {
	Statement statement = null;
	Connection con = null;

	public void insertToBookstable(List<Books> bookList, String URL, String dbname, String UserName, String Password) {
		// Get Connection
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + URL + "/" + dbname, UserName, Password);
			statement = con.createStatement();

			// Insert to RDBMS-Book
			for (Books book : bookList) {
				System.out.println(book.toString());
				statement.executeUpdate(
						"insert ignore into books(Name,ImageLink,Rating,Price,InStockOrNot,Category) values(" + "\""
								+ book.getName() + "\",'" + book.getImageLink() + "','" + book.getRating() + "','"
								+ book.getPrice() + "','" + book.getInStockOrNot() + "','" + book.getCategory() + "')");
			}

			System.out.println("======Succesfully inserted into books table ========");
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

	public void insertToCategoryTable(List<Category> categoryList, String URL, String dbname, String UserName,
			String Password) {
		// Get Connection
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + URL + "/" + dbname, UserName, Password);
			statement = con.createStatement();
			// Insert to RDBMS - Category
			for (Category cat : categoryList) {
				System.out.println(cat.toString());
				statement.executeUpdate("insert ignore into category(Name,Link) values(" + "'" + cat.getName() + "','"
						+ cat.getLink() + "')");
			}
			System.out.println("======Succesfully inserted into category table========");
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
