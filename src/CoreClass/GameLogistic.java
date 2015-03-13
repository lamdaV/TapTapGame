package CoreClass;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class GameLogistic implements ActionListener{
	private JButton button;
	private int score;
	
	public GameLogistic(JButton button) {
		this.button = button;
		this.score = 0;
	}
	
	public int getScore() {
		return this.score;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!(this.button.getText().equals("?"))) {
			this.button.setText("?");
			this.score = this.score + 100;
		}
	}
}

