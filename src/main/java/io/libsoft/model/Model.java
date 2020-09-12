package io.libsoft.model;

import io.libsoft.util.Props;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Model implements Runnable {

  private final ScheduledExecutorService looper = Executors.newScheduledThreadPool(2);
  private final Map<UUID, Entity> entities = new HashMap<>();
  private final Map<UUID, Drawable> drawables = new HashMap<>();
  private final double width = Props.get().getWidth();
  private final double height = Props.get().getHeight();


  public void start() {
    looper.scheduleAtFixedRate(this, 0, 1000, TimeUnit.MILLISECONDS);
  }


  @Override
  public void run() {
    entities.forEach((uuid, entity) -> entity.step());
  }


  public UUID addMouse(String userName) {
    UUID uuid = UUID.nameUUIDFromBytes(userName.getBytes());
    Entity entity = new Mouse();
    entities.put(uuid, entity);
    drawables.put(uuid, (Drawable) entity);
    return uuid;
  }


  public UUID addSnake(String userName) {
    UUID uuid = UUID.nameUUIDFromBytes(userName.getBytes());
    Entity entity = new Snake();
    entities.put(uuid, entity);
    drawables.put(uuid, (Drawable) entity);
    return uuid;
  }


  public Collection<Drawable> getDrawables() {
    return drawables.values();
  }
}


