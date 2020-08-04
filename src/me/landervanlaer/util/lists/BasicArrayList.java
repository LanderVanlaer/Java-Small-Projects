package me.landervanlaer.util.lists;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

@SuppressWarnings("unchecked") //Removing warning: Unchecked cast: 'java.lang.Object' to 'E'

public class BasicArrayList<E> implements List<E>, Serializable {
    private transient Object[] list = new Object[]{};


    public boolean add(E e) {
        Object[] newList = new Object[this.size() + 1];
        System.arraycopy(this.getList(), 0, newList, 0, this.size());
//        for(int i = 0; i < this.size(); i++) {
//            newList[i] = this.getList()[i];
//        }
        newList[newList.length - 1] = e;
        this.setList(newList);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        BasicArrayList<?> that = (BasicArrayList<?>) o;
        return Arrays.equals(getList(), that.getList());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getList());
    }

    @Override
    public String toString() {
        return "BasicArrayList{" +
                "list=" + Arrays.toString(list) +
                '}';
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        for(E e : this.getList()) action.accept(e);
    }

    private void checkIndex(int i) {
        Objects.checkIndex(i, this.size());
    }

    @Override
    public boolean remove(Object o) {
        int i = this.indexOf(o);
        if(i >= 0) {
            this.remove(i);
            return true;
        } else return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] array = c.toArray();
        for(Object o : array)
            if(!this.contains(o)) return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] array = c.toArray();
        for(Object o : array)
            this.add((E) o);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        this.checkIndex(index);
        Object[] e = c.toArray();
        Object[] array = new Object[this.size() + e.length];
        for(int i = 0; i < index; i++) array[i] = this.get(i);
        System.arraycopy(e, index, array, index, index + e.length - index);
//        for(int i = index; i < index + e.length; i++) array[i] = e[i];
        for(int i = index + e.length; i < array.length; i++) array[i] = this.get(i - e.length);
        this.setList(array);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] array = c.toArray();
        boolean b = false;
        for(Object e : array) {
            b = b || this.remove(e);
        }
        return b;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Object[] elements = c.toArray();
        List<Object> list = new BasicArrayList<>();
        for(Object e : elements) if(this.contains(e)) list.add(e);
        boolean b = this.equals(list);
        this.setList(list.toArray());
        return b;
    }

    @Override
    public void clear() {
        this.setList(new Object[0]);
    }

    public void addFirst(E e) {
        Object[] newList = new Object[this.size() + 1];
        newList[0] = e;
        System.arraycopy(this.getList(), 0, newList, 1, this.size());
//        for(int i = 0; i < this.size(); i++) {
//        }
        this.setList(newList);
    }

    public E remove(int i) {
        this.checkIndex(i);
        Object[] newList = new Object[this.size() - 1];
        int index = 0;
        E e = null;
        for(int j = 0; j < this.size(); j++) {
            if(j != i)
                newList[index++] = this.get(i);
            else
                e = this.get(i);
        }
        this.setList(newList);
        return e;
    }

    @Override
    public int indexOf(Object o) {
        if(!this.contains(o)) return -1;
        for(int i = 0; i < this.size(); i++) {
            if(this.get(i).equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(!this.contains(o)) return -1;
        int j = -1;
        for(int i = 0; i < this.size(); i++) {
            if(this.get(i).equals(o)) j = i;
        }
        return j;
    }

    //TODO listIterator()
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    //TODO listIterator(int index)
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        this.checkIndex(fromIndex);
        this.checkIndex(toIndex);
        List<E> list = new BasicArrayList<>();
        for(int i = fromIndex; i < toIndex; i++) {
            list.add(this.get(i));
        }
        return list;
    }

    public E first() {
        return this.get(0);
    }

    public E last() {
        return this.get(this.size() - 1);
    }

    public int size() {
        return this.getList().length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(E e : this.getList())
            if(e.equals(o)) return true;
        return false;
    }

    //TODO iterator()
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return this.getList();
    }

    //TODO toArray()
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public int length() {
        return this.size();
    }

    public E get(int i) {
        this.checkIndex(i);
        return this.getList()[i];
    }

    public E set(int i, E e) {
        this.checkIndex(i);
        final E prev = this.get(i);
        this.getList()[i] = e;
        return prev;
    }

    @Override
    public void add(int index, E element) {
        Objects.checkIndex(index, this.size());
        Object[] newList = new Object[this.size() + 1];
        System.arraycopy(this.getList(), 0, newList, 0, index);
        newList[index] = element;
        ++index;
        System.arraycopy(this.getList(), index - 1, newList, index, newList.length - index);

//        for(int i = 0; i < index; i++)
//            newList[i] = this.getList()[i];
//        for(int i = index; i < newList.length; i++)
//            newList[i] = this.getList()[i - 1];

        this.setList(newList);
    }

    private E[] getList() {
        return (E[]) this.list;
    }

    private void setList(Object[] list) {
        this.list = list;
    }


}
