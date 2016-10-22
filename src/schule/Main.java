package schule;

import schule.taxis.Taxi;
import schule.taxis.Taxistand;

public class Main {
    public static void main(String[] args) {
        Taxi t0 = new Taxi("Max Müller", 0);
        Taxi t1 = new Taxi("Herbert Maier", 1);
        Taxi t2 = new Taxi("Knut Werda", 2);
        Taxi t3 = new Taxi("Paula Merks", 3);
        Taxi t4 = new Taxi("Winnfrid Lang", 4);
        Taxi t5 = new Taxi("Marko Schling", 5);

        Taxistand stand = new Taxistand();
        stand.print();

        stand.pushBack(t0);
        stand.print();
        stand.pushBack(t1);
        stand.print();
        stand.pushBack(t2);
        stand.print();
        stand.pushBack(t3);
        stand.print();
        stand.pushBack(t4);
        stand.print();
        stand.pushFront(t5);
        stand.print();

        int size = stand.size();
        int seatCount = stand.seatCount();
        Taxi last = stand.peekBack();
        Taxi first = stand.peekFront();

        System.out.println("Size: " + size + ", Seat-Count: " + seatCount + ", Front: " + first.toString() + ", Last: " + last.toString());

        System.out.println("Removing: " + t3.toString());
        stand.remove(t3);

        stand.print();
    }
}
