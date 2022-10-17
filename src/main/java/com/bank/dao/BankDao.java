package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bank.pojo.Bank;
import com.bank.pojo.User;

public class BankDao {
	@Autowired
	NamedParameterJdbcTemplate template;

	public NamedParameterJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	public List<Bank> getAllBank() {
		String sql = "select * from banks ";
		List<Bank> list = template.query(sql, new RowMapper<Bank>() {

			public Bank mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bank bank = new Bank();

				bank.setBid(rs.getInt(1));
				bank.setBname(rs.getString(2));
				bank.setCity(rs.getString(3));
				bank.setIfsc(rs.getString(4));
				return bank;
			}
		});
		return list;
	}

	public List<User> getAllUser() {
		String sql = "select * from bank_user";
		List<User> list = template.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setAccno(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setLocation(rs.getString(3));
				u.setBalance(rs.getDouble(4));
				u.setMobile(rs.getString(5));
				u.setBankid(rs.getInt(6));
				// System.out.println(u);
				return u;
			}
		});
		return list;
	}

	public Bank getBankByID(int id) {
		String sql = "select * from banks where bid=:id";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		List<Bank> list = template.query(sql, map, new RowMapper<Bank>() {

			public Bank mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bank bank = new Bank();

				bank.setBid(rs.getInt(1));
				bank.setBname(rs.getString(2));
				bank.setCity(rs.getString(3));
				bank.setIfsc(rs.getString(4));
				return bank;
			}
		});
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public User getUserByAcc(int accno) {
		String sql = "select * from bank_user where accno=:accno";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accno", accno);
		List<User> list = template.query(sql, map, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setAccno(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setLocation(rs.getString(3));
				u.setBalance(rs.getDouble(4));
				u.setMobile(rs.getString(5));
				u.setBankid(rs.getInt(6));
				return u;
			}
		});

		if(!list.isEmpty()) {
			return list.get(0);
		}
		else
		{
			return null;
		}
	}

	public void insertBank(Bank bank) {
		String sql = "insert into banks values(:id,:name,:city,:ifsc)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", bank.getBid());
		map.put("name", bank.getBname());
		map.put("city", bank.getCity());
		map.put("ifsc", bank.getIfsc());
		int i = template.update(sql, map);
		if (i == 1)
			System.out.println("Bank Inserted successfully........");
		else
			System.out.println("Unable to insert!!!!!!!!!!!");
	}

	public boolean insertUser(User u) {
		String sql = "insert into bank_user values(:accno,:name,:location,:balance,:mobile,:bankid)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accno", u.getAccno());
		map.put("name", u.getUname());
		map.put("location", u.getLocation());
		map.put("balance", u.getBalance());
		map.put("mobile", u.getMobile());
		map.put("bankid", u.getBankid());
		int i = template.update(sql, map);
		if (i == 1)
		{
			System.out.println("User Inserted successfully........");
			return true;
		}
		else
		{
			System.out.println("Unable to insert!!!!!!!!!!!");
			return false;
		}
	}

	public boolean updateBankCity(int id, String city) {
		String sql = "update banks set city=:city where bid=:id";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("city", city);
		int i = template.update(sql, map);
		if (i == 1) {
			System.out.println("Bank Details Updated  successfully........");
			return true;
		} else {
			System.out.println("Unable to update!!!!!!!!!!!");
			return false;
		}
	}

	public boolean updateUserBalance(int accno, double balance) {
		String sql = "update bank_user set balance=:balance where accno=:accno";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("balance", balance);
		map.put("accno", accno);
		int i = template.update(sql, map);
		if (i == 1) {
			System.out.println("User details Updated  successfully........");
			return true;
		} else {
			System.out.println("Unable to update!!!!!!!!!!!");
			return false;
		}
	}

	public boolean updateUserLocation(int accno, String location) {
		String sql = "update bank_user set location=:location where accno=:accno";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("location", location);
		map.put("accno", accno);
		int i = template.update(sql, map);
		if (i == 1) {
			System.out.println("Student details Updated  successfully........");
			return true;
		} else {
			System.out.println("Unable to update!!!!!!!!!!!");
			return false;
		}
	}

	public boolean deleteUser(int accno) {
		String sql = "delete from bank_user where accno=" + accno + "";
		Map<String, Object> map = new HashMap<String, Object>();
		int i = template.update(sql, map);
		if (i == 1) {
			System.out.println("Student details Updated  successfully........");
			return true;
		} else {
			System.out.println("Unable to update!!!!!!!!!!!");
			return false;
		}
	}

	public Bank getfullBank(int id) {
		String sql = "select * from banks where bid=:id";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);

		List<Bank> bank = template.query(sql, map, new RowMapper<Bank>() {

			public Bank mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bank bank = new Bank();

				bank.setBid(rs.getInt(1));
				bank.setBname(rs.getString(2));
				bank.setCity(rs.getString(3));
				bank.setIfsc(rs.getString(4));
				return bank;
			}
		});
		String sql1 = "select * from bank_user where bankid=:id";
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", id);
		List<User> list = template.query(sql1, map1, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setAccno(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setLocation(rs.getString(3));
				u.setBalance(rs.getDouble(4));
				u.setMobile(rs.getString(5));
				u.setBankid(rs.getInt(6));
				return u;
			}
		});
		if (!bank.isEmpty()) {
			bank.get(0).setUser(list);
			return bank.get(0);
		}

		return null;

	}
}
