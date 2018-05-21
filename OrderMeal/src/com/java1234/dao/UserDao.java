package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java1234.model.User;
import com.java1234.util.StringUtil;

public class UserDao {

	/**
	 * µÇÂ½ÑéÖ¤
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user) throws Exception{
		User resultUser = null;
		String sql="select *from user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser = new User();
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
			resultUser.setRank(rs.getInt("rank"));
			resultUser.setId(rs.getInt("id"));
		}
		return resultUser;
	}
	public int userAdd(Connection con,User user) throws Exception{
		String sql="insert into `user` values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getEmail());
		pstmt.setInt(4, user.getRank());
		return pstmt.executeUpdate();
	}
	public boolean isUserExist(Connection con,User user) throws Exception{
		String sql="select *from user where userName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		ResultSet rs =pstmt.executeQuery();
		return rs.next();
	}
	
	public int userModify(Connection con,User user) throws Exception{
		String sql="update `user` set userName=?,password=?,email=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getEmail());
		pstmt.setInt(4, user.getId());;
		return pstmt.executeUpdate();
	}
}
