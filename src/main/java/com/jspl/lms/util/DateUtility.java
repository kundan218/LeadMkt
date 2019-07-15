package com.jspl.lms.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DateUtility {

    public static String dateToString(Date date) {
        if (date != null) {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String sdate = formatter.format(date);
            return sdate;
        } else {
            return null;
        }
    }
    
    public static String dateToString2(Date date) {
        if (date != null) {
            DateFormat formatter = new SimpleDateFormat("dd MMMM, yyyy");
            String sdate = formatter.format(date);
            return sdate;
        } else {
            return null;
        }
    }
    public static String dateToStringWithTime(Date date) {
        if (date != null) {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String sdate = formatter.format(date);
            return sdate;
        } else {
            return null;
        }
    }
    
    public static String dateToString1(Date date) {
        if (date != null) {
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String sdate = formatter.format(date);
            return sdate;
        } else {
            return null;
        }
    }

    public static String dateToStringInDDMMMYYYY(Date date) {
        DateFormat formatter = new SimpleDateFormat("ddMMMyyyy");
        String sdate = formatter.format(date);
        return sdate;
    }

    public static java.sql.Date dateToSQLDate(java.util.Date date) {
        if (date == null) {
            return null;
        } else {
            return new java.sql.Date(date.getTime());
        }

    }

    @SuppressWarnings("deprecation")
	public static java.sql.Date dateToSQLDateForEnquiry(java.util.Date date) {
        if (date == null) {
            return null;
        } else {
            Date curDate = new Date();
            if (date.getHours() == 0) {
                date.setHours(curDate.getHours());
            }
            if (date.getMinutes() == 0) {
                date.setMinutes(curDate.getMinutes());
            }
            if (date.getSeconds() == 0) {
                date.setSeconds(curDate.getSeconds());
            }
            return new java.sql.Date(date.getTime());
        }

    }

    public static Date stringToDate(String date) {
        if (date == null || date.trim().equals("")) {
            return null;
        }
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date convertDate = null;
        try {
            convertDate = (Date) formatter.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return convertDate;
    }
    
    public static Date stringToDate1(String date) {
        if (date == null || date.trim().equals("")) {
            return null;
        }
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date convertDate = null;
        try {
            convertDate = (Date) formatter.parse(date);
        } catch (ParseException ex) {
           // ex.printStackTrace();
        }
        return convertDate;
    }

    public static Date databaseStringToDate(String date) {
        if (date == null || date.trim().equals("")) {
            return null;
        }
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date convertDate = null;
        try {
            convertDate = (Date) formatter.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return convertDate;
    }

    public static String stringToDateInDataBase(String date) {
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String sdate = formatter.format(stringToDate(date));
        return sdate;
    }

    public static String dateToStringInDataBase(Date date) {
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String sdate = formatter.format(date);
        return sdate;
    }

    public static Object[] timeToString(Date time) {
        if (time != null) {
            DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            String ctime = dateFormat.format(time);
            return new Object[]{ctime.substring(0, 2), ctime.substring(3, 5), ctime.substring(6)};
        } else {
            return new Object[]{null, null, null};
        }
    }

    public static Date stringToTime(String time) {
        DateFormat formatter = new SimpleDateFormat("hh:mm a");
        Date convertDate = null;
        try {
            convertDate = (Date) formatter.parse(time);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return convertDate;
    }

    public static String timeToStringHHMMSS(Date time) {
        if (time != null) {
            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
            String ctime = dateFormat.format(time);
            return ctime;
        } else {
            return "";
        }
    }

    public static String timeToStringHHMM(Date time) {
        if (time != null) {
            DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            String ctime = dateFormat.format(time);
            return ctime;
        } else {
            return "";
        }
    }

    public static String toDDMMMyyyy(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        String sdate = formatter.format(date);
        return sdate;
    }

    public static Date getOnlyDate(Date date) {
        return DateUtility.stringToDate(DateUtility.dateToString(date));
    }

    public static List<Integer> getYearsList(Date date, int backYear, int nextYear) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        List<Integer> years = new ArrayList<Integer>();
        int startyear = year - backYear;
        int endyear = year + nextYear;
        while (startyear <= endyear) {
            years.add(startyear);
            startyear++;
        }
        Collections.reverse(years);
        return years;
    }

    public static Date GetBackDate(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);
        return cal.getTime();
    }

    public static boolean matchTodayDate(Date birthday) {
        Calendar birthdayDate = Calendar.getInstance();
        birthdayDate.setTime(birthday);
        Calendar todayDate = Calendar.getInstance();
        todayDate.setTime(new Date());
        int newMonth = todayDate.get(Calendar.MONTH);
        int newDay = todayDate.get(Calendar.DAY_OF_MONTH);
        int birthDayMonth = birthdayDate.get(Calendar.MONTH);
        int birthDay = birthdayDate.get(Calendar.DAY_OF_MONTH);

        if (newMonth == birthDayMonth && newDay == birthDay) {
            return true;
        } else {
            return false;
        }
    }

    public static Object[] calculateDuration(Date startDate, Date endDate) {

        if (startDate != null && endDate != null) {
            Calendar startc = Calendar.getInstance();
            Calendar endc = Calendar.getInstance();
            startc.setTime(startDate);
            endc.setTime(endDate);

            int day = Math.abs(endc.get(Calendar.DAY_OF_MONTH) - startc.get(Calendar.DAY_OF_MONTH));
            int month = endc.get(Calendar.MONTH) - startc.get(Calendar.MONTH);
            if (day < 0 && month > 0) {
                month--;
                day = 30 + day;
            }

            int year = endc.get(Calendar.YEAR) - startc.get(Calendar.YEAR);
            if (month < 0 && year > 0) {
                year--;
                month = 12 + month;
            }

            if (year < 0) {
                year = 0;
            }

            if (month < 0) {
                month = 0;
            }

            if (day <= 0) {
                day = 0;
            }

            return new Object[]{year, month, day};
        } else {
            return new Object[]{null, null, null};
        }
    }

    public static String[] getFirstAndLastDate(int month, int year) {
        String[] dates = new String[2];
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        int date = 1;
        int maxDay = 0;
        calendar.set(year, month, date);
        dates[0] = formatter.format(calendar.getTime());
        //Getting Maximum day for Given Month
        maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(year, month, maxDay);
        dates[1] = formatter.format(calendar.getTime());
        return dates;
    }
    public static boolean isBirthday(Date dob){
        if(dob==null){
            return false;
        }else{
            Calendar cur=Calendar.getInstance();
            Calendar cDob=Calendar.getInstance();
            cDob.setTime(dob);
            if(cur.get(Calendar.DATE) == cDob.get(Calendar.DATE) && cur.get(Calendar.MONTH) == cDob.get(Calendar.MONTH))
            {
                return true;
            }else{
                return false;
            }
        }
    }
    
    @SuppressWarnings("unused")
	public static int getDateDifferenceIndays(Date date1,Date date2)
    {

    	if(date1!=null && date2!=null)
    	{
    		Calendar calendar=Calendar.getInstance();
    		calendar.setTime(date1);
    		calendar.set(Calendar.HOUR_OF_DAY, 0);
    		calendar.set(Calendar.MINUTE, 0);
    		calendar.set(Calendar.SECOND, 0);
    		calendar.set(Calendar.MILLISECOND, 0);
    		date1=calendar.getTime();
    		calendar.setTime(date2);
    		calendar.set(Calendar.HOUR_OF_DAY, 0);
    		calendar.set(Calendar.MINUTE, 0);
    		calendar.set(Calendar.SECOND, 0);
    		calendar.set(Calendar.MILLISECOND, 0);
    		date2=calendar.getTime();
    		long diff = date2.getTime() - date1.getTime();
            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000);
            int diffInDays = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
            return diffInDays;
    	}
            return 0;
            
    }
    
    public static String getFInancialYearStart(Date date) {
        if (date != null) {
        	Calendar calendar=Calendar.getInstance();
        	calendar.setTime(date);
        	if(calendar.get(Calendar.MONTH)>=Calendar.MARCH)
        	{
        		calendar.set(Calendar.DATE, 1);
        		calendar.set(Calendar.MONTH, Calendar.APRIL);
        		
        	}else
        	{
        		calendar.set(Calendar.DATE, 1);
        		calendar.set(Calendar.MONTH, Calendar.APRIL);
        		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-1);
        	}
        	
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String sdate = formatter.format(calendar.getTime());
            return sdate;
        } else {
            return null;
        }
    }
    
    public static String getFInancialYearEnd(Date date) {
        if (date != null) {
        	Calendar calendar=Calendar.getInstance();
        	calendar.setTime(date);
        	if(calendar.get(Calendar.MONTH)>=Calendar.MARCH)
        	{
        		calendar.set(Calendar.DATE, 1);
        		calendar.set(Calendar.MONTH, Calendar.APRIL);
        		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)+1);
        		calendar.add(Calendar.DATE, -1);
        	}else
        	{
        		calendar.set(Calendar.DATE, 1);
        		calendar.set(Calendar.MONTH, Calendar.APRIL);
        		calendar.add(Calendar.DATE, -1);
        	}
        	
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String sdate = formatter.format(calendar.getTime());
            return sdate;
        } else {
            return null;
        }
    }
    
    public static Map<String, String> getFInancialYear(Date date,int count) {
    	Map<String, String> financialYear=new LinkedHashMap<String, String>();
        if (date != null) {
        	for(int i=0;i<count;i++)
        	{
        		String fYear="";
        		Calendar calendar=Calendar.getInstance();
            	calendar.setTime(date);
            	calendar.add(Calendar.YEAR, -i);
            	if(calendar.get(Calendar.MONTH)>=Calendar.MARCH)
            	{
            		calendar.set(Calendar.DATE, 1);
            		calendar.set(Calendar.MONTH, Calendar.APRIL);
            		
            	}else
            	{
            		calendar.set(Calendar.DATE, 1);
            		calendar.set(Calendar.MONTH, Calendar.APRIL);
            		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-1);
            	}
            	fYear=calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.YEAR)+1);

            	financialYear.put(fYear, fYear);
        	}
        } 
        return financialYear;
    }
    
    
    public static String getFInancialYearStart(String fYear) {
        if (fYear != null && !fYear.equals("")) {
        	Calendar calendar=Calendar.getInstance();
        	calendar.set(Calendar.DATE, 1);
    		calendar.set(Calendar.MONTH, Calendar.APRIL);
        	calendar.set(Calendar.YEAR, Integer.parseInt(fYear.split("-")[0]));
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String sdate = formatter.format(calendar.getTime());
            return sdate;
        } else {
            return "";
        }
    }
    
    public static String getFInancialYearEnd(String fYear) {
    	 if (fYear != null && !fYear.equals("")) {
         	Calendar calendar=Calendar.getInstance();
         	calendar.set(Calendar.DATE, 1);
    		calendar.set(Calendar.MONTH, Calendar.APRIL);
    		calendar.add(Calendar.DATE, -1);
         	calendar.set(Calendar.YEAR, Integer.parseInt(fYear.split("-")[1]));
             DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
             String sdate = formatter.format(calendar.getTime());
             return sdate;
         } else {
             return "";
         }
    }
    
    public static String dateToStringByFormat(Date date,String format) {
        if (date != null) {
            DateFormat formatter = new SimpleDateFormat(format);
            String sdate = formatter.format(date);
            return sdate;
        } else {
            return null;
        }
    }
    

    public static void main(String[] args) {
    	System.out.println(dateToString(new Date()));
        getFirstAndLastDate(6, 2013);
        //System.out.println("===="+stringToDate1("07.10.2016"));
        //BigDecimal bd = new BigDecimal("1.2056E+14");
        System.out.println("===="+Double.valueOf("5.43602E+13").longValue());
		//long val = bd.longValue();
       // System.out.println("==dd===="+String.valueOf(val)+"==="+val);
        //System.out.println("===="+new BigDecimal("4.32602E+13").toPlainString());
        System.out.println("======="+dateToString2(new Date()));
    }
}
