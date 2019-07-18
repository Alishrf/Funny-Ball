import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ground extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Label label=new Label("Click On The Screen");
        label.setFont(Font.font("Lucida Bright", FontWeight.BOLD, 20));
        label.relocate(400,40);
        pane.getChildren().add(label);
        Rectangle frame=new Rectangle(86,86,800,600);
        frame.setFill(Color.TRANSPARENT);
        frame.setStroke(Color.BLACK);
        pane.getChildren().addAll(frame);
        Scene scene =new Scene(pane,1000,800);
        ArrayList<Ball> balls=new ArrayList<>();
        ArrayList<Circle> circles=new ArrayList<>();
        frame.setOnMouseClicked(event -> {
            Ball ball = new Ball(0, 0, 200, 200, event.getSceneX(), event.getSceneY(), 0.001);
            balls.add(ball);

            Circle circle = new Circle(event.getSceneX(), event.getSceneY(), 20);
            circle.setFill(Color.TRANSPARENT);
            circle.setStroke(Color.BLACK);
            circles.add(circle);
            pane.getChildren().add(circle);

        });
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(() -> {
            moveCircles(circles,balls);
        });
        executorService.shutdown();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void moveCircles(ArrayList<Circle> circles,ArrayList<Ball> balls){
        while (true){
            try {
                Thread.sleep(1);
                for (int i = 0; i <balls.size() ; i++) {
                    Ball b=balls.get(i);
                    String path = "F:/JAVAProject/Funny-Ball/ball_ring.mp3";
                    Media media = new Media(new File(path).toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(media);
                    if ((b.getCurrentX() >= 866 && b.getVelocityXNow()>=0) ||
                            (b.getCurrentX() <= 106 && b.getVelocityXNow()<=0)) {
                        mediaPlayer.play();
                        double vx = -b.getVelocityXNow();
                        double vy = b.getVelocityYNow();
                        b.setTime(0);
                        b.setVelocityX(vx);
                        b.setVelocityY(vy);
                    }
                    if ((b.getCurrentY() >= 666 && b.getVelocityYNow() >= 0) ||
                            (b.getCurrentY() <= 106 && b.getVelocityYNow() <= 0)) {
                        mediaPlayer.play();
                        double vx = b.getVelocityXNow();
                        double vy = -b.getVelocityYNow();
                        System.out.println(vx);
                        System.out.println(vy);
                        b.setTime(0);
                        b.setVelocityX(vx);
                        b.setVelocityY(vy);
                    }
                    double y2 = b.nextY();
                    double x2 = b.nextX();
                    Platform.runLater(() -> {
                        circles.get(balls.indexOf(b)).setCenterY(y2);
                        circles.get(balls.indexOf(b)).setCenterX(x2);
                    });
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
