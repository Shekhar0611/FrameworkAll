package com.qa.datareaders;

import java.io.IOException;



import org.testng.annotations.DataProvider;
import com.qa.testbase.Constants;

public class DataProviders {
		
    @DataProvider(name="CommonDataProvider")
    public Object [][] getDataFromExcel() throws IOException 
    {
        Object[][] data = DataReader.readData1(Constants.MASTER_XL_PATH,Constants.MASTER_XL_SHEETNAME);
        return data;
        
    }

}