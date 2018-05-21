/*
 * UserFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.java1234.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author  __USER__
 */
public class UserOrderFrm extends javax.swing.JFrame {

	/** Creates new form UserFrm */
	public UserOrderFrm() {
		initComponents();
		//设置最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		table = new javax.swing.JDesktopPane();
		jMenuBar1 = new javax.swing.JMenuBar();
		jm_order = new javax.swing.JMenu();
		jmi_order = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jmi_checkOrder = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jmi_modify = new javax.swing.JMenuItem();
		jmiExit = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u7528\u6237\u70b9\u9910\u4e3b\u754c\u9762");

		jm_order.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/order3.png"))); // NOI18N
		jm_order.setText("\u7528\u6237\u70b9\u9910");

		jmi_order.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/cart.png"))); // NOI18N
		jmi_order.setText("\u5f00\u59cb\u70b9\u9910");
		jmi_order.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmi_orderActionPerformed(evt);
			}
		});
		jm_order.add(jmi_order);

		jMenuBar1.add(jm_order);

		jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/search1.png"))); // NOI18N
		jMenu2.setText("\u8ba2\u5355\u8be6\u60c5");

		jmi_checkOrder.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/images/ok.png"))); // NOI18N
		jmi_checkOrder.setText("\u67e5\u770b\u8ba2\u5355");
		jmi_checkOrder.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmi_checkOrderActionPerformed(evt);
			}
		});
		jMenu2.add(jmi_checkOrder);

		jMenuBar1.add(jMenu2);

		jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/order2.png"))); // NOI18N
		jMenu3.setText("\u5176\u4ed6");

		jmi_modify.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/edit.png"))); // NOI18N
		jmi_modify.setText("\u4fe1\u606f\u4fee\u6539");
		jmi_modify.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmi_modifyActionPerformed(evt);
			}
		});
		jMenu3.add(jmi_modify);

		jmiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/exit.png"))); // NOI18N
		jmiExit.setText("\u9000\u51fa\u7cfb\u7edf");
		jmiExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmiExitActionPerformed(evt);
			}
		});
		jMenu3.add(jmiExit);

		jMenuBar1.add(jMenu3);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(table,
				javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(table,
				javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents
    //修改用户信息按钮
	private void jmi_modifyActionPerformed(java.awt.event.ActionEvent evt) {
		AccountModifyInterFrm accountModify = new AccountModifyInterFrm();
		accountModify.setVisible(true);
		this.table.add(accountModify);
	}
	//查看订单按钮
	private void jmi_checkOrderActionPerformed(java.awt.event.ActionEvent evt) {
		CheckOrderInterFrm CheckOrderInterFrm = new CheckOrderInterFrm();
		CheckOrderInterFrm.setVisible(true);
		this.table.add(CheckOrderInterFrm);
	}
    //退出按钮
	private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(null, "是否退出系统？");
		//System.out.println(result);
		if (result == 0)
			this.dispose();
	}
    //点餐按钮
	private void jmi_orderActionPerformed(java.awt.event.ActionEvent evt) {
		OrderGoodsInterFrm orderGoodsInterFrm = new OrderGoodsInterFrm();
		orderGoodsInterFrm.setVisible(true);
		this.table.add(orderGoodsInterFrm);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UserOrderFrm().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenu jm_order;
	private javax.swing.JMenuItem jmiExit;
	private javax.swing.JMenuItem jmi_checkOrder;
	private javax.swing.JMenuItem jmi_modify;
	private javax.swing.JMenuItem jmi_order;
	private javax.swing.JDesktopPane table;
	// End of variables declaration//GEN-END:variables

}