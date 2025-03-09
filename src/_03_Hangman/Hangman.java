package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	JFrame mainFrame = new JFrame("Hangman!");
	JPanel panel = new JPanel();
	JLabel guessLabel = new JLabel();
	JLabel livesLabel = new JLabel("Lives: ");

	String[] guessText;
	String currentWord;
	int lives = 5;

	Stack<String> wordList = new Stack<String>();

	static Hangman g = new Hangman();

	public static void main(String[] args) {
		g.wordListSetup();
		g.windowSetup();
		g.wordSetup();

	}

	public void wordListSetup() {
		// get length
		String wordLengthString = JOptionPane.showInputDialog(null, "How many words? (#)");
		int wordLength = Integer.parseInt(wordLengthString);
		// set list
		for (int x = 0; x < wordLength; x++) {
			String nextWord = Utilities.readRandomLineFromFile("dictionary.txt");

			// check duplicates
			if (!wordList.contains(nextWord)) {
				wordList.push(nextWord);
			}
		}
	}

	public void wordSetup() {
		if (wordList.size()>0) {
			currentWord = wordList.pop();
		} else {
			endGame();
		}
		
		guessText = new String[currentWord.length()];

		for (int x = 0; x < guessText.length; x++) {
			guessText[x] = "_ ";
		}

		update();

		System.out.println(currentWord);
	}

	public void windowSetup() {
		mainFrame.add(panel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(panel);
		panel.add(livesLabel);
		panel.add(guessLabel);
		mainFrame.addKeyListener(this);
		mainFrame.setVisible(true);
	}

	public void update() {
		if (lives > 0) {

			String guessString = "";
			for (String x : guessText) {
				guessString += x;
			}
			guessLabel.setText(guessString);

			if (guessString.equals(currentWord)) {
				wordSetup();
				
			}
			
			// set lives text
			livesLabel.setText("Lives: " + lives);
			mainFrame.pack();

		} else {
			endGame();
		}
	}
	
	public void endGame () {
		mainFrame.setVisible(false);
		int selected;
		
		if (lives>0) {
			selected = JOptionPane.showConfirmDialog(null, "Congratulations! You've won! Would you you like to play again?");
		} else {
			selected = JOptionPane.showConfirmDialog(null, "You've Lost. Would you you like to play again?");
		}
		
		if (selected == 0) {
			g.wordListSetup();
			g.windowSetup();
			g.wordSetup();
			mainFrame.setVisible(true);
			lives = 5;
		} 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char pressed = e.getKeyChar();
		char[] word = currentWord.toCharArray();

		System.out.println(pressed);

		boolean found = false;
		for (int x = 0; x < word.length; x++) {
			if (word[x] == pressed) {
				guessText[x] = pressed + "";
				found = true;
			}
		}

		if (!found) {
			lives--;
		}

		update();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
