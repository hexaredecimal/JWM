package main;

import applications.Browser;
import applications.Calculator;
import applications.MineSweeper;
import applications.Terminal;
import ide.NewWindow;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
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
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //set maximized window
		menu.addEvent((int index) -> {
			// Supposed to emulate the starting of applications
		});

//        JInternalFrame shell = Terminal.Init();  
//        desktop.add(shell); 
//        shell.setVisible(true);

//		JInternalFrame[] applications = new JInternalFrame[] {
//				Calculator.Init(), 
//				Browser.Init(), 
//				MineSweeper.Init(), 
//				new Terminal()
//		}; 
//		JInternalFrame c = Calculator.Init();
//		desktop.add(c);
//		c.setVisible(true);

//		JInternalFrame b = Browser.Init();
//		desktop.add(b);
//		b.setVisible(true);
//		

        
        Thread t1 = new Thread(() -> {
        	JInternalFrame nw = NewWindow.Init(); 
    		desktop.add(nw);
    		nw.setVisible(true);
        }); 
		
        t1.start();

        Thread t2 = new Thread(() -> {
    		JInternalFrame m = MineSweeper.Init(); 
    		desktop.add(m); 
    		m.setVisible(true);
        });
        
        t2.start();
        
        try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	private void showForm(Component com) {
//        main.removeAll();
//        main.add(com);
//        main.repaint();
//        main.revalidate();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		menu = new menu.Menu();
		layer = new javax.swing.JLayeredPane();
		ImageIcon icon = new ImageIcon(getClass().getResource("a.jpg"));
		Image img = icon.getImage();
		desktop = new javax.swing.JDesktopPane() {
			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};

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
