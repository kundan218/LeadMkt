/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jspl.lms.model;

import java.util.List;

/**
 *
 * @author Rajesh Mishra
 */
public class ExcelExportCommand {

    String fileName;
    String sheetName;
    String[] header;
    String[] subHeader;
    List<Object[]> strings;
    List<List<Object[]>> pendingLocationWise;
    List<Object[]> totalRow;

    public ExcelExportCommand() {
    }

    public ExcelExportCommand(ExcelExportCommand exportCommand) {
        this.fileName = exportCommand.getFileName();
        this.sheetName = exportCommand.getSheetName();
        this.header = exportCommand.getHeader();
        this.strings = exportCommand.getStrings();
        this.subHeader = exportCommand.getSubHeader();
    }

    public String[] getSubHeader() {
		return subHeader;
	}

	public void setSubHeader(String[] subHeader) {
		this.subHeader = subHeader;
	}

	public List<Object[]> getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(List<Object[]> totalRow) {
		this.totalRow = totalRow;
	}

	public ExcelExportCommand(String fileName, String sheetName, String[] header, List<Object[]> strings) {
        this.fileName = fileName;
        this.sheetName = sheetName;
        this.header = header;
        this.strings = strings;
    }
	
	/*public ExcelExportCommand(String fileName, String sheetName, String[] header, String[] subHeader, List<Object[]> strings) {
        this.fileName = fileName;
        this.sheetName = sheetName;
        this.header = header;
        this.subHeader = subHeader;
        this.strings = strings;
    }
    
    

    public ExcelExportCommand(String fileName, String sheetName,
			String[] header, List<Object[]> strings,
			List<List<Object[]>> pendingLocationWise,List<Object[]> totalRow) {
		//super();
		this.fileName = fileName;
		this.sheetName = sheetName;
		this.header = header;
		this.strings = strings;
		this.pendingLocationWise = pendingLocationWise;
		this.totalRow = totalRow;
	}*/

	public List<Object[]> getStrings() {
        return strings;
    }

    public void setStrings(List<Object[]> strings) {
        this.strings = strings;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

	public List<List<Object[]>> getPendingLocationWise() {
		return pendingLocationWise;
	}

	public void setPendingLocationWise(List<List<Object[]>> pendingLocationWise) {
		this.pendingLocationWise = pendingLocationWise;
	}
    
}
