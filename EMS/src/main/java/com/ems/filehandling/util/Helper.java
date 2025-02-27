package com.ems.filehandling.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ems.filehandling.domain.StudentResultEntity;

public class Helper {
	public static List<StudentResultEntity> saveExcelDataIntoDatabase(InputStream is) {
		List<StudentResultEntity> std = new ArrayList<>();

		Workbook workbook = null;

		try {
			workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet("Sheet1");

//			for (Row row : sheet) {
//				StudentResultEntity stdEnt = new StudentResultEntity();
//
//				stdEnt.setName(row.getCell(0).getStringCellValue());
//				stdEnt.setExamName(row.getCell(1).getStringCellValue());
//				stdEnt.setExamDate(row.getCell(2).getStringCellValue());
//				stdEnt.setMarks(row.getCell(3).getStringCellValue());
//				stdEnt.setPassStatus(row.getCell(4).getStringCellValue());
//
//				std.add(stdEnt);
//			}

			Iterator<Row> rows = sheet.iterator();

			// to skip first row which contains header of columns
			rows.next();

			while (rows.hasNext()) {
				Row row = rows.next();

				Iterator<Cell> cells = row.iterator();

				StudentResultEntity stdEnt = new StudentResultEntity();

				int colcount = 1;

				while (cells.hasNext()) {
					Cell cell = cells.next();
					switch (colcount) {
					case 1: {
						stdEnt.setName(cell.getStringCellValue());
//						stdEnt.setName(rows.next().getCell(0).getStringCellValue());
						break;
					}
					case 2: {
						stdEnt.setExamName(cell.getStringCellValue());
						break;
					}
					case 3: {
						stdEnt.setExamDate(NumberToTextConverter.toText(cell.getNumericCellValue()));
						break;
					}
					case 4: {
						stdEnt.setMarks(cell.getNumericCellValue());
						break;
					}
					case 5: {
						stdEnt.setPassStatus(cell.getBooleanCellValue());
						break;
					}
					default:
						throw new IllegalArgumentException("Column value inaccessible.");
					}
					colcount++;
				}

				std.add(stdEnt);
			}
			workbook.close();

		} catch (

		Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return std;
	}
}
