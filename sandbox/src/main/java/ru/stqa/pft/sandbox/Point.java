package ru.stqa.pft.sandbox;

public class Point {

  public double x;
  public double y;


  public static void main(String args[]) {

    Point p1 = new Point();

    Point p2 = new Point();

    p1.x = 10;

    p1.y = 20;

    p2.x = 25;

    p2.y = 35;


    System.out.println("First point coordinates : x1 = " + p1.x + " у1 = " + p1.y);
    System.out.println("First point coordinates : x2 = " + p2.x + " у2 = " + p2.y);
    System.out.println("Distance between points = " + distance(p1,p2) );

  }
  public static double distance(Point p1, Point p2){

    return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));

  }
}










