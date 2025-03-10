package ntu.dp.torholskyi.librarymanager.controller;

import ntu.dp.torholskyi.librarymanager.service.ExcelExportService;
import ntu.dp.torholskyi.librarymanager.service.CurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ExcelExportController {

    private final CurrencyService currencyService;
    private final ExcelExportService excelExportService;

    public ExcelExportController(CurrencyService currencyService, ExcelExportService excelExportService) {
        this.currencyService = currencyService;
        this.excelExportService = excelExportService;
    }

    @GetMapping("/api/export/currency")
    public ResponseEntity<String> exportCurrencyRatesToExcel(@RequestParam String filePath) {
        try {
            List<String> currencyData = List.of(
                    "USD,27.09,27.65", // приклад даних, замінити на реальні з API
                    "EUR,29.45,30.15"
            );
            excelExportService.exportCurrencyRatesToExcel(currencyData, filePath);
            return ResponseEntity.ok("File successfully created at: " + filePath);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to create Excel file");
        }
    }
}
