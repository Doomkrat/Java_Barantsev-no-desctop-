package ru.stqa.pft.sandbox;

public class Point1 {
  public double x;
  public double y;

  public static double distance1(Point1 p1, Point1 p2){
    double xdif=p1.x-p2.x;
    double ydif=p1.y-p2.y;
    return Math.sqrt((xdif*xdif + ydif*ydif));
  }
}
