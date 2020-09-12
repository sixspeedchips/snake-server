package io.libsoft.controller;


import io.libsoft.model.Model;
import io.libsoft.view.Arena;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javax.jws.WebParam.Mode;

public class DrawController {

  private final GFXUpdater updater = new GFXUpdater();

  @FXML
  public Arena arena;
  private Model model;

  @FXML
  private void initialize() {
    updater.start();
  }

  public void start() {

  }

  public void setModel(Model model) {
    this.model = model;
  }

  public void stop() {

  }

  private void updateView() {
    arena.render(model);
  }


  private class GFXUpdater extends AnimationTimer {

    @Override
    public void handle(long now) {
      updateView();
    }

  }

}
