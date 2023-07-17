package libs;

import java.lang.reflect.Method;
import java.util.Optional;

import javax.swing.JDesktopPane;

import applications.ApplicationsList;
import applications.Browser;
import applications.Calculator;
import applications.FileBrowser;
import applications.MineSweeper;
import applications.Terminal;
import equcyph.EquCyph;
import ide.NewWindow;

/**
 * 
 * @author hexaredecimal
 * 
 * @implNote Maps application class to icon name for easy instantiation
 */
public enum AppWrappers {
	BROWSER(Browser.class), CALC(Calculator.class), EDITOR(NewWindow.class), TERM(Terminal.class), GRAPH(EquCyph.class),
	FILES(FileBrowser.class), MINE(MineSweeper.class), APPS(ApplicationsList.class);

	Class<?> instance;

	AppWrappers(Class<?> app) {
		instance = app;
	}

	public Class getInstance() {
		return instance;
	}

	public Optional<Method> getInit() {
		Method init = null;
		try {
			init = instance.getMethod("Init", JDesktopPane.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.ofNullable(init);
	}
}
