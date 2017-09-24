package ru.stqa.pft.sandbox;

public class Point1 {
  public double x;
  public double y;
public Point1 (double x, double y){
  this.x=x;
  this.y=y;
  }
  public double distance1(Point1 p){
    return Math.sqrt((this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y));
  }
}
