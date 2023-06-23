package applications;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Browser extends JInternalFrame {

  private JTabbedPane tabbedPane = new JTabbedPane();

  public Browser() {
    super("Browser");
    setLocation(new java.awt.Point(200, 150));
    createNewTab();

    getContentPane().add(tabbedPane);

    JMenu fileMenu = new JMenu("File");
    fileMenu.add(new NewTabAction());
    fileMenu.addSeparator();
    fileMenu.add(new ExitAction());
    fileMenu.setMnemonic('F');

    JMenuBar menuBar = new JMenuBar();
    menuBar.add(fileMenu);
    setJMenuBar(menuBar);

  }

  private void createNewTab() {
    JPanel panel = new JPanel(new BorderLayout());
    WebBrowserPane browserPane = new WebBrowserPane();

    WebToolBar toolBar = new WebToolBar(browserPane);
    panel.add(toolBar, BorderLayout.NORTH);
    panel.add(new JScrollPane(browserPane), BorderLayout.CENTER);
    tabbedPane.addTab("[New Tab] (" + Integer.toString(tabbedPane.getTabCount()) + ")", panel);
  }
  
  

  private class NewTabAction extends AbstractAction {

    public NewTabAction() {
      putValue(Action.NAME, "New Browser Tab");
      putValue(Action.SHORT_DESCRIPTION, "Create New Web Browser Tab");
      putValue(Action.MNEMONIC_KEY, new Integer('N'));
    }

    public void actionPerformed(ActionEvent event) {
      createNewTab();
    }
  }

  private class ExitAction extends AbstractAction {
    public ExitAction() {
      putValue(Action.NAME, "Exit");
      putValue(Action.SHORT_DESCRIPTION, "Exit Application");
      putValue(Action.MNEMONIC_KEY, new Integer('x'));
    }

    public void actionPerformed(ActionEvent event) {
      System.exit(0);
    }
  }

  public static JInternalFrame Init() {
    Browser browser = new Browser();
//    browser.setDefaultCloseOperation(EXIT_ON_CLOSE);
    browser.setSize(640, 480);
    browser.setClosable(true);
    browser.setResizable(true);
    browser.setVisible(true);
    return browser; 
  }
}

class WebBrowserPane extends JEditorPane {

  private List history = new ArrayList();

  private int historyIndex;

  public WebBrowserPane() {
    setEditable(false);
  }

  public void goToURL(URL url) {
    displayPage(url);
    history.add(url);
    historyIndex = history.size() - 1;
  }

  public URL forward() {
    historyIndex++;
    if (historyIndex >= history.size())
      historyIndex = history.size() - 1;

    URL url = (URL) history.get(historyIndex);
    displayPage(url);

    return url;
  }

  public URL back() {
    historyIndex--;

    if (historyIndex < 0)
      historyIndex = 0;

    URL url = (URL) history.get(historyIndex);
    displayPage(url);

    return url;
  }

  private void displayPage(URL pageURL) {
    try {
      setPage(pageURL);
    } catch (IOException ioException) {
		StringBuilder sb = new StringBuilder(); 
		sb
		.append("Error: ")
		.append("Failed to load url(")
		.append(ioException.getMessage())
		.append(") : ")
		.append(ioException.getCause() != null ? ioException.getCause().toString() : "Unknown");
		
		JOptionPane.showMessageDialog(this, sb.toString());
//    	System.err.println("Error: " + ioException.getMessage());
    }
  }
}

class WebToolBar extends JToolBar implements HyperlinkListener {

  private WebBrowserPane webBrowserPane;

  private JButton backButton;

  private JButton forwardButton;

  private JTextField urlTextField;

  public WebToolBar(WebBrowserPane browser) {
    super("Web Navigation");

    // register for HyperlinkEvents
    webBrowserPane = browser;
    webBrowserPane.addHyperlinkListener(this);

    urlTextField = new JTextField(25);
    urlTextField.addActionListener(new ActionListener() {

      // navigate webBrowser to user-entered URL
      public void actionPerformed(ActionEvent event) {

        try {
          URL url = new URL(urlTextField.getText());
          webBrowserPane.goToURL(url);
        }

        catch (MalformedURLException urlException) {
//          urlException.printStackTrace();
    		StringBuilder sb = new StringBuilder(); 
    		sb
    		.append("Error: ")
    		.append("Failed to load url(")
    		.append(urlException.getMessage())
    		.append(") : ")
    		.append(urlException.getCause() != null ? urlException.getCause().toString() : "Unknown");
    		JOptionPane.showMessageDialog(webBrowserPane, sb.toString());
        	System.err.println("Error: " + urlException.getMessage());
        }
      }
    });

    backButton = new JButton("back");
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        URL url = webBrowserPane.back();
        urlTextField.setText(url.toString());
      }
    });

    forwardButton = new JButton("forward");

    forwardButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent event) {
        URL url = webBrowserPane.forward();
        urlTextField.setText(url.toString());
      }
    });
    add(backButton);
    add(forwardButton);
    add(urlTextField);
  }

  public void hyperlinkUpdate(HyperlinkEvent event) {
    if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
      URL url = event.getURL();
      webBrowserPane.goToURL(url);
      urlTextField.setText(url.toString());
    }
  }
}