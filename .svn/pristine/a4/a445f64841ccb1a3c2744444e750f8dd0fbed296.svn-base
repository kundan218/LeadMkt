package com.jspl.lms.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class TableColumnNameUtility {
	static List<String> mySalesViewHeader = null;
	static List<String> purchaseOrderHeader = null;
	static List<String> goodsReceiptReportHeader = null;
	static List<String> totalDespatchFromJSPLHeader = null;
	static List<String> distributorStockListHeader = null;
	static List<String> dealerListHeader = null;
	static List<String> misDetailListHeader = null;
	static List<String> distributorStatementHeader = null;
	static List<String> misListHeader = null;
	static List<String> misNormListHeader = null;

	
	 public static String[] getMySalesViewHeader() {
		 //setAnnualHealthCheckUpHeader(categories);
		 setMySalesViewHeader();
	        String keys[] = new String[mySalesViewHeader.size()];
	        int i = 0;
	        for (Iterator<String> it = mySalesViewHeader.iterator(); it.hasNext(); i++) {
	            keys[i] = it.next();
	        }
	        return keys;
	    }
	 
	 public static String[] getPurchaseOrderHeaders() {
		 	setPurchaseOrderHeaders();
	        String keys[] = new String[purchaseOrderHeader.size()];
	        int i = 0;
	        for (Iterator<String> it = purchaseOrderHeader.iterator(); it.hasNext(); i++) {
	            keys[i] = it.next();
	        }
	        return keys;
	    }
	 
	  public static String[] getGoodsReceiptReportHeader() {
		 setGoodsReceiptReportHeader();
	        String keys[] = new String[goodsReceiptReportHeader.size()];
	        int i = 0;
	        for (Iterator<String> it = goodsReceiptReportHeader.iterator(); it.hasNext(); i++) {
	            keys[i] = it.next();
	        }
	        return keys;
	    }
	  
	  public static String[] getTotalDespatchFromJSPLHeader() {
			 setTotalDespatchFromJSPLHeader();
		        String keys[] = new String[totalDespatchFromJSPLHeader.size()];
		        int i = 0;
		        for (Iterator<String> it = totalDespatchFromJSPLHeader.iterator(); it.hasNext(); i++) {
		            keys[i] = it.next();
		        }
		        return keys;
		    }
	  
	  public static String[] getDistributorStockListHeader() {
		  	setDistributorStockListHeader();
		        String keys[] = new String[distributorStockListHeader.size()];
		        int i = 0;
		        for (Iterator<String> it = distributorStockListHeader.iterator(); it.hasNext(); i++) {
		            keys[i] = it.next();
		        }
		        return keys;
		    }
	  
	  public static String[] getDealerListHeader() {
		  	setDealerListHeader();
		        String keys[] = new String[dealerListHeader.size()];
		        int i = 0;
		        for (Iterator<String> it = dealerListHeader.iterator(); it.hasNext(); i++) {
		            keys[i] = it.next();
		        }
		        return keys;
		    }
	  
	  public static String[] getMisListHeader() {
		  	setMisListHeader();
		        String keys[] = new String[misListHeader.size()];
		        int i = 0;
		        for (Iterator<String> it = misListHeader.iterator(); it.hasNext(); i++) {
		            keys[i] = it.next();
		        }
		        return keys;
		    }
	  
	  public static String[] getMisDetailListHeader() {
		  	setMisDetailListHeader();
		        String keys[] = new String[misDetailListHeader.size()];
		        int i = 0;
		        for (Iterator<String> it = misDetailListHeader.iterator(); it.hasNext(); i++) {
		            keys[i] = it.next();
		        }
		        return keys;
		    }
	  public static String[] getMisNormDetailListHeader() {
		  	setMisNormsDetailListHeader();
		        String keys[] = new String[misNormListHeader.size()];
		        int i = 0;
		        for (Iterator<String> it = misNormListHeader.iterator(); it.hasNext(); i++) {
		            keys[i] = it.next();
		        }
		        return keys;
		    }
	  
	  public static String[] getPoInVoiceDetailListHeader() {
		  setPoInvoiceDetailListHeader();
		        String keys[] = new String[misNormListHeader.size()];
		        int i = 0;
		        for (Iterator<String> it = misNormListHeader.iterator(); it.hasNext(); i++) {
		            keys[i] = it.next();
		        }
		        return keys;
		    }
	  
	  private static void setMisListHeader() {
		misListHeader=new ArrayList<String>();
		misListHeader.add("Distributor Name");
		misListHeader.add("Distributor City");
		misListHeader.add("Distributor Code in SAP");
		misListHeader.add("Opening Stock");
		misListHeader.add("Requisition Qty.");
		misListHeader.add("Receive Qty.");
		misListHeader.add("Total Value of Received Qty.");
		misListHeader.add("Avg. Price of Receive Qty.");
		misListHeader.add("Total Sales Qty.");
		misListHeader.add("Gross Value of Sales");
		misListHeader.add("Gross Value of Sales Tax Amt.");
		misListHeader.add("Gross Value of Sales Freight Amt.");
		misListHeader.add("Total Sales Value");
		misListHeader.add("Avg. Price of Sales Qty.");
		misListHeader.add("Closing Stock");
	}
	  
	  private static void setMisDetailListHeader() {
		  misDetailListHeader=new ArrayList<String>();
		  misDetailListHeader.add("Distributor Name");
		  misDetailListHeader.add("Distributor Code in SAP");
		  misDetailListHeader.add("MATERIAL CODE");
		  misDetailListHeader.add("Opening Stock");
		  misDetailListHeader.add("Closing Stock");
			
		}

	private static void setDealerListHeader() {
		  dealerListHeader = new ArrayList<String>();
		  dealerListHeader.add("DEALER CODE");
		  dealerListHeader.add("DEALER NAME");
		  dealerListHeader.add("MOBILE");
		  dealerListHeader.add("EMAIL ID");
		  dealerListHeader.add("ADDRESS");
		  dealerListHeader.add("POSTAL CODE");
		  dealerListHeader.add("CST NO.");
		  dealerListHeader.add("GST NO.");
		  dealerListHeader.add("TIN NO.");
		  dealerListHeader.add("CITY");
		  dealerListHeader.add("DISTRICT");
		  dealerListHeader.add("STATE");
	}

	private static void setDistributorStockListHeader() {
		  distributorStockListHeader = new ArrayList<String>();
		  distributorStockListHeader.add("Distributor Name");
		  distributorStockListHeader.add("MATERIAL CODE");
		  distributorStockListHeader.add("MATERIAL DESC.");
		  distributorStockListHeader.add("QUANTITY");
	 }

	  
	  private static void setTotalDespatchFromJSPLHeader() {
		  totalDespatchFromJSPLHeader = new ArrayList<String>();
		  totalDespatchFromJSPLHeader.add("Distributor Code");
		  totalDespatchFromJSPLHeader.add("Distributor Name");
		  totalDespatchFromJSPLHeader.add("BILL DOC.");
		  totalDespatchFromJSPLHeader.add("SO NO.");
		  totalDespatchFromJSPLHeader.add("POSTING DATE");
		  totalDespatchFromJSPLHeader.add("PO NO");
		  totalDespatchFromJSPLHeader.add("DELV. NO.");
		  totalDespatchFromJSPLHeader.add("MATERIAL CODE");
		  totalDespatchFromJSPLHeader.add("MATERIAL DESCRIPTION");
		  totalDespatchFromJSPLHeader.add("ACTUAL QT.");
		  totalDespatchFromJSPLHeader.add("VEHICLE NO.");
		  totalDespatchFromJSPLHeader.add("PURCH. DOC.");
		  totalDespatchFromJSPLHeader.add("SALES TYPE");
	}

	private static void setGoodsReceiptReportHeader(){
		  goodsReceiptReportHeader = new ArrayList<String>();
		  goodsReceiptReportHeader.add("Distributor Code");
		  goodsReceiptReportHeader.add("Distributor Name");
		  goodsReceiptReportHeader.add("BILL DOC.");
		  goodsReceiptReportHeader.add("SO NO.");
		  goodsReceiptReportHeader.add("POSTING DATE");
		  goodsReceiptReportHeader.add("PO NO");
		  goodsReceiptReportHeader.add("DELV. NO.");
		  goodsReceiptReportHeader.add("MATERIAL CODE");
		  goodsReceiptReportHeader.add("MATERIAL DESCRIPTION");
		  goodsReceiptReportHeader.add("RECEIVE QT.");
		  goodsReceiptReportHeader.add("ACTUAL QT.");
		  goodsReceiptReportHeader.add("VEHICLE NO.");
		  goodsReceiptReportHeader.add("YEAR");
		  goodsReceiptReportHeader.add("PURCH. DOC.");
		  goodsReceiptReportHeader.add("NET. VALUE");
		  goodsReceiptReportHeader.add("TAX AMT.");
	  }
	  
	  
		private static void setPurchaseOrderHeaders(){
			purchaseOrderHeader = new ArrayList<String>();
			purchaseOrderHeader.add("Requisition No.");
			purchaseOrderHeader.add("Date");
			purchaseOrderHeader.add("Distributor Name");
			purchaseOrderHeader.add("Material");
			purchaseOrderHeader.add("Quantity");
	 }
		
		private static void setMySalesViewHeader(){
			mySalesViewHeader = new ArrayList<String>();
			mySalesViewHeader.add("Distributor Name");
			mySalesViewHeader.add("Invoice No");
			mySalesViewHeader.add("Dealer Code");
			mySalesViewHeader.add("Dealer Name");
			mySalesViewHeader.add("Dealer City");
			mySalesViewHeader.add("Created Date");
			mySalesViewHeader.add("Invoice Date");
			mySalesViewHeader.add("Material");
			mySalesViewHeader.add("Quantity");
		
	 }
	 
		  public static String[] getDistributorStatementListHeader() {
			  setDistributorStatementListHeader();
			        String keys[] = new String[distributorStatementHeader.size()];
			        int i = 0;
			        for (Iterator<String> it = distributorStatementHeader.iterator(); it.hasNext(); i++) {
			            keys[i] = it.next();
			        }
			        return keys;
			    }
		 
		  private static void setDistributorStatementListHeader() {
			distributorStatementHeader=new ArrayList<String>();
			distributorStatementHeader.add("Posting Date");
			distributorStatementHeader.add("Document No");
			distributorStatementHeader.add("Doc. Type");
			distributorStatementHeader.add("Description");
			distributorStatementHeader.add("Debit Amt.");
			distributorStatementHeader.add("Credit Amt.");
			distributorStatementHeader.add("Closing Balance");
			distributorStatementHeader.add("Type");
			
		}
		  
		  private static void setMisNormsDetailListHeader() {
			  misNormListHeader = new ArrayList<String>();
			  misNormListHeader.add("Distributor Name");
			  misNormListHeader.add("MATERIAL CODE");
			  misNormListHeader.add("Distributor Stock");
			  misNormListHeader.add("Norms Stock");
			  misNormListHeader.add("Norms Status");
		 }
		  
		  
		  private static void setPoInvoiceDetailListHeader() {
			  misNormListHeader = new ArrayList<String>();
			  misNormListHeader.add("Distributor Name");
			  misNormListHeader.add("Customer Po");
			  misNormListHeader.add("Sales Invoice");
		 }
}
