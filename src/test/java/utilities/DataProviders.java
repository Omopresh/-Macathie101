package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataProviders {

   // Data Provider 1
	
    @DataProvider(name="LoginData")
    public String[][] getData() throws IOException 
    	{
    	   String path = ".\\testData\\Macathie_LoginData.xlsx";// taking xl file from testData

           ExcelUtility xlutil=new ExcelUtility(path); // creating an object for XLUtility

           int totalrows = xlutil.getRowCount("Sheet1");
           int totalcols = xlutil.getCellCount("Sheet1",1);

        String logindata[][]=new String[totalrows][totalcols]; //created for two dimension array which can stored data

        for (int i=1;i<=totalrows;i++) //1  //read the data from xl storing in two dimensional array
        { 
            for (int j=0;j<totalcols;j++) //0  i is rows and j is col
            { 
                logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0    
            }
        }
        return logindata;  //returning two dimension array
    
      
    }
    //DataProvider 2
    	
    //DataProvider 3
    	
    //DataProvider 4
    	
    }
