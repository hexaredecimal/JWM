package applications;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import libs.AppWrappers;
import libs.ApplicationClasses;
import main.Test;

public class ApplicationsList extends JInternalFrame {
	private int width = 120, height = 380;
	private JComponent parent;

	public ApplicationsList(JDesktopPane parent) {

		setSize(width, height);
		setLocation(width * 2, height);
		setResizable(true);
		setClosable(true);

		JPanel panel = new JPanel();
		String[] icons = new String[] { "browser", "calc", "editor", "term", "graph", "files", "mine", "apps" };

//		setLayout(new BoxLayout(this, BoxLayout.X_AXIS | BoxLayout.Y_AXIS));

		for (int i = 0; i < icons.length; i++) {
			String icon = icons[i];
			Image img = new ImageIcon(getClass().getResource("/icon/" + icon + ".png")).getImage().getScaledInstance(32,
					32, Image.SCALE_SMOOTH);

			JButton btn = new JButton(new ImageIcon(img));
			btn.addActionListener((e) -> {
				Thread t = new Thread() {
					@Override
					public void run() {
						AppWrappers app = AppWrappers.valueOf(icon.toUpperCase());
						Method m = app.getInit().orElseThrow();
						Class<?> c = app.getClass();
						try {
							m.invoke(c, parent);
						} catch (Exception e) {
							System.out.println(e);
						}
					}
				};

				t.start();
				try {
					t.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			});

			panel.add(btn, "w 50!, h 50!");
		}

//		JScrollPane scroll = new JScrollPane(panel); 
//		add(scroll);
		add(panel);
		pack();
	}

	public static JInternalFrame Init(JDesktopPane parent) {
		ApplicationsList fr = new ApplicationsList(parent);
		fr.setTitle("App Menu");
		fr.setVisible(true);
		parent.add(fr);
		return fr;
	}
}
