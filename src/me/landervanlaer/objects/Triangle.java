package me.landervanlaer.objects;

public class Triangle extends Shape {
    Point[] points;


    //CONSTRUCTORS
    public Triangle(Point point0, Point point1, Point point2) {
        this(new Point[]{point0, point1, point2});
    }

    public Triangle(Point[] points) {
        super();
        if(points.length != 3) throw new Error("Initialize Error of class Triangle, points must have a length of 3");
        this.points = points;
    }

    @Override
    public double getArea() {
        final double p = this.getPerimeter() / 2;
        return Math.sqrt(p * (p - this.getSide(0)) * (p - this.getSide(1)) * (p - this.getSide(2)));
    }

    @Override
    public double getPerimeter() {
        double perimeter = 0;
        for(int i = 0; i < 3; i++) perimeter += getSide(i);
        return perimeter;
    }

    /**
     * Get the length of a side
     *
     * @param i The side
     * @return The length of the chosen side
     */
    public double getSide(int i) {
        switch(i) {
            case 0:
                return this.getPoints()[0].getDistanceBetween(this.getPoints()[1]);
            case 1:
                return this.getPoints()[1].getDistanceBetween(this.getPoints()[2]);
            case 2:
                return this.getPoints()[2].getDistanceBetween(this.getPoints()[0]);
            default:
                throw new Error(i + " is not an able side");
        }
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        if(points.length != 3) throw new Error("Initialize Error of class Triangle, points must have a length of 3");
        this.points = points;
    }
}
