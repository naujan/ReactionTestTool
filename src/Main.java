import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException {

        System.out.println("Initializing...");

        Robot mouse = new Robot();
        Color targetColor = new Color(75, 219, 106); // RGB VALUE OF THE CLICK SCREEN.
        int roundCounter = 1;

        System.out.println("ReactionTestTool [1.0.0]");
        System.out.println("Close console to stop the script.");
        System.out.println("Script ready! Waiting for targetColor...\n");

        while (roundCounter <= 5) {

            Point point = MouseInfo.getPointerInfo().getLocation();
            Color currentColor = mouse.getPixelColor(point.x, point.y);

            if (currentColor.equals(targetColor)) {
                System.out.println("TEST #" + roundCounter);
                System.out.println("Color change detected!");
                mouse.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                mouse.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);

                Thread.sleep(50);

                System.out.println("Clicked, waiting for next...\n");
                mouse.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                mouse.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                roundCounter++;
                Thread.sleep(10);
            }
            Thread.sleep(10);

        }

        System.out.println("Test finished.");
    }

}
