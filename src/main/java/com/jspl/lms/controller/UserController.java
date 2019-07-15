package com.jspl.lms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jspl.lms.model.Location;
import com.jspl.lms.service.UserService;



@Controller
public class UserController {

	@Autowired
	private UserService userService;
	


	/**
	 * @author Sumit
	 */
	@RequestMapping(value = "/admin/user")
	public String getUserList(ModelMap map) {
		map.put("userList", userService.getUserList());
		map.put("locationList", userService.getLocationList());
		map.put("roleList", userService.getRoleList());
		
		map.put("regionList", userService.getRegionList());

		return "manageUser";

	}
	
	
	@RequestMapping(value = "/saveUser.html", method = RequestMethod.POST)
	public String saveUser(@RequestParam(value = "locationList") List<Integer> locationList,
			@RequestParam(value = "userRoleId") Integer userRoleId,
			@RequestParam(value = "userFkId") Integer userFkId,
			@RequestParam(value = "userRegionId") Integer userRegionId,
			@RequestParam(value = "username") String userName,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "contactNumber") String contactNumber,
			@RequestParam(value = "email") String validEmail,
			@RequestParam(value = "name") String name,
	        @RequestParam(value = "sapId") String sapId,
	        @RequestParam(value = "distributorDmsId") String distributorDmsId,
	        @RequestParam(value = "status") Integer status,
	        @RequestParam(value = "registeredDate")@DateTimeFormat(pattern="yyyy-MM-dd") Date registeredDate)
			throws Exception {
		try {
			userService.saveUserLocationMap(locationList, userRoleId, userFkId, userName,
					password, userRegionId, validEmail,name,contactNumber,
					sapId,status,registeredDate,distributorDmsId);
			//userService.deleteNullUser("user_location_map");
			//userService.deleteNullUser("user_role");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/user";
	}
	
	
	@RequestMapping(value="/admin/getLocationList",method=RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Location> getLocationListByRegionId(@RequestParam("userRegionId") Integer userRegionId,HttpServletRequest request){
		
		List<Location> list= userService.getLocationListByRegionId(userRegionId);
		
		return list;
		
		
		 
		 
		
		
		
	}
}