package libs;

import applications.ApplicationsList;
import applications.Browser;
import applications.Calculator;
import applications.FileBrowser;
import applications.MineSweeper;
import applications.Terminal;
import equcyph.EquCyph;
import ide.NewWindow;

public final class ApplicationClasses {
	private static Class<?>[] appList = new Class<?>[] { Browser.class, Calculator.class, NewWindow.class,
			Terminal.class, EquCyph.class, FileBrowser.class, MineSweeper.class, ApplicationsList.class };

	public static Class<?> getAppByIndex(int index) {
		if (index >= appList.length)
			throw new IndexOutOfBoundsException(
					"Out of bounds with index of " + index + " on array length of " + appList.length);

		return appList[index];
	}

	public static Class<?> getAppByName(String name) throws ClassNotFoundException {
		for (Class<?> app : appList) {
			if (app.getName().equals(name))
				return app;
		}
		throw new ClassNotFoundException("Class " + name + " doesn't exist.");
	}
}
