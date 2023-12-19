package org.example.model;

import org.example.exceptions.*;
import org.example.interfaces.IIntegerList;

import java.util.Arrays;

public class IntegerList implements IIntegerList {
    private final Integer[] list;
    private int size;

    public IntegerList() {
        list = new Integer[10];
    }

    public IntegerList(int size) {
        list = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        list[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateIndex(index);
        validateItem(item);

        if (index == size) {
            list[size++] = item;
            return item;
        }

        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = item;
        size++;

        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        list[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);

        if (index == -1) {
            throw new ElementNotFoundException();
        }

        if (index != size) {
            System.arraycopy(list,index+1,list,index, size - (index+1));
        }

        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);

        Integer item = list[index];

        if (index != size) {
            System.arraycopy(list,index+1,list,index, size - (index+1));
        }

        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i > 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return list[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(list, size);
    }

    private void validateSize() {
        if (size == list.length) {
            throw new ListIsFullException();
        }
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException();
        }
    }
}
