import java.util.ArrayList;
import java.util.Iterator;

public class MusicStore {
    
	private static final int MAX_INVENTORY = 100;
    private ArrayList<Music> inventory = new ArrayList<>();
    private Stock stock = new Stock();
    
    public void addMusic(Music music, float basePrice, int stock) {
        if(MAX_INVENTORY < inventory.size()){
            throw new IllegalStateException("Inventory is full");
        }        
        if(!inventory.contains(music)){
        	inventory.add(music);
        }
        this.stock.addToStock(music, stock);
        // TODO - implement price catalog
    }
    
    public void listMusic() {
        System.out.println("Inventory size: "+inventory.size());
//        for(int i=0;i<inventory.size();i++){
//            Music music = inventory.get(i);
//            int stock = this.stock.getStock(music);
//            System.out.println(music.toString()+" | stock: "+stock);
//        }
        for(Music music : inventory){
            int stock = this.stock.getStock(music);
            System.out.println(music.toString()+" | stock: "+stock);
        }
        
        /*Iterator<Music> iterator = inventory.iterator();
        while(iterator.hasNext()){
        	Music music = iterator.next();
        	 int stock = this.stock.getStock(music);
             System.out.println(music.toString()+" | stock: "+stock);
        }*/
    }
    
    public void purchase(Music music){
        purchase(music, 1);
    }
    
    public void purchase(Music music, int amount) {
        stock.decreaseStock(music, amount);
    }
    
}