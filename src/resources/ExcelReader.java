package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * The Class ExcelReader.
 */
public class ExcelReader {

	/** The wrksheet. */
	public static Sheet wrksheet;

	/** The wrkbook. */
	public static Workbook wrkbook;

	/** The row count. */
	public int rowNumberValue, columnNumberValue, rowCount;

	/** The cell value. */
	public String cellValue;

	/** The row id. */
	String rowId;

	/** The file path. */
	String filePath;

	/** The sheet name. */
	String sheetName;

	/** The l. */
	@SuppressWarnings("rawtypes")
	public Iterator l;

	/**
	 * Instantiates a new excel reader.
	 * 
	 * @param filePath
	 *            the file path
	 * @param sheetName
	 *            the sheet name
	 * @param rowId
	 *            the row id
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public ExcelReader(String filePath, String sheetName, String rowId) throws IOException {
		this.filePath = filePath;
		this.sheetName = sheetName;
		this.rowId = rowId;
	}

	/**
	 * R excel reader.
	 * 
	 * @param ColumnName
	 *            the column name
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unchecked")
	public String RExcelReader(String ColumnName) throws IOException {
		File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);
		wrkbook = new XSSFWorkbook(fis);
		wrksheet = wrkbook.getSheet(sheetName);
		rowCount = wrksheet.getLastRowNum() - wrksheet.getFirstRowNum();
		Row rowNum = wrksheet.getRow(0);
		@SuppressWarnings("rawtypes")
		HashMap hm = new HashMap();
		for (int k = 0; k < rowNum.getLastCellNum(); k++) {
			hm.put(k + 1, rowNum.getCell(k).getStringCellValue());
		}
		@SuppressWarnings("rawtypes")
		Set set = hm.entrySet();
		l = set.iterator();
		for (int i = 0; i <= rowCount; i++) {
			Row row = wrksheet.getRow(i);
			if (row.getCell(0).getStringCellValue().equalsIgnoreCase(rowId)) {
				rowNumberValue = i;
				break;
			}
		}

		while (l.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry me = (Map.Entry) l.next();
			if (me.getValue().equals(ColumnName)) {
				columnNumberValue = (int) me.getKey();
				break;
			}
		}

		cellValue = wrksheet.getRow(rowNumberValue).getCell(columnNumberValue - 1).getStringCellValue();
		// System.out.println(cellValue);
		return cellValue;
	}

	/**
	 * R excel writer.
	 *
	 * @param ColumnName
	 *            the column name
	 * @param setcellvalue
	 *            the setcellvalue
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void RExcelWriter(String ColumnName, String setcellvalue) throws IOException {
		File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);
		wrkbook = new XSSFWorkbook(fis);
		wrksheet = wrkbook.getSheet(sheetName);
		rowCount = wrksheet.getLastRowNum() - wrksheet.getFirstRowNum();
		Row rowNum = wrksheet.getRow(0);
		@SuppressWarnings("rawtypes")
		HashMap hm = new HashMap();

		for (int k = 0; k < rowNum.getLastCellNum(); k++) {
			hm.put(k + 1, rowNum.getCell(k).getStringCellValue());
		}

		@SuppressWarnings("rawtypes")
		Set set = hm.entrySet();
		l = set.iterator();

		for (int i = 0; i <= rowCount; i++) {
			Row row = wrksheet.getRow(i);
			if (row.getCell(0).getStringCellValue().equalsIgnoreCase(rowId)) {
				rowNumberValue = i;
				break;
			}

		}

		while (l.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry me = (Map.Entry) l.next();
			if (me.getValue().equals(ColumnName)) {
				columnNumberValue = (int) me.getKey();
				break;
			}
		}

		wrksheet.getRow(rowNumberValue).getCell(columnNumberValue - 1).setCellValue(setcellvalue);
		fis.close();

		try {

			FileOutputStream outputStream = new FileOutputStream(filePath);
			wrkbook.write(outputStream);
		} catch (FileNotFoundException filenotfound) {
			System.out.println(filenotfound.getMessage());
		}

	}

}
