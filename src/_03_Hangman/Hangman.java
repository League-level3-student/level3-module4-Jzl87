package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	static JFrame mainFrame = new JFrame("Hangman!");
	static JPanel panel = new JPanel();
	static JLabel guessLabel = new JLabel();

	static String currentWord;

	static Stack<String> wordList = new Stack<String>();

	public static void main(String[] args) {
		wordListSetup();
		windowSetup();
		wordSetup();

	}

	public static void wordListSetup() {
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

	public static void wordSetup() {
		currentWord = wordList.pop();
		String guessLabelText = "";
		for (int x = 0; x < currentWord.length(); x++) {
			guessLabelText += " _";
		}
		guessLabel.setText(guessLabelText);
		mainFrame.pack();

	}

	public static void windowSetup() {
		mainFrame.add(panel);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(panel);
		panel.add(guessLabel);
		mainFrame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		//USE THIS METHOD FOR THE REST OF THE PROGRAM
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
