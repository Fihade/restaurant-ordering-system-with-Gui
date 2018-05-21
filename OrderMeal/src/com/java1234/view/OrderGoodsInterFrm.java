/*
 * OrderGoodsFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.java1234.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.GoodsDao;
import com.java1234.dao.OrderDao;
import com.java1234.model.Goods;
import com.java1234.model.Order;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

/**
 *
 * @author  __USER__
 */
public class OrderGoodsInterFrm extends javax.swing.JInternalFrame {

	DbUtil dbUtil = new DbUtil();
	GoodsDao goodsDao = new GoodsDao();
	OrderDao orderDao = new OrderDao();

	/** Creates new form OrderGoodsFrm */
	public OrderGoodsInterFrm() {
		initComponents();
		this.setLocation(220, 100);
		this.fillGoodsTable(new Goods());
	}

	private void fillGoodsTable(Goods goods) {
		DefaultTableModel dtm = (DefaultTableModel) goodsTable.getModel();
		//清空之前显示
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = goodsDao.goodsList(con, goods);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("goodsName"));
				v.add(rs.getString("goodsDesc"));
				v.add(rs.getString("price"));
				v.add(rs.getString("imageLink"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane2 = new javax.swing.JScrollPane();
		cartTable = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		iamgeLb = new javax.swing.JLabel();
		jb_add = new javax.swing.JButton();
		jb_ok = new javax.swing.JButton();
		jb_delete = new javax.swing.JButton();
		totalMoneyTxt = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		totalNumTxt = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		goodsTable = new javax.swing.JTable();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u7528\u6237\u70b9\u9910\u4e3b\u754c\u9762");

		cartTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "套餐编号", "套餐名称", "套餐数量", "套餐单价", "套餐金额" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane2.setViewportView(cartTable);

		jPanel2.setBorder(javax.swing.BorderFactory
				.createTitledBorder("\u5957\u9910\u56fe\u7247"));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				iamgeLb, javax.swing.GroupLayout.DEFAULT_SIZE, 72,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				iamgeLb, javax.swing.GroupLayout.DEFAULT_SIZE, 65,
				Short.MAX_VALUE));

