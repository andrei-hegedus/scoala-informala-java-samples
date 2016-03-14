public abstract class Phone implements MobileDevice {
    
    private Cell cell = new Cell();
    private boolean isOn = false;
    private long lastBatteryUpdate;
    protected int batteryPercentage = 100; // 0 - 100
    
    
    public void call(String phoneNr) {
        cell.call(phoneNr);
    }
    
    public void hangUp(){
        cell.stopCall();
    }
    
    @Override
    public void charge(int hours) {
        switch(hours){
            case 1:
                batteryPercentage +=30;
                break;
            case 2:
                batteryPercentage +=60;
                break;
            default:
                batteryPercentage +=100;
                truncateBatteryPc();
        }
    }
    
    private void truncateBatteryPc(){
        if(batteryPercentage > 100){
            batteryPercentage = 100;
        }
    }
    
    @Override
    public void on() {
        isOn = true;
        lastBatteryUpdate = System.currentTimeMillis();
    }
    
    protected void updateBatteryPercentage(){
        long currentTime = System.currentTimeMillis();
        long timeSpent = currentTime - lastBatteryUpdate;
        for (int seconds = (int)(timeSpent / 1000); seconds > 0; seconds--){
            // compute battery consumption for every second.
            batteryPercentage -= getDischargeAmountFor1Minute();
            if(cell.isInCall()){
                batteryPercentage -=2*getDischargeAmountFor1Minute();
            }
        }
    }
    
    
    @Override
    public void off() {
        isOn = false;
    }
    
    protected abstract int getDischargeAmountFor1Minute();
    
    @Override
    public int getChargeLevel(){
        updateBatteryPercentage();
        return batteryPercentage;
    }

}