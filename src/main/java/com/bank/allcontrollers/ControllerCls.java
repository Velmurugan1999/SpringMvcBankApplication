package com.bank.allcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.pojo.User;
import com.bank.servicepkg.AdminServices;
import com.bank.servicepkg.UserServices;
import com.google.gson.Gson;

@RestController
public class ControllerCls {
	@Autowired
	AdminServices aservices;
	@Autowired
	UserServices uservices;
//-----------------------ADMIN-----------------------------------	
	@GetMapping(path="/admin/allbank",produces="application/json")
	public String getallbank() {
		System.out.println("All Bank called");
		return new Gson().toJson(aservices.allBank());
	}
	
	@GetMapping(path="/admin/alluser",produces="application/json")
	public String getalluser() {
		return new Gson().toJson(aservices.allUser());
	}
	
	@PostMapping(path="admin/bankbyid/{bid}", produces="application/json")
	public String getBankById(@PathVariable int bid)
	{
		
		return new Gson().toJson(aservices.getBankById(bid));
	}
	@PostMapping(path="admin/userbyaccno/{accno}", produces="application/json")
	public String getUserByAccno(@PathVariable int accno)
	{
		
		return new Gson().toJson(aservices.getUserById(accno));
	}
	@PostMapping(path="admin/alluserbybank/{bid}", produces="application/json")
	public String getAlluserbybank(@PathVariable int bid)
	{
		return new Gson().toJson(aservices.getUserListByBankId(bid));
	}
	@PutMapping(path="admin/updateuserlocation/{accno}/{location}", produces="application/json")
	public String updateUserLocation(@PathVariable int accno,@PathVariable String location)
	{
		return new Gson().toJson(aservices.updateuserLocation(accno,location));
	}
	
	@PutMapping(path="admin/updatebalance/{accno}/{balance}", produces="application/json")
	public String updatebalance(@PathVariable int accno,@PathVariable double balance)
	{
		return new Gson().toJson(aservices.updateUserBalance(accno,balance));
	}
	@PostMapping(path="admin/insertuser",consumes="application/json", produces="application/json")
	public String insertUser(@RequestBody User user)
	{
		return new Gson().toJson(aservices.insertUser(user));
	}
	//-----------------------------USER----------------------------------------
	@GetMapping(path="/user/details/{accno}",produces="application/json")
	public String getUserbyId(@PathVariable int accno) {
		return new Gson().toJson(uservices.getUserByAccno(accno));
	}
	@PutMapping(path="user/updateuserlocation/{accno}/{location}", produces="application/json")
	public String updateUserLocationByUser(@PathVariable int accno,@PathVariable String location)
	{
		return new Gson().toJson(uservices.updateUserLocation(accno,location));
	}
	@DeleteMapping(path="user/delete/{accno}", produces="application/json")
	public String deleteUserDetails(@PathVariable int accno)
	{
		return new Gson().toJson(uservices.delete(accno));
	}
}
