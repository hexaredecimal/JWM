package ide;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vulture
 */
public class NewProject extends javax.swing.JFrame {

	/**
	 * Creates new form NewProject
	 */

	private File selectedFile;

	public NewProject() {
		initComponents();
		this.setResizable(false);
		this.setTitle("Create a new project");
		this.hasError = false;
		// this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jTextFieldProjectName = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jTextFieldProjectAuthor = new javax.swing.JTextField();
		jLabelProjectNameError = new javax.swing.JLabel();
		jLabelProjectAuthorError = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jTextFieldProjectLocation = new javax.swing.JTextField();
		jCheckBox1 = new javax.swing.JCheckBox();
		jButton1 = new javax.swing.JButton();
		jLabelProjectLocationError = new javax.swing.JLabel();
		jButtonFinish = new javax.swing.JButton();
		jButtonHelp = new javax.swing.JButton();
		jButtonCancel = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setLocation(new java.awt.Point(400, 400));
		setResizable(false);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
		jLabel1.setText("<HTML><U> STEPS___________</U></HTML>");

		jLabel2.setText("<HTML> Add <B> project name </B> <BR> and <B>author(s)");

		jLabel6.setText("<HTML> Add <B> project folder name </B> <BR> and  create new <B>  file system </B>");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 138,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Project Information"));

		jLabel3.setText("Project name  :");

		jLabel4.setText("Project author :");

		jLabelProjectNameError.setForeground(new java.awt.Color(255, 0, 0));
		jLabelProjectNameError.setText("*");
		jLabelProjectNameError.setEnabled(false);

		jLabelProjectAuthorError.setForeground(new java.awt.Color(255, 0, 0));
		jLabelProjectAuthorError.setText("*");
		jLabelProjectAuthorError.setEnabled(false);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel3Layout.createSequentialGroup().addComponent(jLabel4)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
								.addGroup(
										jPanel3Layout.createSequentialGroup().addComponent(jLabel3).addGap(13, 13, 13)))
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(jTextFieldProjectName).addComponent(jTextFieldProjectAuthor,
										javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabelProjectNameError).addComponent(jLabelProjectAuthorError))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(jTextFieldProjectName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelProjectNameError))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(jTextFieldProjectAuthor, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelProjectAuthorError))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Project Filesystem"));

		jLabel5.setText("Project location :");

		jCheckBox1.setText("Create a new folder");

		jButton1.setText("Select");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabelProjectLocationError.setForeground(new java.awt.Color(255, 0, 0));
		jLabelProjectLocationError.setText("Invalid project location");
		jLabelProjectLocationError.setEnabled(false);

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel4Layout.createSequentialGroup().addComponent(jCheckBox1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabelProjectLocationError))
								.addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel5)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jTextFieldProjectLocation, javax.swing.GroupLayout.PREFERRED_SIZE,
												227, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButton1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5)
								.addComponent(jTextFieldProjectLocation, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jCheckBox1).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel4Layout.createSequentialGroup().addComponent(jLabelProjectLocationError)
												.addContainerGap()))));

		jButtonFinish.setText("Finish");
		jButtonFinish.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonFinishActionPerformed(evt);
			}
		});

		jButtonHelp.setText("Help");

		jButtonCancel.setText("Cancel");
		jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCancelActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel2Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addComponent(jButtonCancel)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButtonFinish)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButtonHelp)))
						.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonFinish).addComponent(jButtonHelp).addComponent(jButtonCancel))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonCancelActionPerformed
		this.dispose();
	}// GEN-LAST:event_jButtonCancelActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = fileChooser.showOpenDialog(null);

		if (option == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			jTextFieldProjectLocation.setText(selectedFile.getPath());
		}
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButtonFinishActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonFinishActionPerformed
		if (jTextFieldProjectName.getText().isEmpty()) {
			jLabelProjectNameError.setEnabled(true);
			return;
		} else {
			jLabelProjectNameError.setEnabled(false);
		}

		if (jTextFieldProjectAuthor.getText().isEmpty()) {
			jLabelProjectAuthorError.setEnabled(true);
			return;
		} else {
			jLabelProjectAuthorError.setEnabled(false);
		}

		if (jTextFieldProjectLocation.getText().isEmpty()) {
			jLabelProjectLocationError.setEnabled(true);
			jLabelProjectLocationError.setText("Invalid project location");
		} else {

			if (selectedFile != null && selectedFile.exists() == false) {
				jLabelProjectLocationError.setEnabled(true);
				jLabelProjectLocationError.setText("Selected directory does not exist");
				return;
			} else if (selectedFile == null) {
				File tmp = new File(jTextFieldProjectLocation.getText());
				if (tmp.exists() == false) {
					jLabelProjectLocationError.setEnabled(true);
					jLabelProjectLocationError.setText("Selected directory does not exist");
					return;
				}
			} else {
				// continue by disableing the errors
				jLabelProjectLocationError.setText("Invalid project location");
				jLabelProjectLocationError.setEnabled(false);
			}
		}

		String projectName = jTextFieldProjectName.getText();
		String projectAuthor = jTextFieldProjectAuthor.getText();
		String projectPath = jTextFieldProjectLocation.getText();

	}// GEN-LAST:event_jButtonFinishActionPerformed

	private boolean hasError;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButtonCancel;
	private javax.swing.JButton jButtonFinish;
	private javax.swing.JButton jButtonHelp;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabelProjectAuthorError;
	private javax.swing.JLabel jLabelProjectLocationError;
	private javax.swing.JLabel jLabelProjectNameError;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JTextField jTextFieldProjectAuthor;
	private javax.swing.JTextField jTextFieldProjectLocation;
	private javax.swing.JTextField jTextFieldProjectName;
	// End of variables declaration//GEN-END:variables
}
