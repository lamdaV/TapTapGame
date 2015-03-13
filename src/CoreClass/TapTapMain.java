package CoreClass;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TapTapMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("TapTap");
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		ArrayList<GameLogistic> gameLogistic = new ArrayList<GameLogistic>();
		
		JPanel mainPanel = new JPanel();
		
		for (int k = 0; k < 3; k++) {
			JPanel subPanel = new JPanel();
			for (int i = 0; i < 3; i++) {
				JButton toAdd = new JButton("?");
				GameLogistic listener = new GameLogistic(toAdd);
				toAdd.addActionListener(listener);
				buttons.add(toAdd);
				gameLogistic.add(listener);
				subPanel.add(toAdd);
			}
			mainPanel.add(subPanel);
		}
		
		JTextField text = new JTextField("Score: ");
		
		EnemyLogistic enemyLogic = new EnemyLogistic(buttons);
		
		FrameUpdater frameUpdater = new FrameUpdater(text, enemyLogic, gameLogistic);
		
		frame.add(mainPanel);
		frame.add(text, BorderLayout.SOUTH);
		
		frame.setSize(new Dimension(250, 200));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}

}
