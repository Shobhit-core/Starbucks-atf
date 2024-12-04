package com.starbucks.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtil(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    public String getCellData(int row, int col) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(row).getCell(col));
    }

    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    public String getBrowserFromExcel(int row) {
        return getCellData(row, 0); // Assuming the browser is in column 0
    }

    public String getUrlFromExcel(int row) {
        return getCellData(row, 1); // Assuming the URL is in column 1
    }

    public String getUsernameFromExcel(int row) {
        return getCellData(row, 2); // Assuming the username is in column 2
    }

    public String getPasswordFromExcel(int row) {
        return getCellData(row, 3); // Assuming the password is in column 3
    }
}