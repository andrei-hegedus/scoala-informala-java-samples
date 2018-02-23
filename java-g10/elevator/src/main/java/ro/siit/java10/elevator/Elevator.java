package ro.siit.java10.elevator;

/**
 * Created by andrei on 2/22/18.
 */
public class Elevator {

    private int[] destQueue;
    private int nrOfDestinations = 0;
    private Button floorButtons[];

    public Elevator(int nrOfFloors) {
        // assumed that maximum size of queue is nr of floors
        destQueue = new int[nrOfFloors];
        floorButtons = new Button[nrOfFloors];
        for(int i=0; i<nrOfFloors; i++){
            floorButtons[i] = new Button(new SetDestinationAction(i));
        }
    }

    private class SetDestinationAction implements Button.ButtonAction {

        private int destination;

        public SetDestinationAction(int destination) {
            this.destination = destination;
        }

        public void onActionTriggered() {
            addDestination(destination);
        }
    }

    public void addDestination(int toFloor) {
        if (nrOfDestinations <= 1) {
            updateQueueArray(toFloor);
        } else {
            int lastDest = destQueue[nrOfDestinations - 1];
            int penultimateDest = destQueue[nrOfDestinations - 2];
            if (Math.abs(lastDest - penultimateDest) < 2) {
                updateQueueArray(toFloor);
            } else if (lastDest > penultimateDest) {
                // going up
                // TODO: 2/22/18  
            } else {
                // going down
                // TODO: 2/22/18
            }
        }
    }

    private void updateQueueArray(int toFloor) {
        destQueue[nrOfDestinations] = toFloor;
        nrOfDestinations++;
    }

}
