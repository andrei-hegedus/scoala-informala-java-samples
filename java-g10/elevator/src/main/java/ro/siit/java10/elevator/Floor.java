package ro.siit.java10.elevator;

/**
 * Created by andrei on 2/22/18.
 */
public class Floor {

    public final Button callButton;

    private final int floorNumber;

    public Floor(final ElevatorSystem system, final int floorNumber) {
        this.floorNumber = floorNumber;
        callButton = new Button(new Button.ButtonAction() {

            public void onActionTriggered() {
                system.callElevator(floorNumber);
            }

        });
    }
}
