package ro.siit.java10.elevator;

/**
 * Created by andrei on 2/22/18.
 */
public class ElevatorSystem {

    private final Floor [] floors;
    private final Elevator elevator;

    public ElevatorSystem(){
        floors = new Floor[4];
        floors[0] = new Floor(this, 0); // parter
        floors[1] = new Floor(this, 1);
        floors[2] = new Floor(this, 2);
        floors[3] = new Floor(this, 3);
        elevator = new Elevator(4);
    }

    public void callElevator(int toFloor){
        elevator.addDestination(toFloor);
    }

    public Floor[] getFloors() {
        return floors;
    }
}


