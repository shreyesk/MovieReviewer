import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {

	private Scene s;
	private Text title;
	private TextArea input;
	private Text score;
	
	public View() {
		BorderPane bp = new BorderPane();
		s = new Scene(bp, 600, 400, Color.ALICEBLUE);
		bp.setStyle("-fx-background-color: #ffb2b2;");
		bp.setPadding(new Insets(20));
		
		title = new Text("Movie Reviewer");
		title.setFont(new Font(30));
		BorderPane.setAlignment(title, Pos.CENTER);

		input = new TextArea();
		score = new Text("Score");
		score.setFont(new Font(15));
		HBox content = new HBox();
		content.getChildren().add(input);
		content.getChildren().add(score);
		content.setAlignment(Pos.CENTER);
		content.setSpacing(30);
		content.setPadding(new Insets(20));
		
		bp.setTop(title);
		bp.setCenter(content);
	}
	
	public TextArea getInput() {
		return input;
	}
	
	public void setScore(double d) {
		score.setText(d + "");
	}
	
	public void setStage(Stage s) {
		s.setScene(this.s);
		s.show();
	}
	
}
