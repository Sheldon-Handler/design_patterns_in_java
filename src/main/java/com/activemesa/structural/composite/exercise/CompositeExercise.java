package com.activemesa.structural.composite.exercise;

import java.util.*;
import java.util.function.Consumer;

interface ValueContainer extends Iterable<Integer> {}

class SingleValue implements ValueContainer
{
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value)
    {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        ValueContainer.super.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return ValueContainer.super.spliterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{
}


class MyList extends ArrayList<ValueContainer>
{
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c)
    {
        super(c);
    }

    public int sum()
    {
        int sum = 0;
        // todo
        for (int i = 0; i < MyList.this.size(); i++) {
           sum += MyList.this.indexOf(i);
        }
    }
}