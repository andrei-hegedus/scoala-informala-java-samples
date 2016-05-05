public class Cell {
    
    private boolean inCall = false;
    
    public boolean isInCall(){
        return inCall;
    }
    
    public void call(String phoneNr) {
        // call someone
        inCall = true;
    }
    
    public void stopCall() {
        inCall = false;
    }
}