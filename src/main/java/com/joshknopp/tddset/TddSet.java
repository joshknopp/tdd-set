package com.joshknopp.tddset;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("unchecked")
public class TddSet<E> implements Set<E> {
    private E[] members;

    public TddSet() {
        this.members = (E[]) new Object[]{};
    }

    @Override
    public int size() {
        return members.length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (E member : members) {
            if (member.equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(E e) {
        if(this.contains(e)) {
            return false;
        }
        members = Arrays.copyOf(members, members.length + 1);
        members[members.length - 1] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(!this.contains(o)) {
            return false;
        }
        E[] newArray = (E[]) new Object[members.length - 1];
        int j = 0;
        for (E member : members) {
            if (!member.equals(o)) {
                newArray[j++] = member;
            }
        }
        members = newArray;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = true;
        for(E element : c) {
            result = this.add(element) && result;
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }
    
}
