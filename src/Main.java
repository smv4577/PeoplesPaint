import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	private static double windowWidth;
	private static double windowHeight;
	private Container cp;
	private JPanel drawingPanel;
	private JColorChooser colorSwatch;
	private JPanel drawButtons;
	private eventHandler cl = new eventHandler();

	/**
	 * Creates window
	 */
	public static void main(String[] args) {
		Main drawFrame = new Main();
		windowDim = Toolkit.getDefaultToolkit().getScreenSize();
		windowWidth = windowDim.getWidth();
		windowHeight = windowDim.getHeight();
		drawFrame.setVisible(true);
		drawFrame.setSize(windowDim);
		drawFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		drawFrame.setTitle("Taylor's Draw Program");

	}

	/**
	 * 
	 */
	public Main() {
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
		drawingPanel = makeDrawingPanel();
		cp.add(drawingPanel, BorderLayout.CENTER);
		colorSwatch = makeColors(drawingPanel);
		cp.add(colorSwatch, BorderLayout.PAGE_END);
		colorSwatch.getSelectionModel().addChangeListener(cl);
		drawButtons = buildDrawPanel();
		cp.add(drawButtons, BorderLayout.WEST);

	}

	/**
	 * 
	 * @return
	 */
	private JPanel buildDrawPanel() {
		JPanel dp = new JPanel();
		dp.setLayout(new GridLayout(0,1));
		dp.setSize(new Dimension((int) windowWidth, (int) windowHeight));
		
		JButton drawButton = new JButton("Free Draw");
		drawButton.addMouseListener(cl);
		dp.add(drawButton);
		
		JButton lineButton = new JButton("Line");
		lineButton.addMouseListener(cl);
		dp.add(lineButton);
		
		JButton recButton = new JButton("Rectangle");
		lineButton.addMouseListener(cl);
		dp.add(recButton);
		
		JButton eButton = new JButton("Erase");
		lineButton.addMouseListener(cl);
		dp.add(eButton);
		
		JButton fillButton = new JButton("Fill");
		dp.addMouseListener(cl);
		dp.add(fillButton);

		return dp;
	}

	/**
	 * 
	 * @author tln86
	 *
	 */
	private class eventHandler implements ChangeListener, MouseListener {

		@Override
		public void stateChanged(ChangeEvent arg0) {
			Color newColor = colorSwatch.getColor();
			drawingPanel.setBackground(newColor);

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
