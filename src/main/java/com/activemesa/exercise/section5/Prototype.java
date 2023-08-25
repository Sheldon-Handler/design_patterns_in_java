package com.activemesa.exercise.section5;


import org.apache.commons.lang3.SerializationUtils;

class Point
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy() throws CloneNotSupportedException {
        // todo
        Line line = new Line(start, end);
        Line line1 = SerializationUtils.roundtrip(line);
        return line;

    }
}