		jb_add.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/cart.png"))); // NOI18N
		jb_add.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
		jb_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_addActionPerformed(evt);
			}
		});

		jb_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/ok.png"))); // NOI18N
		jb_ok.setText("\u7ed3\u7b97");
		jb_ok.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_okActionPerformed(evt);
			}
		});

		jb_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/delete.png"))); // NOI18N
		jb_delete.setText("\u5220\u9664");
		jb_delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_deleteActionPerformed(evt);
			}
		});

		totalMoneyTxt.setEditable(false);

		jLabel1.setText("\u603b\u91d1\u989d\uff1a");

		jLabel2.setText("\u603b\u6570\u91cf\uff1a");

		totalNumTxt.setEditable(false);

		goodsTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "序号", "套餐名称", "套餐描述", "套餐价格", "图片地址" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		goodsTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				goodsTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(goodsTable);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jb_add)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jScrollPane1,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												449,
																												Short.MAX_VALUE)
																										.addGap(
																												6,
																												6,
																												6)
																										.addComponent(
																												jPanel2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jb_delete)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jb_ok))
																						.addComponent(
																								jScrollPane2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								510,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel2)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				totalNumTxt,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				76,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				totalMoneyTxt,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				81,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(32, 32, 32)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jPanel2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												60,
																												Short.MAX_VALUE))
																						.addGroup(
																								layout
																										.createSequentialGroup()
																										.addComponent(
																												jScrollPane1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												122,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(
																												18,
																												18,
																												18)))
																		.addComponent(
																				jb_add))
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																169,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(jLabel2)
														.addComponent(
																totalNumTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																totalMoneyTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jb_ok)
														.addComponent(jb_delete))
										.addContainerGap(43, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {
		String userName = LogOnFrm.s_currentUser.getUserName();//
		//生成订单号
		String orderId = new java.text.SimpleDateFormat("yyyyMMddHHmmss")
				.format(new java.util.Date());//将当前时间作为订单号码
		float orderTotalMoney = Float.parseFloat(this.totalMoneyTxt.getText());//
		int orderNum = Integer.parseInt(this.totalNumTxt.getText());//

		int rowNum = cartTable.getRowCount();//计算行数
		if (rowNum == 0) {
			JOptionPane.showMessageDialog(null, "请添加上商品后再结算！");
			return;
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			Order order = new Order(orderId, 0, orderNum, orderTotalMoney,
					userName);
			int addNum = orderDao.order_infoAdd(con, order);//插入数据到order_info表
			if (addNum == 1) {
				for (int i = 0; i < rowNum; i++) {

					int goodsId = Integer.parseInt((String) cartTable
							.getValueAt(i, 0));
					String goodsName = (String) cartTable.getValueAt(i, 1);
					int goodsNum = Integer.parseInt((String) cartTable
							.getValueAt(i, 2));
					float goodsPrice = Float.parseFloat((String) cartTable
							.getValueAt(i, 3));
					float goodsTotalPrice = Float.parseFloat((String) cartTable
							.getValueAt(i, 4));
					order = new Order(orderId, goodsTotalPrice, goodsId,
							goodsPrice, goodsNum, goodsName);
					//循环插入数据到order_goods表
					addNum += orderDao.order_goodsAdd(con, order);
				}
			} else {
				JOptionPane.showMessageDialog(null, "订单提交失败");
			}
			if (addNum == (1 + rowNum)) {
				JOptionPane.showMessageDialog(null, "订单提交成功，请记住您的定单号："
						+ orderId);
			} else {
				JOptionPane.showMessageDialog(null, "订单提交失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "订单提交失败");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		//删除选择的行
		dtm.setRowCount(0);
		fillCartTable();
	}

	private void fillCartTable() {
		//修改商品总数和总金额
		int rowNum = cartTable.getRowCount();//计算行数
		int totalNum = 0;//总数量
		float totalMoney = 0;//总金额
		//累加总数量和总金额
		for (int i = 0; i < rowNum; i++) {
			totalNum += Integer.parseInt((String) cartTable.getValueAt(i, 2));
			totalMoney += Float.parseFloat((String) cartTable.getValueAt(i, 4));
		}
		//文本框赋值
		this.totalNumTxt.setText(Integer.toString(totalNum));
		this.totalMoneyTxt.setText(Float.toString(totalMoney));
	}

	private void jb_deleteActionPerformed(java.awt.event.ActionEvent evt) {
		int row = cartTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "请选择要删除的行！");
		} else {
			DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
			//删除选择的行
			dtm.removeRow(row);
		}
		fillCartTable();
	}

	private void jb_addActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		//获取选中的行
		int row = goodsTable.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "请选择一种套餐");
			return;
		}
		//在表单中购物车table中显示加入的数据
		int i = 0, flag = 0;//标记是否已经存在
		int rowNum = cartTable.getRowCount();
		for (i = 0; i < rowNum; i++) {
			if (goodsTable.getValueAt(row, 0)
					.equals(cartTable.getValueAt(i, 0))) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			Vector v = new Vector();
			v.add((String) goodsTable.getValueAt(row, 0));
			v.add((String) goodsTable.getValueAt(row, 1));
			v.add("1");
			v.add((String) goodsTable.getValueAt(row, 3));
			v.add((String) goodsTable.getValueAt(row, 3));
			dtm.addRow(v);
		} else {

			int goodsNum = Integer
					.parseInt((String) cartTable.getValueAt(i, 2)) + 1;//获取当前数量
			float goodsPrice = Float.parseFloat((String) cartTable.getValueAt(
					i, 3));//获取当前单价

			goodsPrice = goodsPrice
					+ Float.parseFloat((String) cartTable.getValueAt(i, 4));//获取数量修改以后的总价
			this.cartTable.setValueAt(Integer.toString(goodsNum), i, 2);
			this.cartTable.setValueAt(Float.toString(goodsPrice), i, 4);
		}
		fillCartTable();
	}

	private void goodsTableMousePressed(java.awt.event.MouseEvent evt) {
		//获取选中的行
		int row = goodsTable.getSelectedRow();

		String picturePath = (String) goodsTable.getValueAt(row, 4);
		if (StringUtil.isNotEmpty(picturePath)) {
			Icon icon = new ImageIcon(picturePath);
			this.iamgeLb.setIcon(icon);
		} else {
			this.iamgeLb.setIcon(null);
		}

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTable cartTable;
	private javax.swing.JTable goodsTable;
	private javax.swing.JLabel iamgeLb;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jb_add;
	private javax.swing.JButton jb_delete;
	private javax.swing.JButton jb_ok;
	private javax.swing.JTextField totalMoneyTxt;
	private javax.swing.JTextField totalNumTxt;
	// End of variables declaration//GEN-END:variables

}