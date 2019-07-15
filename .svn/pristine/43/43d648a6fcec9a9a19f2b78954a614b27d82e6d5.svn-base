package com.jspl.lms.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jspl.lms.dao.LeadDao;
import com.jspl.lms.model.LeadMaterialMap;
import com.jspl.lms.model.Material;
import com.jspl.lms.service.BulkUploadServiceLead;
import com.jspl.lms.util.DateUtility;



@Service
public class BulkUploadServiceLeadImpl implements BulkUploadServiceLead {
	@Autowired
	private LeadDao leadDao;
	@Transactional
	public void uploadBulk(MultipartFile filePath, StringBuilder message) {
		List sheetData = new ArrayList();
		try {
			Workbook workbook = null;
			if (filePath.getOriginalFilename().toLowerCase().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(filePath.getInputStream());
			} else if (filePath.getOriginalFilename().toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(filePath.getInputStream());
			}
			// Get the first sheet on the workbook.
			Sheet sheet = workbook.getSheetAt(0);
			// store the data read on an ArrayList
			int maxNumOfCells = sheet.getRow(0).getLastCellNum();
			Iterator<Row> rows = sheet.rowIterator();
			Integer i=0;
			while (rows.hasNext()) {
				i++;
				Row row = rows.next();
				Iterator cells = row.cellIterator();
				List data = new ArrayList();
				for (int cellCounter = 0; cellCounter < maxNumOfCells; cellCounter++) {
					Cell cell;
					if (row.getCell(cellCounter) == null) {
						cell = row.createCell(cellCounter);
					} else {
						cell = row.getCell(cellCounter);
					}
					data.add(cell);
				}
				sheetData.add(data);
			}
			System.out.println("no of rows---"+i);
			showStatusExcelData(sheetData,message);
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void showStatusExcelData(List sheetData, StringBuilder message) {
		//System.out.println("started");
		for (int i = 1; i < sheetData.size(); i++) {
			List oneRowRecord = new ArrayList();
			List list = (List) sheetData.get(i);
			for (int j = 0; j < list.size(); j++) {
				Cell cell = (Cell) list.get(j);
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					if (DateUtil.isCellDateFormatted(cell)) {
						DataFormatter df = new DataFormatter();
						String cellString = df.formatCellValue(cell);
						oneRowRecord.add(cellString);
						/*oneRowRecord.add(DateUtility.dateToStringByFormat(cell.getDateCellValue(), "dd/mm/yyyy"));*/
					} else {
						String str = NumberToTextConverter.toText(cell.getNumericCellValue());
						oneRowRecord.add(str);
					}
				} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					oneRowRecord.add(cell.getRichStringCellValue());
				} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
					oneRowRecord.add(null);
				}
			}
			if(i%500==0)
			{
				System.out.println("Record compleated == *500");
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
				}
			}
			try{
				processStatusExcelData(oneRowRecord,message);
			}catch(Exception ex){
				ex.printStackTrace();

				//i--;
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
				}
				//ex.printStackTrace();
			}
		}
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public void processStatusExcelData(List oneRowRecord, StringBuilder message){
		try{
			String date = oneRowRecord.get(0) != null ? oneRowRecord.get(0).toString().trim() : "";
			//System.out.println("date------"+date);
			Date createdDate=new SimpleDateFormat("dd/MM/yyyy").parse(date);
			//System.out.println("parse date------"+createdDate);
			String sbu = oneRowRecord.get(1) != null ? oneRowRecord.get(1).toString().trim() : "";
			String leadSource = oneRowRecord.get(2) != null ? oneRowRecord.get(2).toString().trim() : "";
			String leadType= oneRowRecord.get(3) != null ? oneRowRecord.get(3).toString().trim() : "";
			String customerName= oneRowRecord.get(4) != null ? oneRowRecord.get(4).toString().trim() : "";
			String contactNumber = oneRowRecord.get(5) != null ? oneRowRecord.get(5).toString().trim() : "";
			Integer contact =new Double(contactNumber).intValue();
			List<LeadMaterialMap> leadMaterialMapList=new ArrayList<LeadMaterialMap>();
			String email = oneRowRecord.get(6) != null ? oneRowRecord.get(6).toString().trim() : ""; 
			String street = oneRowRecord.get(7) != null ? oneRowRecord.get(7).toString().trim() : ""; 
			String city = oneRowRecord.get(8) != null ? oneRowRecord.get(8).toString().trim() : "";
			String state = oneRowRecord.get(9) != null ? oneRowRecord.get(9).toString().trim() : ""; 
			String country = oneRowRecord.get(10) != null ? oneRowRecord.get(10).toString().trim() : ""; 
			String region = oneRowRecord.get(11) != null ? oneRowRecord.get(11).toString().trim() : "";
			String quantity1 = oneRowRecord.get(12) != null ? oneRowRecord.get(12).toString().trim() : "";
			String quantity2 = oneRowRecord.get(13) != null ? oneRowRecord.get(13).toString().trim() : "";
			String quantity3 = oneRowRecord.get(14) != null ? oneRowRecord.get(14).toString().trim() : "";
			String quantity4 = oneRowRecord.get(15) != null ? oneRowRecord.get(15).toString().trim() : "";
			String quantity5 = oneRowRecord.get(16) != null ? oneRowRecord.get(16).toString().trim() : "";
			String quantity6 = oneRowRecord.get(17) != null ? oneRowRecord.get(17).toString().trim() : "";
			String quantity7 = oneRowRecord.get(18) != null ? oneRowRecord.get(18).toString().trim() : "";
			String quantity8 = oneRowRecord.get(19) != null ? oneRowRecord.get(19).toString().trim() : "";

			if(quantity1.isEmpty()){
				BigDecimal totalQuantity1=BigDecimal.ZERO;
				Material material1=new Material();
				material1.setMaterialPkId(19);
				LeadMaterialMap leadMaterialMap1=new LeadMaterialMap();
				leadMaterialMap1.setMaterialFkId(material1);
				leadMaterialMap1.setQuantity(totalQuantity1);
				leadMaterialMapList.add(leadMaterialMap1);			
			}
			else{
				BigDecimal totalQuantity1=new BigDecimal(quantity1);
				Material material1=new Material();
				material1.setMaterialPkId(19);
				LeadMaterialMap leadMaterialMap1=new LeadMaterialMap();
				leadMaterialMap1.setMaterialFkId(material1);
				leadMaterialMap1.setQuantity(totalQuantity1);
				leadMaterialMapList.add(leadMaterialMap1);			
			}
			
			if(quantity2.isEmpty()){
				BigDecimal totalQuantity2=BigDecimal.ZERO;
				Material material2=new Material();
				material2.setMaterialPkId(21);
				LeadMaterialMap leadMaterialMap1=new LeadMaterialMap();
				leadMaterialMap1.setMaterialFkId(material2);
				leadMaterialMap1.setQuantity(totalQuantity2);
				leadMaterialMapList.add(leadMaterialMap1);			
			}
			else{
				BigDecimal totalQuantity2=new BigDecimal(quantity2);
				Material material2=new Material();
				material2.setMaterialPkId(21);
				LeadMaterialMap leadMaterialMap1=new LeadMaterialMap();
				leadMaterialMap1.setMaterialFkId(material2);
				leadMaterialMap1.setQuantity(totalQuantity2);
				leadMaterialMapList.add(leadMaterialMap1);			
			}
			
			if(quantity3.isEmpty()){
				BigDecimal totalQuantity3=BigDecimal.ZERO;
				Material material3=new Material();
				material3.setMaterialPkId(23);
				LeadMaterialMap leadMaterialMap3=new LeadMaterialMap();
				leadMaterialMap3.setMaterialFkId(material3);
				leadMaterialMap3.setQuantity(totalQuantity3);
				leadMaterialMapList.add(leadMaterialMap3);			
			}
			else{
				BigDecimal totalQuantity3=new BigDecimal(quantity3);
				Material material3=new Material();
				material3.setMaterialPkId(23);
				LeadMaterialMap leadMaterialMap3=new LeadMaterialMap();
				leadMaterialMap3.setMaterialFkId(material3);
				leadMaterialMap3.setQuantity(totalQuantity3);
				leadMaterialMapList.add(leadMaterialMap3);			
			}
			
			if(quantity4.isEmpty()){
				BigDecimal totalQuantity4=BigDecimal.ZERO;
				Material material4=new Material();
				material4.setMaterialPkId(25);
				LeadMaterialMap leadMaterialMap4=new LeadMaterialMap();
				leadMaterialMap4.setMaterialFkId(material4);
				leadMaterialMap4.setQuantity(totalQuantity4);
				leadMaterialMapList.add(leadMaterialMap4);			
			}
			else{
				BigDecimal totalQuantity4=new BigDecimal(quantity4);
				Material material4=new Material();
				material4.setMaterialPkId(25);
				LeadMaterialMap leadMaterialMap4=new LeadMaterialMap();
				leadMaterialMap4.setMaterialFkId(material4);
				leadMaterialMap4.setQuantity(totalQuantity4);
				leadMaterialMapList.add(leadMaterialMap4);			
			}
			if(quantity5.isEmpty()){
				BigDecimal totalQuantity5=BigDecimal.ZERO;
				Material material5=new Material();
				material5.setMaterialPkId(27);
				LeadMaterialMap leadMaterialMap5=new LeadMaterialMap();
				leadMaterialMap5.setMaterialFkId(material5);
				leadMaterialMap5.setQuantity(totalQuantity5);
				leadMaterialMapList.add(leadMaterialMap5);			
			}
			else{
				BigDecimal totalQuantity5=new BigDecimal(quantity5);
				Material material5=new Material();
				material5.setMaterialPkId(27);
				LeadMaterialMap leadMaterialMap5=new LeadMaterialMap();
				leadMaterialMap5.setMaterialFkId(material5);
				leadMaterialMap5.setQuantity(totalQuantity5);
				leadMaterialMapList.add(leadMaterialMap5);			
			}
			if(quantity6.isEmpty()){
				BigDecimal totalQuantity6=BigDecimal.ZERO;
				Material material6=new Material();
				material6.setMaterialPkId(29);
				LeadMaterialMap leadMaterialMap6=new LeadMaterialMap();
				leadMaterialMap6.setMaterialFkId(material6);
				leadMaterialMap6.setQuantity(totalQuantity6);
				leadMaterialMapList.add(leadMaterialMap6);			
			}
			else{
				BigDecimal totalQuantity5=new BigDecimal(quantity6);
				Material material6=new Material();
				material6.setMaterialPkId(29);
				LeadMaterialMap leadMaterialMap6=new LeadMaterialMap();
				leadMaterialMap6.setMaterialFkId(material6);
				leadMaterialMap6.setQuantity(totalQuantity5);
				leadMaterialMapList.add(leadMaterialMap6);			
			}
			if(quantity7.isEmpty()){
				BigDecimal totalQuantity7=BigDecimal.ZERO;
				Material material7=new Material();
				material7.setMaterialPkId(31);
				LeadMaterialMap leadMaterialMap7=new LeadMaterialMap();
				leadMaterialMap7.setMaterialFkId(material7);
				leadMaterialMap7.setQuantity(totalQuantity7);
				leadMaterialMapList.add(leadMaterialMap7);			
			}
			else{
				BigDecimal totalQuantity7=new BigDecimal(quantity7);
				Material material6=new Material();
				material6.setMaterialPkId(31);
				LeadMaterialMap leadMaterialMap7=new LeadMaterialMap();
				leadMaterialMap7.setMaterialFkId(material6);
				leadMaterialMap7.setQuantity(totalQuantity7);
				leadMaterialMapList.add(leadMaterialMap7);			
			}
			if(quantity8.isEmpty()){
				BigDecimal totalQuantity8=BigDecimal.ZERO;
				Material material8=new Material();
				material8.setMaterialPkId(33);
				LeadMaterialMap leadMaterialMap8=new LeadMaterialMap();
				leadMaterialMap8.setMaterialFkId(material8);
				leadMaterialMap8.setQuantity(totalQuantity8);
				leadMaterialMapList.add(leadMaterialMap8);			
			}
			else{
				BigDecimal totalQuantity8=new BigDecimal(quantity8);
				Material material6=new Material();
				material6.setMaterialPkId(33);
				LeadMaterialMap leadMaterialMap8=new LeadMaterialMap();
				leadMaterialMap8.setMaterialFkId(material6);
				leadMaterialMap8.setQuantity(totalQuantity8);
				leadMaterialMapList.add(leadMaterialMap8);			
			}
			
			/*	Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
	    System.out.println(sDate1+"\t"+date1);  
		System.out.println("date1111"+date);*/
			//System.out.println("customer name------"+customerName);
		
	    leadDao.saveBulkUploadLead(createdDate,customerName,leadSource,leadType,sbu,email,region,street,city,state,country,contactNumber,leadMaterialMapList);
		}
		catch(Exception e){
			e.printStackTrace();
		}


	}
}



