package com.example.imagetest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private ImageView imageView;

    @FXML
    private Label textImg;

    @FXML
    private Button next;

    @FXML
    private Button preview;

    Timeline timer = new Timeline();
    ConcreteAggregate foto = new ConcreteAggregate("src/main/resources/");

    Iterator iterator = foto.getIterator();


    @FXML
    public void onHelloButtonClick() {
        int delay = 2;
        timer = new Timeline();
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.getKeyFrames().add(new KeyFrame(Duration.seconds(delay), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onNextClick();
            }
        }));
        timer.play();
    }
    @FXML
    public void onLastClick(){
        if (iterator.hasPreview()) {
            imageView.setImage(iterator.preview());
            textImg.setText(iterator.getPathImg());
        }
    }
    @FXML
    public void onNextClick(){
        if (iterator.hasNext()) {
            imageView.setImage(iterator.next());
            textImg.setText(iterator.getPathImg());
        }
    }
    @FXML
    public void onStopClick(){
        timer.stop();
        timer.getKeyFrames().clear();
    }

}