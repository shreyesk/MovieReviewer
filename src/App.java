import javafx.application.Application;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class App extends Application {
	
	private View v;
	private WordDatabase wd;
	
	public App() {
		v = new View();
		wd = new WordDatabase();
		wd.load("moviereviews.txt");
	}

	@Override
	public void start(Stage s) throws Exception {
		v.setStage(s);
		TextArea ta = v.getInput();
		ta.setOnKeyTyped(e -> {
			double score = wd.getScore(ta.getText());
			score = Math.floor(score * 100) / 100;
			v.setScore(score);
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
