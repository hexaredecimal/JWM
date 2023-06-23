package applications;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JPanel implements ActionListener {

    private JTextField display = new JTextField("0");

    private String buttonText = "789/456*123-0.=+";

    private double result = 0;

    private String operator = "=";

    private boolean calculating = true;

    public Calculator() {
        setLayout(new BorderLayout());
        setLocation(new java.awt.Point(600, 250));

        display.setEditable(false);
        add(display, "North");

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < buttonText.length(); i++) {
            JButton b = new JButton(buttonText.substring(i, i + 1));
            p.add(b);
            b.addActionListener(this);

        }
        add(p, "Center");
    }

    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if ('0' <= cmd.charAt(0) && cmd.charAt(0) <= '9' || cmd.equals(".")) {
            if (calculating) {
                display.setText(cmd);
            } else {
                display.setText(display.getText() + cmd);
            }
            calculating = false;
        } else {
            if (calculating) {
                if (cmd.equals("-")) {
                    display.setText(cmd);
                    calculating = false;
                } else {
                    operator = cmd;
                }
            } else {
                double x = Double.parseDouble(display.getText());
                calculate(x);
                operator = cmd;
                calculating = true;
            }
        }
    }

    private void calculate(double n) {
        if (operator.equals("+")) {
            result += n;
        } else if (operator.equals("-")) {
            result -= n;
        } else if (operator.equals("*")) {
            result *= n;
        } else if (operator.equals("/")) {
            result /= n;
        } else if (operator.equals("=")) {
            result = n;
        }
        display.setText("" + result);
    }

    public static JInternalFrame Init() {
        JInternalFrame frame = new JInternalFrame();
        frame.setTitle("Calculator");
        frame.setSize(200, 200);
        frame.setClosable(true);
        frame.setResizable(true);

        Container contentPane = frame.getContentPane();
        contentPane.add(new Calculator());

        frame.setVisible(true);
        frame.setLocation(new java.awt.Point(200, 150));
        return frame;
    }
}
