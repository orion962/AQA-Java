package org.example;

class Triangle implements Calculatable {
    double a;
    double b;
    double c;
    String fillColor;
    String borderColor;

    Triangle(double a, double b, double c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public double calculatePerimeter() {
        return (a + b + c);
    }

    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public void figureInfo() {
        System.out.printf("Фигура: треугольник, периметр: %f, площадь: %f, цвет заливки: %s, цвет границы: %s\n",
                calculatePerimeter(), calculateArea(), fillColor, borderColor);
    }
}