package org.example;

class Circle implements Calculatable {
    double radius;
    String fillColor;
    String borderColor;
    Circle(double radius, String fillColor, String borderColor)
    {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double calculatePerimeter()
    {
        return 2 * Math.PI * radius;
    }
    public double calculateArea()
    {
        return Math.PI * radius * radius;
    }
    public void figureInfo()
    {
        System.out.printf("Фигура: круг, периметр: %f, площадь: %f, цвет заливки: %s, цвет границы: %s\n",
                calculatePerimeter(), calculateArea(), fillColor, borderColor);
    }
}