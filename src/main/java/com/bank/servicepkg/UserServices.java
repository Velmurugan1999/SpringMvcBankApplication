package com.bank.servicepkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.BankDao;
import com.bank.pojo.User;

@Service
public class UserServices {
	@Autowired
	BankDao dao;
	public User getUserByAccno(int accno)
	{
		return dao.getUserByAcc(accno);
	}
	public boolean updateUserLocation(int accno,String location)
	{
		return dao.updateUserLocation(accno, location);
	}
	public boolean delete(int accno)
	{
		return dao.deleteUser(accno);
	}
	
}
