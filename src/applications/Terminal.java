/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package applications;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import libs.ConsoleAPI;
import libs.TextConsole;

/**
 *
 * @author ERC
 */
public class Terminal extends javax.swing.JInternalFrame {

	/**
	 * Creates new form Terminal
	 */
	private Terminal() {
		initComponents();

		setLocation(new java.awt.Point(300, 60));
		this.setLayout(new BorderLayout());
		this.add(console, BorderLayout.CENTER);
		this.setResizable(true);
		this.setClosable(true);
		this.setSize(100, 80);
		this.pack();

		performDemo(console.getConsoleAPI());
	}

	private void performDemo(ConsoleAPI consoleAPI) {
		consoleAPI.clear();
		consoleAPI.setStringAt(0, 0, ">>", Color.WHITE, Color.BLACK);

		consoleAPI.refresh();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		console = new libs.TextConsole();

		setTitle("Terminal");
		setToolTipText("");

		jScrollPane1.setViewportView(console);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public static JInternalFrame Init(JDesktopPane parent) {
		Terminal term = new Terminal();
		term.setVisible(true);
		parent.add(term);
		return term;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private libs.TextConsole console;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration//GEN-END:variables
}
