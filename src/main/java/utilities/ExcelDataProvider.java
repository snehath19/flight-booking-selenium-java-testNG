package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {
    public static Object[][] getDataArray(String filepath, String sheetName) throws IOException
    {

        File myFile=new File(filepath);
        FileInputStream myStream=new FileInputStream(myFile);
        XSSFWorkbook myWorkbook=new XSSFWorkbook(myStream);
        XSSFSheet mySheet=myWorkbook.getSheet(sheetName);

        int numRows=mySheet.getLastRowNum();
        System.out.println(numRows);
        int numCols=mySheet.getRow(0).getLastCellNum();
        System.out.println(numCols);
        String[][]excelData=new String[numRows][numCols];
        for(int i=1;i<=numRows;i++)
        {
            XSSFRow row=mySheet.getRow(i);
            for(int j=0;j<numCols;j++)
            {
                XSSFCell cell=row.getCell(j);
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
