package com.data.scrape.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.data.scrape.Books;
import com.data.scrape.Category;

public class CSVUtil {
	public void writeBooksToCSV(String fileName, List<Books> booksList) {
		ICsvBeanWriter beanWriter = null;
		CellProcessor[] booksProcessor = new CellProcessor[] { new NotNull(), // Name
				new NotNull(), // ImageLink
				new NotNull(), // Price
				new NotNull(), // InStockOrNot
				new NotNull() // Category
		};

		try {
			beanWriter = new CsvBeanWriter(new FileWriter(fileName), CsvPreference.STANDARD_PREFERENCE);
			String[] header = { "Name", "ImageLink", "Price", "InStockOrNot", "Category" };
			beanWriter.writeHeader(header);

			for (Books book : booksList) {
				beanWriter.write(book, header, booksProcessor);
			}

		} catch (IOException ex) {
			System.err.println("Error while writing books data to CSV: " + ex);
		} finally {
			if (beanWriter != null) {
				try {
					beanWriter.close();
				} catch (IOException ex) {
					System.err.println("Error while closing books writer: " + ex);
				}
			}
		}
	}

	public void writeCategoryToCSV(String fileName, List<Category> categoryList) {
		ICsvBeanWriter beanWriter = null;
		CellProcessor[] booksProcessor = new CellProcessor[] { new NotNull(), // Name
				new NotNull(), // Link
		};

		try {
			beanWriter = new CsvBeanWriter(new FileWriter(fileName), CsvPreference.STANDARD_PREFERENCE);
			String[] header = { "Name", "Link" };
			beanWriter.writeHeader(header);

			for (Category category : categoryList) {
				beanWriter.write(category, header, booksProcessor);
			}

		} catch (IOException ex) {
			System.err.println("Error while writing category data to CSV: " + ex);
		} finally {
			if (beanWriter != null) {
				try {
					beanWriter.close();
				} catch (IOException ex) {
					System.err.println("Error while closing category writer: " + ex);
				}
			}
		}
	}
}
