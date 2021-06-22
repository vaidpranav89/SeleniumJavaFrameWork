package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDrivenExcel {
	public FileInputStream fis = null;
	public FileOutputStream fos=null;
	public XSSFWorkbook workbook = null;
	public XSSFWorkbook workbook2 = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String xlFilePath;
	private String sheetName;

	public dataDrivenExcel(String xlFilePath) throws Exception {
		this.xlFilePath = xlFilePath;
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();

	}


	public int getRowCount() {
		sheet = workbook.getSheet(this.sheetName);
		int rowCount = sheet.getLastRowNum() + 1;
		return rowCount;
	}

	public int getColumnCount(int currentRow) {
		sheet = workbook.getSheet(this.sheetName);
		row = sheet.getRow(currentRow);
		int colCount = row.getLastCellNum();
		return colCount;
	}

	public void setSheetName(String name) {
		this.sheetName=name;
	}

	public int getColIndex( String columnName) {
		// int sheetCounts=workbook.getNumberOfSheets();
		// for(int i=0 ;i<sheetCounts;i++) {
		// if(workbook.getSheetName(i).equalsIgnoreCase(sheetName)){
		// sheet= workbook.getSheetAt(i);
		sheet = workbook.getSheet(this.sheetName);
		Iterator<Row> rows = sheet.iterator();
		Row firstRow = rows.next(); // this is to align the pointer to first row
		Iterator<Cell> cells = firstRow.cellIterator();
		int j = 0;
		int coloumn = 0;
		while (cells.hasNext()) {
			String value = cells.next().getStringCellValue();
			// System.out.println(value);
			if (value.equalsIgnoreCase(columnName)) {
				coloumn = j;
			}
			j++;
		}
		return coloumn;
	}


	public String getCellValue( int r, int c)

	{




		sheet = workbook.getSheet(this.sheetName);

		Cell cell =sheet.getRow(r).getCell(c);

		return cell.getStringCellValue();






	}

	public void setCellValue( int r, int c, String value)

	{

		try

		{

			sheet = workbook.getSheet(this.sheetName);
			//sheet.createRow(r);
			sheet.getRow(r).createCell(c).setCellValue(value);
			fos = new FileOutputStream(xlFilePath);
			workbook.write(fos);
			fos.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}


	}

}
