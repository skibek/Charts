package com.company.tool;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MouseTool {

    //TODO add process, dont open CMD window
    //Add icon in Tray - and option to EXIT app from this
    
    private static boolean moveMouseFlag = true;
    private static int timeToMove = 60 * 1000; // 60s
    private static int minTimeToMove = 30000; // 30s
    private static final int MAX_X = 5;
    private static final int MAX_Y = 5;
    private static final String ACTION_EXIT = "exitApp";

    public static void main(String[] args) throws AWTException, InterruptedException {
        MouseTool mouseTool = new MouseTool();
        mouseTool.addTray();
        Robot robot = new Robot();
        Random random = new Random();

        while (true) {
            int nextMoveIn = random.nextInt(timeToMove) + minTimeToMove;
            if (moveMouseFlag) {
                //get actual mouse position
                Point p = MouseInfo.getPointerInfo().getLocation();
                int x = random.nextInt(MAX_X);
                int y = random.nextInt(MAX_Y);
                robot.mouseMove(p.x + x, p.y + y);
                //System.out.println("x=" + x + " y=" + y + " nextMoveIn=" + nextMoveIn);
            }
            Thread.sleep(nextMoveIn);
        }
    }

    private void addTray() throws AWTException {
        TrayIcon trayIcon = null;
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/favicon.ico"));
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(e.toString());
                    if (e.getActionCommand().equals(ACTION_EXIT)) {
                        System.exit(0);
                    }
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

    private void keyboardExit() {
        /*
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
                new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent e) {
                        System.out.println(e);
                        return false;
                    }
                }
        );

 */
    }
}
