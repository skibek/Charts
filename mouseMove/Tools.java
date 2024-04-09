package com.company.tool;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lombok.extern.java.Log;

@Log
public class Tools {

    //TODO add process, dont open CMD window
    //Add icon in Tray - and option to EXIT app from this

	public int timeToMove;
	public int timeToMoveMin;
	//time move = > 1 min < 3 min
    public int moveMaxX; //move in + and - from current position (must be even number)
	public int moveMaxY; //move in + and - from current position (must be even number)
    private static final String ACTION_EXIT = "exitApp";
	private static TrayIcon trayIcon = null;

	private final Properties propValues = new Properties();

    public void openProperties() throws IOException {
		try (InputStream is = Tools.class.getClassLoader().getResourceAsStream("mouse.properties")) {
			propValues.load(is);
			timeToMove = Integer.parseInt(propValues.getProperty("timeToMove"));
			timeToMoveMin = Integer.parseInt(propValues.getProperty("timeToMoveMin"));

			moveMaxX = Integer.parseInt(propValues.getProperty("moveMaxX"));
			moveMaxY = Integer.parseInt(propValues.getProperty("moveMaxY"));
		}
	}

	public void sendMessage(String message) {
		log.info(message);
		if (trayIcon != null) {
			trayIcon.setToolTip(message);
		}
	}

	public void addTray() throws AWTException {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/favicon.ico"));
            ActionListener listener = e -> {
				log.info(e.toString());
				if (e.getActionCommand().equals(ACTION_EXIT)) {
					System.exit(0);
				}
			};

            PopupMenu popupMenu = new PopupMenu();
            MenuItem menuItem = new MenuItem();
            menuItem.setLabel("Exit");
            menuItem.setActionCommand(ACTION_EXIT);
            menuItem.addActionListener(listener);
            popupMenu.add(menuItem);

            trayIcon = new TrayIcon(image, "Tool", popupMenu);
            trayIcon.addActionListener(listener);
            tray.add(trayIcon);
        }
    }

    /*private void keyboardExit() {

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
                new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent e) {
                        System.out.println(e);
                        return false;
                    }
                }
        );


    } */
}
