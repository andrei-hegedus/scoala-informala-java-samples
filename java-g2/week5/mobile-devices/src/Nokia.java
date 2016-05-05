public abstract class Nokia extends Phone {

    private SnakeGame snakeGame = new SnakeGame();
    
    public void playSnake(){
        snakeGame.play();
    }
    
    public void stopPlaying() {
        snakeGame.stop();
        snakeGame = null;
    }
    
    @Override
    protected void updateBatteryPercentage(){
        super.updateBatteryPercentage();
        if(snakeGame.isOn()){
            batteryPercentage -= getDischargeAmountFor1Minute();
        }
    }
    
    private class SnakeGame {
        
        private boolean active;
        
        public void play() {
            active = true;
        }
        
        public void stop() {
            active = false;
        }
        
        public boolean isOn() {
            return active;
        }
    }
    
}