package schule.taxis;

/**
 * Some people call it deque, we call it Taxistand... xD
 */
public class Taxistand {
    public Taxi first;

    public Taxistand() {
        this.first = null;
    }

    /**
     * @return How many taxis are in the lot.
     */
    public int size() {
        int result;
        if (first != null) {
            result = first.size();
        } else {
            result = 0;
        }
        return result;
    }

    /**
     * @return How many seats are available
     */
    public int seatCount() {
        int result;
        if (first != null) {
            result = first.seatCount();
        } else {
            result = 0;
        }
        return result;
    }

    /**
     * @param taxi The taxi to 'push back' (to add to
     *             the list as the new last element)
     */
    public void pushBack(Taxi taxi) {
        if (first != null) {
            first.pushBack(taxi);
        } else {
            first = taxi;
        }
    }

    /**
     * @param taxi The taxi to 'push front' (to add to
     *             the list as the new first element)
     */
    public void pushFront(Taxi taxi) {
        if (taxi != null) {
            taxi.setNext(first);
        }
        first = taxi;
    }

    /**
     * @return Returns the first element without removing it.
     */
    public Taxi peekFront() {
        return first;
    }

    /**
     * @return Returns the first element and removes it.
     */
    public Taxi popFront() {
        Taxi result = first;
        if (first != null) {
            first = first.getNext();
        }
        return result;
    }

    /**
     * @return Returns the last element without removing it.
     */
    public Taxi peekBack() {
        Taxi result;
        if (first != null) {
            result = first.last();
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Removes a taxi from the list.
     */
    public void remove(Taxi taxi) {
        if (first != null) {
            first.remove(taxi);
        }
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String result;
        if (first != null) {
            result = "Taxilot: [Size: " + this.size() + ", Seats: " + this.seatCount() + ", Elements: " + first.listToString() + "]";
        } else {
            result = "Taxilot is empty!";
        }
        return result;
    }
}
