package testUtils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	  
	public String path;
	 FileInputStream file;
	 XSSFWorkbook workbook;
	 XSSFSheet sheet;
	 XSSFRow row;
	 
	 public Excel_Reader(String path){
		  this.path = path;
		  try{
			file  = new FileInputStream(path); 
			 workbook = new XSSFWorkbook(file);
			  
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
	  }
	 
public String getCellData(String sheetName,String colName, int rowNum){
	  
	  try{
		int col_Num = 0;
		int index= workbook.getSheetIndex(sheetName);
	    sheet = workbook.getSheetAt(index);
	    row = sheet.getRow(0);
	    for(int i=0;i<row.getLastCellNum();i++){
	    	if(row.getCell(i).getStringCellValue().equals(colName)){
	     col_Num = i;
	    		
	    	}
	    	
	    }
	  row = sheet.getRow(rowNum-1);
	  XSSFCell cell = row.getCell(col_Num); 
	  if(cell.getCellType()==Cell.CELL_TYPE_STRING){
		 return cell.getStringCellValue();
	  }else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
		  return String.valueOf(cell.getNumericCellValue());
	  }else if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN){
		  return String.valueOf(cell.getBooleanCellValue()); 
	  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK){
		  return "";
	  }
		  
		  
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  
	return null;
	  
           }
         
public String getCellData(String sheetName,int colName, int rowNum){
	  
	  try{
	
		int index= workbook.getSheetIndex(sheetName);
	    sheet = workbook.getSheetAt(index);
	    row = sheet.getRow(0);
	   
	  row = sheet.getRow(rowNum-1);
	  XSSFCell cell = row.getCell(colName); 
	  if(cell.getCellType()==Cell.CELL_TYPE_STRING){
		 return cell.getStringCellValue();
	  }else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
		  return String.valueOf(cell.getNumericCellValue());
	  }else if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN){
		  return String.valueOf(cell.getBooleanCellValue()); 
	  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK){
		  return "";
	  }
		  
		  
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  
	return null;
           }
        public int getRowCount(String sheetName){
	  try{
	       int index = workbook.getSheetIndex(sheetName);
	       if(index == -1){
		return 0;
	        }else{
		sheet = workbook.getSheetAt(index);
		int number=sheet.getLastRowNum()+1;
		return number;
	}
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	return 0;
    }
	public int getColumnCount(String sheetName){
		try{
		int index = workbook.getSheetIndex(sheetName);
		if(index == -1){
			return 0;
	}else{
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(0);
		return row.getLastCellNum();
	}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
}
	
  
}
