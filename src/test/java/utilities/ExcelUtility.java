package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	public static  String path;
	public static  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFCell cell = null;
	static int col_Num;
	static Properties p;
	static FileInputStream inStream;
	
	public static String getCellData(String sheetname,String str,int row){
		col_Num=0;
		XSSFRow rowName=null;
		readExcelFile(sheetname);
		rowName = sheet.getRow(row);
		for(int i=0;i<rowName.getLastCellNum();i++){
			if(rowName.getCell(i).getStringCellValue().trim().equals(str.trim()))
				{
					col_Num=i;
					cell = rowName.getCell(col_Num+1);
					break;
				}
			}
		
		return cell.toString();
	}
	
	private static void readExcelFile(String sheetname){
	try {
		p = new Properties();
		inStream=new FileInputStream(new File(""+ "./src/main/resources/config/config.properties"));
		p.load(inStream);
		path=p.getProperty("dataFile").trim();
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		fis.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
