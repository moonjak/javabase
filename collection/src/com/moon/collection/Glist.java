package com.moon.collection;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Glist<E> implements Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}
