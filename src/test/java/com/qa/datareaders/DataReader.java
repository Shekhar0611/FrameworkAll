package com.qa.datareaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

   static FileInputStream fin = null;
   static XSSFWorkbook workbook = null;
   static XSSFSheet sheet = null;
   static XSSFRow row = null;
  
   
      public static Object[][] readData1(String path,String sheetname) throws IOException
     {
        try {
	      fin= new FileInputStream(path); //Excel sheet file location get mentioned here
     } catch(FileNotFoundException e) {
	  e.printStackTrace();
      }
        try {
          workbook = new XSSFWorkbook (fin); //get my workbook 
      }catch(IOException e) {
	  e.printStackTrace();
      }
        
       sheet=workbook.getSheet(sheetname);
       row =sheet.getRow(0);
       int RowNum = sheet.getLastRowNum();// get last row
       int ColNum= row.getLastCellNum(); // get last ColNum 
       
       Object [][] data= new Object[RowNum][ColNum]; // pass my  count data in array
       
       for(int i=1; i<=sheet.getLastRowNum(); i++) //Loop work for Rows
       {  
    	   for (int j=0; j<row.getLastCellNum(); j++) //Loop work for cell
    	   {
               data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
    	   }
       } 
       
       return data;
      }
  
   }