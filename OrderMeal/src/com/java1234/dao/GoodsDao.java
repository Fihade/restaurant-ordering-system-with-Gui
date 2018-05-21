package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java1234.model.Goods;
import com.java1234.util.StringUtil;

public class GoodsDao {
	public int GoodsAdd(Connection con,Goods goods) throws Exception{
		String sql="insert into goods values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, goods.getGoodsName());
		pstmt.setFloat(2, goods.getPrice());
		pstmt.setString(3, goods.getGoodsDesc());
		pstmt.setString(4, goods.getImageLink());
		return pstmt.executeUpdate();
	}
	public ResultSet goodsList(Connection con,Goods goods) throws Exception{	
		StringBuffer sb=new StringBuffer("select * from `goods`");
		if(StringUtil.isNotEmpty(goods.getGoodsName())){
			sb.append(" and goodsName like '%"+goods.getGoodsName()+"%'");
		}
		if((goods.getPrice1()!=0)&&(goods.getPrice()==0) ){//低价格有，高价格无
			sb.append(" and price>="+goods.getPrice1());
		}else if(goods.getPrice()>goods.getPrice1()){//中间价格
			sb.append(" and price between "+goods.getPrice1()+" and "+goods.getPrice());
		}
		else if((goods.getPrice()!=0)){//高价格有，低价格无或者和高价格一样
			sb.append(" and price<="+goods.getPrice());
		}
		if(goods.getId()!=0){
			sb.append(" and id="+goods.getId());
		}
		//System.out.println(sb.toString().replaceFirst("and", "where"));
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	public int goodsDelete(Connection con,String id) throws Exception{
		String sql="delete from goods where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	public int goodsModify(Connection con,Goods goods) throws Exception{
		String sql="update goods set goodsName=?,goodsDesc=?,price=?,imageLink=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, goods.getGoodsName());
		pstmt.setString(2, goods.getGoodsDesc());
		pstmt.setFloat(3, goods.getPrice());
		pstmt.setString(4, goods.getImageLink());
		pstmt.setInt(5, goods.getId());
		return pstmt.executeUpdate();
	}
}
