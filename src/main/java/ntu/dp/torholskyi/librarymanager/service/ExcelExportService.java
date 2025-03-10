package ntu.dp.torholskyi.librarymanager.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {

    public void exportCurrencyRatesToExcel(List<String> currencyData, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Currency Rates");

        // Заголовок таблиці
        Row headerRow = sheet.createRow(0);
        Cell cell1 = headerRow.createCell(0);
        cell1.setCellValue("Currency");
        Cell cell2 = headerRow.createCell(1);
        cell2.setCellValue("Buy");
        Cell cell3 = headerRow.createCell(2);
        cell3.setCellValue("Sale");

        // Додавання даних
        int rowNum = 1;
        for (String data : currencyData) {
            Row row = sheet.createRow(rowNum++);
            String[] columns = data.split(",");
            row.createCell(0).setCellValue(columns[0]);
            row.createCell(1).setCellValue(columns[1]);
            row.createCell(2).setCellValue(columns[2]);
        }

        // Запис у файл
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }

        workbook.close();
    }
}