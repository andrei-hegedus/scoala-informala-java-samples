public class Stock {
    
    private static final int NO_INDEX = -1;
    private Music [] music = new Music[100];
    private int [] stock = new int[100];
    private int count;
    
    public void addToStock(Music music, int stock) {
        int musicIndex = indexOf(music);
        if(musicIndex == NO_INDEX){
            this.music[count] = music;  
            this.stock[count] = stock;
            count++;
        } else {
            this.stock[musicIndex] += stock;
        }
    }
    
    private int indexOf(Music music){
        for(int i = 0; i < count; i++){
            if(this.music[i].equals(music)){
                return i;
            }
        }
        return NO_INDEX;
    }
    
    public int getStock(Music music) {
        int musicIndex = indexOf(music);
        if(musicIndex == NO_INDEX){
            return 0;
        } else {
            return stock[musicIndex];
        }
    }
    
    public void decreaseStock(Music music) {
        decreaseStock(music, 1);
    }
    
    public void decreaseStock(Music music, int amount) {
        int musicIndex = indexOf(music);
        if(musicIndex == NO_INDEX){
            return;
        } else if(stock[musicIndex] == 0){
            return;
        } else if(stock[musicIndex]<amount){
            throw new IllegalArgumentException("You greedy bastard.");
        } else {
            stock[musicIndex] -= amount;
        }
    }
}