/*
 * AbstractSet.java - CS 314 Assignment 7
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

/**
 * Students are to complete this class. 
 * Students should implement as many methods as they can using the Iterator
 * from the iterator method and the other methods.
 */
public abstract class AbstractSet<E> implements ISet<E> {

    /**
     * Return a String version of this set. 
     * Format is (e1, e2, ... en)
     * @return A String version of this set.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0) {
            result.setLength(result.length() - seperator.length());
        }

        result.append(")");
        return result.toString();
    }
    /**
     * Determine if item is in this set.
     * <br>pre: item != null
     * @param item element whose presence is being tested.
     * Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
    
        public boolean contains(E obj) {
        for (E val : this) {
            if (val.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet,
     * false otherwise.
     */
    
    public boolean containsAll(ISet<E> otherSet) {
        for (E val : otherSet) {
            if(!this.contains(val)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * A union operation. Add all items of otherSet that
     * are not already present in this set to this set.
     * @param otherSet != null
     * @return true if this set changed as a result of this operation,
     * false otherwise.
     */Ï
    
    public boolean addAll(ISet<E> otherSet) {
        boolean isChanged = false;
        for (E val : otherSet) {
            if (this.add(val)) {
                isChanged = true;
            }
        }
        return isChanged;
    }

    /**
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     */
    public int size() {
        int size = 0;
        for (E val : this) {
            size++;
        }
        return size;
    }

    /**
     * Make this set empty.
     * <br>pre: none
     * <br>post: size() = 0
     */
    public void clear() {
        for (E val : this) {
            remove(val);
        }
    }

    /**
     * Remove the specified item from this set if it is present.
     * pre: item != null
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation,
     * false otherwise
     */
    public boolean remove(E item) {
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            if (it.next().equals(item)) {
                it.remove();
            }
        }
    }

    /**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set
     * @return true if other is a Set and has the same elements as this set
     */
    public boolean equals(Object other) {
        if (other instanceof ISet) {
            Iset<E> otherSet = (ISet)(other);
            return this.containsAll(otherSet) && otherSet.containsAll(this);
        }
    }
    

}
