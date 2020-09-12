package io.libsoft.model;

public class Point {

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  private double x,y;

}
