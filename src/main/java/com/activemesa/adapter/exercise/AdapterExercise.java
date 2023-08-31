package com.activemesa.adapter.exercise;

import com.activemesa.structural.bridge.VectorRenderer;

public class Square
{
    public int side;

    public Square(VectorRenderer side)
    {
        this.side = side;
    }
}

interface Rectangle
{
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}

class SquareToRectangleAdapter implements Rectangle
{
    private Square square;
    public SquareToRectangleAdapter(Square square)
    {
        this.square = square;
    }

    @Override
    public int getWidth() {
        return square.side;
    }

    @Override
    public int getHeight() {
        return square.side;
    }

    @Override
    public int getArea() {
        return Rectangle.super.getArea();
    }
}
