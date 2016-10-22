package schule.taxis;

import java.util.Random;

public class Taxi {
    private static final Random random = new Random();
    private static final int MAX_SEATS = 6;
    private static final int MIN_SEATS = 2;

    private final String driverName;
    private final int number, seats;
    private Taxi next;

    public Taxi(final String driverName, final int number) {
        this.driverName = driverName;
        this.number = number;
        this.seats = random.nextInt(MAX_SEATS - MIN_SEATS) + MIN_SEATS;
        this.next = null;
    }

    public void pushBack(Taxi taxi) {
        if (next != null) {
            next.pushBack(taxi);
        } else {
            next = taxi;
        }
    }

    public int size() {
        int result;
        if (next != null) {
            result = 1 + next.size();
        } else {
            result = 1;
        }
        return result;
    }

    public int seatCount() {
        int result;
        if (next != null) {
            result = seats + next.seatCount();
        } else {
            result = seats;
        }
        return result;
    }

    /**
     * @return The last element in the list.
     */
    public Taxi last() {
        // If the next of this instance is null this
        // is the last instance because it hasn't
        // got a follower.
        Taxi result;
        if (next != null) {
            // If this isn't the last taxi the next
            // might be -> pass the call to the next
            result = next.last();
        } else {
            // It hasn't got a follower -> it is the last
            // -> it is the result -> return it
            result = this;
        }
        return result;
    }

    public void remove(Taxi taxi) {
        // If the follower of the current instance is
        // the taxi to remove, set the next of the current
        // instance to the next of the taxi
        //
        // Remove (2):
        // -----------
        //
        // (1) -> (2) -> (3) -> null
        //
        // Set next-pointer of first to point to the third
        // element =>
        //       ________________
        //      |                |
        //      |                v
        // (1) -^ [(2) -> null] (3) -> null
        if (taxi != null && taxi.equals(next)) {
            next = taxi.next;
            // Dereference the taxi from the list
            taxi.next = null;
        } else {
            // Pass call to the next, so the next
            // can try if it's follower is the taxi
            // to remove.
            next.remove(taxi);
        }
    }

    /**
     * @return The list as a string (implemented recursive :D)
     */
    public String listToString() {
        String str = toString();
        if (next != null) {
            str += ", " + next.listToString();
        }
        return str;
    }

    @Override
    public String toString() {
        return "[Driver: '" + driverName + "', Number: " + number + ", Seats: " + seats + "]";
    }

    public int getNumber() {
        return number;
    }

    public int getSeats() {
        return seats;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setNext(Taxi next) {
        this.next = next;
    }

    public Taxi getNext() {
        return next;
    }
}
