package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream fis = null;

    public FileInputStream getFileInputStream() {

        String filePath = System.getProperty("user.dir") + "/src/test/java/data/userData.xlsx";
        File srcFile = new File(filePath);
        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("error !!  " + e.getMessage());
        }

        return fis;

    }

    public Object[][] getExcelData() throws IOException {
        fis = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int totalNumOfRows = (sheet.getLastRowNum() + 1);
        int totalNumOfCols = 4;
        String[][] arrayOfExcelData = new String[totalNumOfRows][totalNumOfCols];
        for (int i = 0; i < totalNumOfRows; i++) {
            for (int j = 0; j < totalNumOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayOfExcelData[i][j] = row.getCell(j).toString();

            }

        }
        System.out.println(arrayOfExcelData.length);
        wb.close();
        return arrayOfExcelData;
    }


}

