package multconst;

import javax.swing.JFrame;
import java.awt.*;

public class MultConst {
	public void frame2() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = new Dimension(500, 400);
		
		WindowManager window = new WindowManager();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize((int)windowSize.getWidth(), (int)windowSize.getHeight());
		window.setVisible(true);
		window.setMinimumSize(windowSize);
		window.setResizable(true);
		window.setLocationRelativeTo(null);
	}
}
