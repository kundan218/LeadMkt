package com.jspl.lms.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jspl.lms.dao.DashBoardDao;
import com.jspl.lms.dao.DistributorDao;
import com.jspl.lms.dto.DashboardDTO;
import com.jspl.lms.dto.ReportParam;
import com.jspl.lms.dto.Sales;
import com.jspl.lms.dto.SalesReport;
import com.jspl.lms.model.DataTableDto;
import com.jspl.lms.model.Distributor;
import com.jspl.lms.model.LeadManageDto;
import com.jspl.lms.model.Region;
import com.jspl.lms.service.DashBoardService;
@Service
public class DashBoardServiceImpl implements DashBoardService{

	@Autowired
	private DashBoardDao dashBoardDao;
	@Autowired
	private DistributorDao distributorDao;
	
	@Override
	@Transactional
	public String getTotalDistributor() {
		// TODO Auto-generated method stub
		return dashBoardDao.getTotalDistributor();
	}

	
	public static void main(String[] args) {
	/*	Date d=new Date(2017-07-05);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("EEEEE");
			//cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-i);
			cal.setTime(d);
			String dayOfWeek = dateFormat1.format(cal.getTime());
			System.out.println(dayOfWeek);
			
			//To Upper cast of a double with round value
			double inf = 4.005;
			double k = (long) Math.ceil(inf);
			System.out.println(k); //o/p=5 
*/			
			String[] arr=new String[7];
			for(int i=0;i<7;i++){
				
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat dateFormat1 = new SimpleDateFormat("EEEEE");
				cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-i);
				String dayOfWeek = dateFormat1.format(cal.getTime());
				Date date =  cal.getTime();
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String dayWithDate=dayOfWeek+"("+df.format(date)+")";
				System.out.println(dayWithDate);
				//System.out.println(date+":"+dayOfWeek);
				arr[i]=dayWithDate;
			}
		
	}


	@Override
	@Transactional
	public Long countLeadManageData(DataTableDto dataTableDto, String roleName, Integer userId) {
	
		return dashBoardDao.countLeadManageData(dataTableDto,roleName,userId);
	}


	@Override
	@Transactional
	public List<LeadManageDto> getLeadManageList(DataTableDto dataTableDto, String roleName, Integer userId) {
		return dashBoardDao.getLeadManageList(dataTableDto,roleName,userId);
	}
	

	@Override
	@Transactional
	public SalesReport getLeadsReport(ReportParam param) {
		SalesReport saleReport=new SalesReport();
		List<String> daylist=new ArrayList<String>();
		
		List<Sales> salesList=new ArrayList<Sales>();
		List<Region> regionList=dashBoardDao.getRegionListByUserId(param);
		String[] regionArr=new String[regionList.size()];
		List<DashboardDTO> dList= dashBoardDao.getSalesReport(param);
		System.out.println("Size:::::;"+dList.size());
		String[] day=getLeadQuantityWeekwise();
		int j=0;
		System.out.println("Location List Size"+regionList);
		for (Region rg : regionList) {//1 
			for(int i=0; i<day.length; i++){//s,m t w t f s
				Sales sale=new Sales();
				for (DashboardDTO dto : dList) {// 1 sun
					
				if(param.getRoleId()!=null && param.getRoleId().equals("ADMIN")){
					if(dto.getRegionPkId()==rg.getRegionPkId() && day[i].equalsIgnoreCase(dto.getDayName())){
						sale.setXaxis(j);
						sale.setYaxis(i);
						System.out.println("Strock Listtttt::Admin:"+dto.getSales());
						sale.setSale(dto.getSales());
						salesList.add(sale);
					}
				}else if(param.getRoleId()!=null && param.getRoleId().equals("REGIONAL_MANAGER")){
					if(dto.getRegionPkId()==rg.getRegionPkId() && day[i].equalsIgnoreCase(dto.getDayName())){
						sale.setXaxis(j);
						sale.setYaxis(i);
						System.out.println("Strock Listtttt::RSM:"+dto.getSales());
						sale.setSale(dto.getSales());
						salesList.add(sale);
					}
				}else if(param.getRoleId()!=null && param.getRoleId().equals("SALES_MARKETING")){
					if(dto.getRegionPkId()==rg.getRegionPkId() && day[i].equalsIgnoreCase(dto.getDayName())){
						sale.setXaxis(j);
						sale.setYaxis(i);
						System.out.println("Strock ListttttSo:::"+dto.getSales());
						sale.setSale(dto.getSales());
						salesList.add(sale);
					}
				}else if(param.getRoleId()!=null && param.getRoleId().equals("STOCKYARD_MANAGER")){
					if(dto.getRegionPkId()==rg.getRegionPkId() && day[i].equalsIgnoreCase(dto.getDayName())){
						sale.setXaxis(j);
						sale.setYaxis(i);
						System.out.println("Strock ListttStock MAAtt:::"+dto.getSales());
						sale.setSale(dto.getSales());
						salesList.add(sale);
					}
				}
					
				}
					if(sale.getSale()==null){
						sale.setXaxis(j);
						sale.setYaxis(i);
						sale.setSale(new BigDecimal(0.0));
						salesList.add(sale);
					}
		}
			if(param.getRoleId()!=null && param.getRoleId().equals("ADMIN")){
			regionArr[j]=rg.getRegionName();
			}else if(param.getRoleId()!=null && param.getRoleId().equals("REGIONAL_MANAGER")){
				regionArr[j]=rg.getRegionName();
			}else if(param.getRoleId()!=null && param.getRoleId().equals("SALES_MARKETING")){
				regionArr[j]=rg.getRegionName();	
			}else if(param.getRoleId()!=null && param.getRoleId().equals("STOCKYARD_MANAGER")){
				regionArr[j]=rg.getRegionName();	
			}
		j++;

		}
		saleReport.setDayArray(getDayWithDate());
		saleReport.setSaleList(salesList);
		saleReport.setRegionArray(regionArr);
		
		return saleReport;
	}

	public String[] getLeadQuantityWeekwise() {
		//ArrayList<String> a=new ArrayList<String>();
		String[] arr=new String[7];
		for(int i=0;i<7;i++){
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("EEEEE");
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-i);
			String dayOfWeek = dateFormat1.format(cal.getTime());
			arr[i]=dayOfWeek;
		}
		return arr;
	}
	
	public String[] getDayWithDate() {
		String[] arr=new String[7];
		for(int i=0;i<7;i++){
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("EEEEE");
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-i);
			String dayOfWeek = dateFormat1.format(cal.getTime());
			Date date =  cal.getTime();
			SimpleDateFormat df = new SimpleDateFormat("dd-MM");
			String dayWithDate=df.format(date);
			System.out.println(dayWithDate);
			//System.out.println(date+":"+dayOfWeek);
			arr[i]=dayWithDate;
		}
		return arr;
	}

	}
