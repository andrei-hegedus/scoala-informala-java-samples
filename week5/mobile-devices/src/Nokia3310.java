public class Nokia3310 extends Nokia {
    private BlackAndWhiteScreen screen = new BlackAndWhiteScreen();
    
    protected int getDischargeAmountFor1Minute(){
        return screen.getScreenConsumption();
    }
    
    private class BlackAndWhiteScreen {
        public int getScreenConsumption() {
            return 1;
        }
    }
}