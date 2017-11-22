import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author tln86
 *
 */
public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Dimension windowDim;
	private Container cp;
	private JPanel drawingPanel;
	private JColorChooser colorSwatch;

	/**
	 * Creates window
	 */
	public static void main(String[] args) {
		Main drawFrame = new Main();
		windowDim = Toolkit.getDefaultToolkit().getScreenSize();
		drawFrame.setVisible(true);
		drawFrame.setSize(windowDim);
		drawFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		drawFrame.setTitle("Taylor's Draw Program");

	}

	public Main() {
		eventHandler cl = new eventHandler();
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
		drawingPanel = makeDrawingPanel();
		cp.add(drawingPanel, BorderLayout.CENTER);
		colorSwatch = makeColors(drawingPanel);
		cp.add(colorSwatch, BorderLayout.PAGE_END);
		colorSwatch.getSelectionModel().addChangeListener(cl);

	}

	/**
	 * 
	 * @author tln86
	 *
	 */
	private class eventHandler implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent arg0) {
			Color newColor = colorSwatch.getColor();
			drawingPanel.setBackground(newColor);

		}

	}

	/**
	 * 
	 * @param drawPanel
	 * @return
	 */
	private JColorChooser makeColors(JPanel drawPanel) {
		JColorChooser cc = new JColorChooser(drawPanel.getForeground());
		cc.setPreviewPanel(new JPanel());
		return cc;
	}

	/**
	 * 
	 * @return
	 */
	private JPanel makeDrawingPanel() {
		JPanel drawPanel = new JPanel();
		drawPanel.setBackground(Color.yellow);
		return drawPanel;
	}

}
