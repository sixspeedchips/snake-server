package io.libsoft.view;

import io.libsoft.model.Drawable;
import io.libsoft.model.Model;
import io.libsoft.util.Props;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Arena extends Canvas {


  private final GraphicsContext gc = getGraphicsContext2D();

  {
    setWidth(Props.get().getWidth());
    setHeight(Props.get().getHeight());
    gc.setFill(Color.GREY);
    gc.fillRect(0, 0, Props.get().getHeight(), Props.get().getWidth());

  }


  public void render(Model model) {
    for (Drawable drawable : model.getDrawables()) {
      drawable.render(gc);
    }
  }
}
