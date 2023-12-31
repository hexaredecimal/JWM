package main;

import libs.ApplicationClasses;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Method;

import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import menu.EventMenu;
import net.miginfocom.swing.MigLayout;

public class Test extends javax.swing.JFrame {

	public Test() {
		initComponents();
		layer.setLayout(new MigLayout("fill, inset 0", "[fill]", "[fill]"));
		layer.setLayer(menu, JLayeredPane.POPUP_LAYER);
		layer.add(menu, "pos 0 0.5al 60 n", 0);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // set maximized window

		menu.addEvent((index) -> {
			Thread t = new Thread() {
				@Override
				public void run() {
					try {
						Class<?> c = ApplicationClasses.getAppByIndex(index);
						Method init = c.getMethod("Init", JDesktopPane.class);
						init.invoke(c, Test.this.desktop);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			};

			String appName = ApplicationClasses.getAppByIndex(index).getName();

			t.start();
			System.out.println(appName + " running on thread: " + t.getName());
			try {
				t.join();
			} catch (InterruptedException e) {
			}

		});

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		menu = new menu.Menu();
		layer = new javax.swing.JLayeredPane();
		setBackgroundImage("bg3.png");
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
		desktop.setLayout(desktopLayout);
		desktopLayout.setHorizontalGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 1350, Short.MAX_VALUE));
		desktopLayout.setVerticalGroup(desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 631, Short.MAX_VALUE));

		layer.setLayer(desktop, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout layerLayout = new javax.swing.GroupLayout(layer);
		layer.setLayout(layerLayout);
		layerLayout.setHorizontalGroup(layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layerLayout.createSequentialGroup()
						.addGap(12, 12, 12).addComponent(desktop).addContainerGap()));
		layerLayout.setVerticalGroup(layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layerLayout.createSequentialGroup().addComponent(desktop).addGap(0, 0, 0)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(layer));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(layer));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void setBackgroundImage(String image) {
		ImageIcon icon = new ImageIcon(getClass().getResource(image));
		Image img = icon.getImage();
		desktop = new javax.swing.JDesktopPane() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}

		};
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Thread main = new Thread(() -> {
					new Test().setVisible(true);
				});

				main.start();
				try {
					main.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JDesktopPane desktop;
	private javax.swing.JLayeredPane layer;
	private menu.Menu menu;
	// End of variables declaration//GEN-END:variables
}
