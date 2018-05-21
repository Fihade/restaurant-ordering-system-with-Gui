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
		//���֮ǰ��ʾ
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

				}, new String[] { "�ײͱ��", "�ײ�����", "�ײ�����", "�ײ͵���", "�ײͽ��" }) {
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

				}, new String[] { "���", "�ײ�����", "�ײ�����", "�ײͼ۸�", "ͼƬ��ַ" }) {
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
		//���ɶ�����
		String orderId = new java.text.SimpleDateFormat("yyyyMMddHHmmss")
				.format(new java.util.Date());//����ǰʱ����Ϊ��������
		float orderTotalMoney = Float.parseFloat(this.totalMoneyTxt.getText());//
		int orderNum = Integer.parseInt(this.totalNumTxt.getText());//

		int rowNum = cartTable.getRowCount();//��������
		if (rowNum == 0) {
			JOptionPane.showMessageDialog(null, "���������Ʒ���ٽ��㣡");
			return;
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			Order order = new Order(orderId, 0, orderNum, orderTotalMoney,
					userName);
			int addNum = orderDao.order_infoAdd(con, order);//�������ݵ�order_info��
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
					//ѭ���������ݵ�order_goods��
					addNum += orderDao.order_goodsAdd(con, order);
				}
			} else {
				JOptionPane.showMessageDialog(null, "�����ύʧ��");
			}
			if (addNum == (1 + rowNum)) {
				JOptionPane.showMessageDialog(null, "�����ύ�ɹ������ס���Ķ����ţ�"
						+ orderId);
			} else {
				JOptionPane.showMessageDialog(null, "�����ύʧ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�����ύʧ��");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		//ɾ��ѡ�����
		dtm.setRowCount(0);
		fillCartTable();
	}

	private void fillCartTable() {
		//�޸���Ʒ�������ܽ��
		int rowNum = cartTable.getRowCount();//��������
		int totalNum = 0;//������
		float totalMoney = 0;//�ܽ��
		//�ۼ����������ܽ��
		for (int i = 0; i < rowNum; i++) {
			totalNum += Integer.parseInt((String) cartTable.getValueAt(i, 2));
			totalMoney += Float.parseFloat((String) cartTable.getValueAt(i, 4));
		}
		//�ı���ֵ
		this.totalNumTxt.setText(Integer.toString(totalNum));
		this.totalMoneyTxt.setText(Float.toString(totalMoney));
	}

	private void jb_deleteActionPerformed(java.awt.event.ActionEvent evt) {
		int row = cartTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����У�");
		} else {
			DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
			//ɾ��ѡ�����
			dtm.removeRow(row);
		}
		fillCartTable();
	}

	private void jb_addActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
		//��ȡѡ�е���
		int row = goodsTable.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "��ѡ��һ���ײ�");
			return;
		}
		//�ڱ��й��ﳵtable����ʾ���������
		int i = 0, flag = 0;//����Ƿ��Ѿ�����
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
					.parseInt((String) cartTable.getValueAt(i, 2)) + 1;//��ȡ��ǰ����
			float goodsPrice = Float.parseFloat((String) cartTable.getValueAt(
					i, 3));//��ȡ��ǰ����

			goodsPrice = goodsPrice
					+ Float.parseFloat((String) cartTable.getValueAt(i, 4));//��ȡ�����޸��Ժ���ܼ�
			this.cartTable.setValueAt(Integer.toString(goodsNum), i, 2);
			this.cartTable.setValueAt(Float.toString(goodsPrice), i, 4);
		}
		fillCartTable();
	}

	private void goodsTableMousePressed(java.awt.event.MouseEvent evt) {
		//��ȡѡ�е���
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