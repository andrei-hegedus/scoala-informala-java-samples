public class Lumia600 extends Nokia {
    private ColorScreen screen = new ColorScreen();
    private Wifi wifi = new Wifi();
    
    protected int getDischargeAmountFor1Minute(){
        return screen.getScreenConsumption();
    }
    
     @Override
    protected void updateBatteryPercentage(){
        super.updateBatteryPercentage();
        if(wifi.isTurnedOn()){
            batteryPercentage -= wifi.getWifiConsumption();
        }
    }
    
    private class ColorScreen {
        
        public int getScreenConsumption() {
            return 3;
        }
        
    }
    
    private class Wifi {
        
        private boolean turnedOn = true;
        
        public boolean isTurnedOn() {
            return turnedOn;
        }
        
        public int getWifiConsumption() {
            return 2;
        }
        
    }
}