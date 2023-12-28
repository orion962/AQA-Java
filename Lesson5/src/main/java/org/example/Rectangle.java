package org.example;

class Rectangle implements Calculatable {
    double length;
    double width;
    String fillColor;
    String borderColor;

    Rectangle(double length, double width, String fillColor, String borderColor) {
        this.length = length;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public double calculateArea() {
        return length * width;
    }

    public void figureInfo() {
        System.out.printf("Фигура: прямоугольник, периметр: %f, площадь: %f, цвет заливки: %s, цвет границы: %s\n",
                calculatePerimeter(), calculateArea(), fillColor, borderColor);
    }
}