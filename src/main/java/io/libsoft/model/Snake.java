package io.libsoft.model;

import io.libsoft.util.Props;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Snake implements Entity, Drawable {

  private static final Random random = new Random();
  private final Deque<Point> body = new LinkedList<>();
  private final int size = 5;
  private Direction direction;
  {
    body.add(new Point(random.nextInt((int) Props.get().getWidth()), random.nextInt(
        (int) Props.get().getHeight())));
    direction = Direction.UP;
  }

  @Override
  public void step() {

  }

  public void render(GraphicsContext gc) {
    gc.setFill(Color.AZURE);
    double size = Props.get().getSize();
    for (Point point : body) {
      gc.fillRect(point.getX()-size/2, point.getY()-size/2, size, size);
    }
  }


}
