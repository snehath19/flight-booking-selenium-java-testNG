package Utilities;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {
    public static Object[][] getDataArray(String filepath, String sheetName) throws IOException
    {
        File myFile=new File(filepath);
        FileInputStream myStream=new FileInputStream(myFile);
        HSSFWorkbook myWorkbook=new HSSFWorkbook(myStream);
        //  HSSFSheet mySheet=myWorkbook.getSheetAt(0);
        HSSFSheet mySheet=myWorkbook.getSheet(sheetName);

        int numRows=mySheet.getLastRowNum();
        System.out.println(numRows);
        int numCols=mySheet.getRow(0).getLastCellNum();
        System.out.println(numCols);
        String[][]excelData=new String[numRows][numCols];
        for(int i=1;i<=numRows;i++)
        {
            HSSFRow row=mySheet.getRow(i);
            for(int j=0;j<numCols;j++)
            {
                HSSFCell cell=row.getCell(j);
                if (cell.getCellType() == CellType.STRING) {
                    String cellData = cell.getStringCellValue().replaceAll("┬«", "®").replaceAll("Γäó", "™").replaceAll("ΓÇ¥", "”");
                    excelData[i-1][j]=cellData;
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    String cellData = String.valueOf(cell.getNumericCellValue());
                    excelData[i-1][j]=cellData;
                }
            }}
        return excelData;
    }
}
