package com.bank.servicepkg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.BankDao;
import com.bank.pojo.Bank;
import com.bank.pojo.User;
@Service
public class AdminServices {
		@Autowired
		BankDao dao;
		
		public List<Bank> allBank(){
			return dao.getAllBank();
		}
		
		public List<User> allUser(){
			return dao.getAllUser();
		}
		
		public boolean updateBankLocation(int bid,String location) {
			return dao.updateBankCity(bid,location);
		}
		public boolean updateuserLocation(int accno, String location)
		{
			return dao.updateUserLocation(accno, location);
		}
		public boolean updateUserBalance(int accno, double balance)
		{
			return dao.updateUserBalance(accno, balance);
		}
		public User getUserById(int accno)
		{
			return dao.getUserByAcc(accno);
		}
		public Bank getBankById(int bid)
		{
			return dao.getBankByID(bid);
		}
		public Bank getUserListByBankId(int bid)
		{
			return dao.getfullBank(bid);
		}
		public boolean insertUser(User user)
		{
			return dao.insertUser(user);
		}
}
