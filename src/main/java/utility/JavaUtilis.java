package utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class JavaUtilis {


	// Method to get the URL Link
	public static String openURL(String key) {
		String filePath = System.getProperty("user.dir") + "/configure.properties";
		String value = null;
		try {
			Properties prop = new Properties();

			FileInputStream inStream = new FileInputStream(filePath);

			prop.load(inStream);

			value = prop.getProperty(key);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return value;
	}

	// method the get the test input from excel
	public static String readingExcel(String sheet, int row, int column) {

		String result = null;

		try {

			String filePath = System.getProperty("user.dir") + "/TestInput.xlsx";
			DataFormatter format = new DataFormatter();

			FileInputStream inStream = new FileInputStream(filePath);

			XSSFWorkbook book = new XSSFWorkbook(inStream);

			XSSFCell cell = book.getSheet(sheet).getRow(row).getCell(column);

			result = format.formatCellValue(cell);

			book.close();

			inStream.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}
}