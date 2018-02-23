package ro.siit.java10.elevator;

/**
 * Created by andrei on 2/22/18.
 */
public class Main {

    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem();
        Floor[] floors = system.getFloors();
        floors[3].callButton.push(); // call an elevator to 4th floor
    }
}
