import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ground extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Rectangle frame=new Rectangle(50,50,800,600);
        frame.setFill(Color.TRANSPARENT);
        Scene scene =new Scene(pane,100,800);

    }
}
