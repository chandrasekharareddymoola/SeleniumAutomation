package com.eagle.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadKeywords {
	
	public static String[] readKeyword(String filepath) throws IOException {

		FileInputStream fStream = new FileInputStream(new File(filepath));

		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("KeywordFrame"); // getting first sheet
		int rowcount = sheet.getLastRowNum();
		String[] excelData = new String[rowcount + 1];
		excelData[0] = "";
		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			if (row.getCell(1) != null && row.getCell(1).toString().length() != 0) {

				excelData[i] = "empty";
			} else {
				XSSFCell cell = row.getCell(3);
				
				excelData[i] = cell.toString();
			}

		}
		//workbook.close();
		return excelData;
	}

	public static List readTestcase(String filepath) throws IOException {
		List<String> testCases = new ArrayList<>();
		FileInputStream fStream = new FileInputStream(new File(filepath));

		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("KeywordFrame"); // getting first sheet
		int rowcount = sheet.getLastRowNum();
		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			if (row.getCell(1) != null && row.getCell(1).toString().length() != 0) {
				testCases.add(row.getCell(1).toString());
			}

		}
		//workbook.close();
		return testCases;
	}

	public static String getInputParameters(String filepath, int rownum) throws IOException {

		FileInputStream fStream = new FileInputStream(new File(filepath));

		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("KeywordFrame");
		// getting first sheet
		String cell = new String("");
		if (sheet.getRow(rownum) != null && sheet.getRow(rownum).getCell(4) != null) {
			cell = sheet.getRow(rownum).getCell(4).toString();
			if(cell.endsWith(".0"))
				cell = cell.substring(0, cell.length()-2);
		}
		//workbook.close();
		return cell;

	}

	public static void writeResult(List<String> testResult, long[] time) throws Exception {
		System.out.println("write");
		String srcpath = "./Resources/TestCases.xlsx";
		String despath = ".\\Output\\";
		String currentDateTime = new Date().toString().replace(':', '.');
		File fi;
		fi = new File(srcpath);
		Files.copy(fi.toPath(), (new File(despath + "TestResult(" + currentDateTime + ").xlsx")).toPath());
		File src = new File(".\\OutPut\\TestResult(" + currentDateTime + ").xlsx");
		FileInputStream finput = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(finput);

		XSSFSheet sheet = workbook.getSheet("Keyword Frame");
		for (int i = 1; i <= testResult.size(); i++) {
			try {
				Row row = sheet.getRow(i);
				Cell cell = row.createCell(6);
				if (testResult.get(i - 1).equals(",")) {

				} else {
					cell.setCellValue(testResult.get(i - 1));
				}
			} catch (NullPointerException e) {

			}

		}
		//String totalresult = testResult.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(""));
		String totalresult = null;
		System.out.println(totalresult);
		String[] tcresult = totalresult.split(" ");
		System.out.println(tcresult.length);
		List<String> caseresult = new ArrayList<>();
		for (int i = 0; i < tcresult.length - 1; i++) {

			if (tcresult[i + 1].contains("FAILED")) {
				caseresult.add("FAILED");
			} else {
				caseresult.add("PASSED");
			}
		}
		System.out.println(caseresult);
		List<String> cases = readTestcase(srcpath);
		XSSFSheet summary = workbook.createSheet("Summary");
		for (int i = 0; i <= cases.size(); i++) {
			if (i == 0) {
				Row row = summary.createRow(i);
				Cell noofcase = row.createCell(0);
				noofcase.setCellValue("TestCase No.");
				Cell test = row.createCell(1);
				test.setCellValue("Test Case");
				Cell result = row.createCell(2);
				result.setCellValue("PASS or FAIL");

			} else {
				try {
					Row row = summary.createRow(i);
					Cell number = row.createCell(0);
					number.setCellValue(i);
					Cell cell = row.createCell(1);
					cell.setCellValue(cases.get(i - 1));
					Cell pf = row.createCell(2);
					pf.setCellValue(caseresult.get(i - 1));
				} catch (NullPointerException e) {
				}
			}
		}

		finput.close();
		FileOutputStream fileOutput = new FileOutputStream(src);
		workbook.write(fileOutput);
		fileOutput.close();
		System.out.println("Done");
	}

}
