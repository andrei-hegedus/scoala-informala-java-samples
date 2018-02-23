package ro.siit.java10.elevator;

/**
 * Created by andrei on 2/22/18.
 */
public class Button {

    private final ButtonAction action;

    public Button(ButtonAction action) {
        this.action = action;
    }

    public void push() {
        action.onActionTriggered();
    }

    public interface ButtonAction {
        void onActionTriggered();
    }
}
