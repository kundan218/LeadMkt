package com.jspl.lms.excel;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.jspl.lms.model.ExcelExportCommand;


public class ExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ExcelExportCommand excelList;

        excelList = new ExcelExportCommand((ExcelExportCommand) model.get("exportCommand"));
		
		Map<String, CellStyle> styles = createStyles(workbook);

        // Create a new worksheet in the workbook and name the worksheet "sheet"
        HSSFSheet sheet = workbook.createSheet(excelList.getSheetName());
        sheet.setAutobreaks(true);
        sheet.setDisplayGridlines(false);
        sheet.setPrintGridlines(false);
        sheet.setFitToPage(true);

        // Set title in excel sheet
        HSSFRow titleRow = sheet.createRow((short) 0);
        titleRow.setHeightInPoints(50);
        HSSFCell titleCell = titleRow.createCell((short) 0);
        // sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$N$1"));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, excelList.getHeader().length));
        titleCell.setCellValue(excelList.getFileName() != null ? excelList.getFileName() : excelList.getSheetName());

        // Set title style
        titleCell.setCellStyle(styles.get("title"));

        // Create header row
        HSSFRow headerRow = sheet.createRow((short) 1);
        headerRow.setHeightInPoints(20);
        HSSFCell srNoCell = headerRow.createCell((short) 0);
        srNoCell.setCellValue("Sr. No.");
        srNoCell.setCellStyle(styles.get("mainHeader"));
        for (int i = 0; i < excelList.getHeader().length; i++) {
        	  HSSFCell headercell = headerRow.createCell((short) (i + 1));
        	  headercell.setCellValue(excelList.getHeader()[i]);
        	  headercell.setCellStyle(styles.get("mainHeader"));
        }
        
       

        int j = 2;
       for (Object[] strings1 : excelList.getStrings()) {
            HSSFRow dataRow = sheet.createRow((short) j);
            dataRow.setHeightInPoints(16);
            HSSFCell srNoRow = dataRow.createCell((short) 0);
            srNoRow.setCellStyle(styles.get("srNoRow" + (j % 2 + 1)));
            srNoRow.setCellValue(j - 1);
            for (int i = 0; i < strings1.length; i++) {
                HSSFCell cell = dataRow.createCell((short) (i + 1));
                if (strings1[i] != null && !strings1[i].equals("")) {
                    if (strings1[i].getClass().getName().equals("java.lang.Integer")) {
                        cell.setCellValue(new Integer((Integer) strings1[i]));
                    } else if (strings1[i].getClass().getName().equals("java.lang.Double")) {
                        cell.setCellValue(new Double((Double) strings1[i]));
                    } else if (strings1[i].getClass().getName().equals("java.lang.Long")) {
                        cell.setCellValue(new Long((Long) strings1[i]));
                    } else {
                        String value = strings1[i].toString();
                        if (checkNumber(value) == true) {
                            cell.setCellValue(Long.valueOf(value));
                        } else {
                            cell.setCellValue(value);
                        }
                    }
                } else {
                    cell.setCellValue("");
                }
                cell.setCellStyle(styles.get("row" + (j % 2 + 1)));
            }
            j++;
        }

        // Set footer in excel sheet
      /*  HSSFRow footerRow = sheet.createRow((short) j);
        footerRow.setHeightInPoints(30);
        HSSFCell footerCell = footerRow.createCell((short) 0);
        // sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$N$1"));
        sheet.addMergedRegion(new CellRangeAddress(j, j, 0, excelList.getHeader().length));
        footerCell.setCellValue("Note : Total " + excelList.getStrings().size() + " records available in this file & exported on " + new java.util.Date());

        // Set title style
        footerCell.setCellStyle(styles.get("footer"));*/

//        sheet.autoSizeColumn(5);
        for (int i = 0; i <= excelList.getHeader().length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Put some content in the cell
      //  response.setContentType("application/vnd.ms-excel");

     //   response.setHeader("Content-Disposition", "attachment; filename=" + excelList.getFileName() + ".xls");
//FileOutputStream stream;

        try {
         /*   OutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();*/

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        short borderColor = IndexedColors.GREY_50_PERCENT.getIndex();
        CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 30);
        titleFont.setColor(IndexedColors.DARK_BLUE.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        styles.put("title", style);

        Font headerFont = wb.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(borderColor);
        style.setFont(headerFont);
        styles.put("header", style);
        
        Font mainHeaderFont = wb.createFont();
        mainHeaderFont.setFontHeightInPoints((short) 12);
        mainHeaderFont.setColor(IndexedColors.WHITE.getIndex());
        mainHeaderFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(borderColor);
        style.setFont(headerFont);
        styles.put("mainHeader", style);

        Font footerFont = wb.createFont();
        footerFont.setFontHeightInPoints((short) 9);
        footerFont.setColor(IndexedColors.GREY_50_PERCENT.getIndex());
        footerFont.setItalic(true);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(footerFont);
        styles.put("footer", style);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(borderColor);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(borderColor);
        styles.put("row1", style);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(borderColor);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(borderColor);
        styles.put("srNoRow1", style);

        style = wb.createCellStyle();
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(borderColor);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(borderColor);
        styles.put("row2", style);

        style = wb.createCellStyle();
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setRightBorderColor(borderColor);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(borderColor);
        styles.put("srNoRow2", style);

        return styles;
    }

    public boolean checkNumber(String value) {
        if (!value.equals("")) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            //If we find a non-digit character we return false.
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }

        return true;
    }
		
	}

