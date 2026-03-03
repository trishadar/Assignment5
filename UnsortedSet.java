/*
 * UnsortedSet.java - CS 314 Assignment 7
 *
 * By signing my/our name(s) below, I/we affirm that this assignment is my/our
 * own work. I/we have neither given nor received unauthorized assistance on
 * this assignment.
 *
 * Name 1:
 * Email address 1:
 * UTEID 1:
 *
 * Name 2:
 * Email address 2:
 * UTEID 2:
 */

import java.util.Iterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.IllegalStateException;

/**
 * A simple implementation of an ISet.
 * Elements are not in any particular order.
 * Students are to implement methods that were not implemented in AbstractSet
 * and override methods that can be done more efficiently.
 * An ArrayList must be used as the internal storage container.
 *
 */
public class UnsortedSet<E> extends AbstractSet<E> {

    private ArrayList<E> myCon;

    /**
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     */
    public int size() {
        return myCon.size();
    }
    
    /**
     * Return an Iterator object for the elements of this set.
     * pre: none
     * @return an Iterator object for the elements of this set
     */
    public Iterator<E> iterator() {
        return new UnsortedSetIterator();
    }
    
    private class UnsortedSetIterator implements Iterator<E> {

        private int indexOfNext;
        private boolean canRemove;

        public boolean hasNext() {
            return indexOfNext < size();
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Violates precondition" + 
                "hasNext() == true");
            }
            canRemove = true;
            return myCon.get(indexOfNext++);
        }

        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("Violates precondition" + 
                "canRemove == true");
            }
            myCon.remove(indexOfNext - 1);
            canRemove = false;
        }
    /**
     * Add an item to this set.
     * <br> item != null
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation,
     * false otherwise.
     */
    public boolean add(E item) {
        boolean isChanged = false;
        if(!contains(item)) {
            myCon.add(item);
            isChanged = true;
        }
        return isChanged;
    }

    }
    

}