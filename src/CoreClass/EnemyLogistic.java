package CoreClass;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

public class EnemyLogistic implements Runnable {
	private ArrayList<JButton> buttons;
	private Thread thread;
	private boolean lose;
	
	public EnemyLogistic(ArrayList<JButton> buttons) {
		this.buttons = buttons;
		this.thread = new Thread(this);
		this.thread.start();
		this.lose = false;
	}
	
	public boolean checkBoardCondition() {
		for (int i = 0; i < this.buttons.size(); i++) {
			if (!(this.buttons.get(i).getText().equals("X"))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean getLose() {
		return this.lose;
	}

	@Override
	public void run() {
		Random randomNumberGenerator = new Random();
		int timeDeductor = 0;
		
		while (true) {
			int buttonToChange = randomNumberGenerator.nextInt(this.buttons.size());
			this.buttons.get(buttonToChange).setText("X");
			
			if (checkBoardCondition()) {
				this.lose = true;
				return;
			}
			
			try {
				if (1000 - timeDeductor <= 200) {
					Thread.sleep(200);
				} else {
					Thread.sleep(1000 - timeDeductor);
					timeDeductor = timeDeductor + 10;
				}
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}

}
