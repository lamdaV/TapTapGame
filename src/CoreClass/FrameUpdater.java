package CoreClass;
import java.util.ArrayList;

import javax.swing.JTextField;


public class FrameUpdater implements Runnable {
	
	private EnemyLogistic enemy;
	private ArrayList<GameLogistic> game;
	private Thread frameThread;
	private JTextField textField;
	
	public FrameUpdater (JTextField textField, EnemyLogistic enemy, ArrayList<GameLogistic> gameLogistic) {
		this.textField = textField;
		this.enemy = enemy;
		this.game = gameLogistic;
		this.frameThread = new Thread(this);
		this.frameThread.start();
	}
	
	public int computeScore() {
		int total = 0;
		for (int i = 0; i < this.game.size(); i++) {
			total = total + this.game.get(i).getScore();
		}
		
		return total;
	}

	@Override
	public void run() {
		String text = this.textField.getText();
		while (true) {
			int score = computeScore();
			this.textField.setText(text + " " + score);
			if (this.enemy.getLose()) {
				this.textField.setText(text + " " + score + " " + "YOU LOSE");
				return;
			}
		}
	}
	
	
}
