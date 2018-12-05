package com.sampleform;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        String formURL = "https://ecse.cse.state.ma.us/uwps/wps/portal/Home/cwp/customerwebsitehome/!ut/p/b1/04_Sj9CPykssy0xPLMnMz0vMAfGjzOJ9DD3dDR0tDLwtHI1dDRxNfD19Qk2djQ0MzIEKIoEKDHAARwNC-sP1o8BKzC2NHA2NTQy9DAw8XQwc_Y1DTLyNXYwMDMygCpzdHT1MzH2AhppYGAHVOHm4mFv6AlXDFOBxg59Hfm6qfkFuhEFmQLoiAEPvPKc!/dl4/d5/L2dBISEvZ0FBIS9nQSEh/#wlp_applyForBenefits_1_4";

        String excelFileLocation = "/Users/sritejkurapati/NUMBER FILE/Sample_Excel.xlsx";

        FileInputStream fileInputStream = new FileInputStream(excelFileLocation);
        Workbook workbook = new XSSFWorkbook(fileInputStream);

        int numberOfSheets = workbook.getNumberOfSheets();

        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.println( cell.getCellType());
                    System.out.println(cell.getStringCellValue());

                }
            }
        }
        fileInputStream.close();

    }
}
