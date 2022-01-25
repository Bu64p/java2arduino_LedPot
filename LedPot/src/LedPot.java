
import SerialCom.Core;
import UI.Window;

public class LedPot {
	public static void main(String[] args) throws InterruptedException {
		Window display = new Window("java2arduino LedPot");
		Core Arduino = new Core(9600);
		display.setPorts(Arduino.getPorts());
		Arduino.setPort(display.getSelectedPort());
		(new Thread() {
			public void run() {
				while (Arduino.getPortStatus()) {
					try {
						Arduino.send(display.getSliderValue());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
