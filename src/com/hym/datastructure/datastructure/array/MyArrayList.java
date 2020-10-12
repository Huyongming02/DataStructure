package com.hym.datastructure.datastructure.array;

import java.util.Arrays;

public class MyArrayList<T> {
    /**
     * 默认大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 存放元素的数组
     */
    Object[] elementData;

    private int size;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    /**
     * 添加
     *
     * @param t
     * @return
     */
    public boolean add(T t) {
        checkSize(size + 1);
        elementData[size++] = t;
        return true;
    }

    /**
     * 添加到某个位置上
     *
     * @param index
     * @param t
     * @return
     */
    public boolean add(int index, T t) {
        rangeCheckForAdd(index);
        checkSize(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = t;
        size++;
        return true;
    }

    /**
     * 替换某个位置的元素
     *
     * @param index
     * @param t
     * @return
     */
    public boolean set(int index, T t) {
        checkIndex(index);
        elementData[index] = t;
        return true;
    }

    /**
     * 删除索引位置的元素
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndex(index);
        T t = (T) elementData[index];
        size--;
        System.arraycopy(elementData, index + 1, elementData, index,
                size - index);
        return t;
    }

    /**
     * 删除某个元素
     *
     * @param t
     * @return
     */
    public boolean remove(T t) {
        if (t == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (t.equals(elementData[i])) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否包含某个元素
     *
     * @param t
     * @return
     */
    public boolean contains(T t) {
        if (t == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (t.equals(elementData[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elementData[index];
    }

    private void checkSize(int addSize) {
        if (addSize == elementData.length) {
            resize((int) (size * 1.5));
        }
    }

    private void resize(int capacity) {
        elementData = Arrays.copyOf(elementData, capacity);
    }

    private void rangeCheckForAdd(int index) {
        if (index >= 0 && index <= size) {
            return;
        }
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkIndex(int index) {
        if (index >= 0 && index < size) {
            return;
        }
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
