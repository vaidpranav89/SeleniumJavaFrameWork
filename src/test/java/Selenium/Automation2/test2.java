package Selenium.Automation2;

import resources.dataDrivenExcel;

public class test2 {

	public static void main(String[] args) throws Exception {


		dataDrivenExcel excel = new dataDrivenExcel(System.getProperty("user.dir")+ "\\excelDataDriven.xlsx");
		//System.out.println(excel.workbook.getNumberOfSheets());
		excel.setSheetName("Input");
		System.out.println(excel.getCellValue( 0, 0));
		//excel.setCellValue( 10, 2, "Pranav");
		//System.out.println(excel.getCellValue( 10, 2));

		int rowCount= excel.getRowCount();
		System.out.println(rowCount);
		int colCount= excel.getColumnCount(0);
		System.out.println(colCount);

		for (int k = 0; k<rowCount; k++){
			String myItemvalue= "";
			for (int j = 0; j<colCount;j++){
				//System.out.println(excel.cell.getCellType());
				//System.out.println(excel.getCellValue( k, j));
				myItemvalue= myItemvalue+excel.getCellValue( k, j);

			}
			System.out.println(myItemvalue);
		}




	}
}
