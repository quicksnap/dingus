import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import java.util.Properties;

public class HelloDungeon {

	private static final int screenWidth = 80;
	private static final int screenHeight = 25;

	public static void main(String[] args) {
		Properties text = new Properties();
		text.setProperty("fontSize", "20");
		text.setProperty("font", "Courier");

		ConsoleSystemInterface csi = null;
		try {
			csi = new WSwingConsoleInterface("Java roguelike - planting a seed.", text);
		}
		catch (ExceptionInInitializerError eiie) {
			System.out.println("*** Error: Swing Console Box cannot be initialized. Exitting...");
			eiie.printStackTrace();
			System.exit(-1);
		}

		csi.print(0,0, "Hello! Welcome to Dingus!", CSIColor.COSMIC_LATTE);
		csi.refresh();

		int x = screenWidth / 2;
		int y = screenHeight / 2;
		boolean stop = false;

		while(!stop) {
			csi.cls();
			csi.print(x,y, "@", CSIColor.WHITE);
			csi.refresh();
			CharKey dir = csi.inkey();

			if (dir.isUpArrow()&& (y-1 >= 0)) {
				y--;
			}
			if (dir.isDownArrow()&& (y+1 < screenHeight)) {
				y++;
			}
			if (dir.isLeftArrow()&& (x-1 >= 0)) {
				x--;
			}
			if (dir.isRightArrow()&& (x+1 < screenWidth)) {
				x++;
			}
			if (dir.code == CharKey.Q) {
				stop = true;
			}
		}
	}
}