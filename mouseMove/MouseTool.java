package com.company.tool;

import java.awt.*;
import java.io.IOException;
import java.util.Random;
import lombok.extern.java.Log;

@Log
public class MouseTool {

    //TODO add process, dont open CMD window
    //Add icon in Tray - and option to EXIT app from this

	private final Random random;
	private final Robot robot;
	private final Tools tools;
    private static final boolean MOVE_MOUSE_FLAG = true; //for tests
	private long count = 0;

	public MouseTool() throws AWTException {
		random = new Random();
		robot = new Robot();
		tools = new Tools();
	}

    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		log.info("startuje MouseTool");
        MouseTool mouseTool = new MouseTool();
		mouseTool.startInit();

        while (true) {
			mouseTool.process();
        }
    }

    private void startInit() throws IOException, AWTException {
		tools.addTray();
		tools.openProperties();
	}

    private void process() throws InterruptedException {
		int nextMoveIn = random.nextInt(tools.timeToMove * 1000) + tools.timeToMoveMin * 1000;
		if (MOVE_MOUSE_FLAG) {
			move(nextMoveIn);
		}
		Thread.sleep(nextMoveIn);
	}

    private void move(int nextMoveIn) {
		//get actual mouse position
		Point p = MouseInfo.getPointerInfo().getLocation();
		int x = random.nextInt(tools.moveMaxX) - tools.moveMaxX/2; //move in + and - from current position
		int y = random.nextInt(tools.moveMaxY) - tools.moveMaxY/2; //move in + and - from current position
		robot.mouseMove(p.x + x, p.y + y);
		count++;
		tools.sendMessage("No:" + count + " x=" + x + " y=" + y + " nextMoveIn=" + nextMoveIn);
	}

}
