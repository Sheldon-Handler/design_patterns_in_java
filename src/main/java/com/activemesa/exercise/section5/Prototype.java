package com.activemesa.exercise.section5;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }


    public Line deepCopy() {
        // todo
        Point point1 = new Point(start.x, start.y);
        Point point2 = new Point(end.x, end.y);

        Line line = new Line(point1, point2);
        return line;

    }
}
