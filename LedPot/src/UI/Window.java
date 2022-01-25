package UI;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class Window extends JFrame {

	private static final long serialVersionUID = -5195663480394894548L;
	private JComboBox<String> portsBox;
	private JSlider slider;

	public Window(String title) {
		super(title);
		super.setResizable(false);
		super.setSize(400, 140);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setLayout(new GridLayout(2, 3));
		// label
		super.add(new JLabel("   Available Ports:"), 0);
		// ports box
		portsBox = new JComboBox<String>();
		portsBox.setEditable(false);
		portsBox.setEnabled(false);
		super.add(portsBox, 1);
		// label
		super.add(new JLabel("   LED brightness:"), 2);
		// slider
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		slider.setMajorTickSpacing(25);
		slider.setMinorTickSpacing(4);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		super.add(slider, 3);
		super.setVisible(true);
	}

	public int getSliderValue() {
		return slider.getValue();
	}

	public void setPorts(String[] ports) {
		portsBox.setEnabled(true);
		for (int i = 0; i < ports.length; i++) {
			portsBox.addItem(ports[i]);
		}
	}

	public int getSelectedPort() {
		return portsBox.getSelectedIndex();
	}
}
