import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		WordDatabase wd = new WordDatabase();
		wd.load("moviereviews.txt");
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Enter a review or 'exit'.");
			String input = scan.nextLine();
			if(input.equals("exit")) {
				System.out.println("Exited.");
				System.exit(0);
			} else {
				double score = wd.getScore(input);
				score = Math.floor(score * 100) / 100;
				System.out.println("You gave a score of " + score);
			}
		}
	}
	
}
