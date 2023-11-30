package com.haceb.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Excel {

    public static ArrayList<Map<String, String>> leerDatosDeHojaDeExcel(String rutaDeExcel, String hojaDeExcel) throws IOException {
        ArrayList<Map<String, String>> arrayListDatoPlanTrabajo = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(rutaDeExcel));

        try (XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream)) {
            XSSFSheet newSheet = newWorkbook.getSheet(hojaDeExcel);
            Iterator<Row> rowIterator = newSheet.iterator();
            Row titulos = rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Map<String, String> informacionProyecto = new HashMap<>();
                for (Cell cell : row) {
                    int columnIndex = cell.getColumnIndex();
                    String key = titulos.getCell(columnIndex).getStringCellValue();
                    String value = getCellValueAsString(cell);
                    informacionProyecto.put(key, value);
                }
                arrayListDatoPlanTrabajo.add(informacionProyecto);
            }
        }

        return arrayListDatoPlanTrabajo;
    }

    private static String getCellValueAsString(Cell cell) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }
}
