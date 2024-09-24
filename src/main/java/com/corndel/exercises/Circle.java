package com.corndel.exercises;

public class Circle implements Shape {
  private double radius;

  Circle(double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public double getArea() {
    return Maths.PI * Math.pow(radius, 2);
  }

  @Override
  public double getPerimeter() {
    return 2 * Maths.PI * radius;
  }
}
