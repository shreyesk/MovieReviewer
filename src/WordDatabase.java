import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class WordDatabase {

	private HashMap<String, int[]> byWord;
	
	public WordDatabase() {
		byWord = new HashMap<>();
	}
	
	public void addScore(String word, int score) {
		word = word.toLowerCase();
		if(!byWord.containsKey(word)) {
			byWord.put(word, new int []{score, 1});
		} else {
			int[] data = byWord.get(word);
			data[0] = data[0] + score;
			data[1] = data[1] + 1;
		}
	}
	
	public double getScore(String text) {
		text = text.toLowerCase();
		double wordSum = 0;
		int numOfWords = 0;
		String[] parts = text.split(" ");
		for(String word : parts) {
			if(byWord.containsKey(word)) {
				wordSum += getAvgScore(word);
				numOfWords += 1;
			}
		}
		return wordSum / numOfWords;
	}
	
	private double getAvgScore(String word) {
		word = word.toLowerCase();
		int[] data = byWord.get(word);
		double avgScore = (data[0] + 0.0) / data[1];
		return avgScore;
	}
	
	public void load(String fileName) {
		InputStream is;
		is = this.getClass().getResourceAsStream(fileName);
		Scanner in = new Scanner(is);
		while(in.hasNextLine()) {
			String line = in.nextLine();
			String[] parts = line.split(" ");
			int score = Integer.parseInt(parts[0]);
			for(int i = 1; i < parts.length; i++) {
				addScore(parts[i], score);
			}
		}
		in.close();
	}
	
	@Override
	public String toString() {
		String words = "";
		for(String word : byWord.keySet()) {
			double avgScore = getAvgScore(word);
			words += word + " " + avgScore + "\n";
		}
		return words;
	}
}
