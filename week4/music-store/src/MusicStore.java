public class MusicStore {
    
    private Music [] inventory = new Music[100];
    private int inventoryCount = 0;
    private Stock stock = new Stock();
    
    public void addMusic(Music music, float basePrice, int stock) {
        if(inventoryCount == 100){
            throw new IllegalStateException("Inventory is full");
        }
        for(int i = 0; i<inventoryCount; i++) {
            if(inventory[i].equals(music)) {
                this.stock.addToStock(music, stock);
                return;
            }
        }
        inventory[inventoryCount++] = music;
        this.stock.addToStock(music, stock);
        // TODO - implement price catalog
    }
    
    public void listMusic() {
        System.out.println("Inventory size: "+inventoryCount);
        for(int i=0;i<inventoryCount;i++){
            Music music = inventory[i];
            int stock = this.stock.getStock(music);
            System.out.println(music.toString()+" | stock: "+stock);
        }
    }
    
    public void purchase(Music music) throws NotEnoughStockException{
        purchase(music, 1);
    }
    
    public void purchase(Music music, int amount) throws NotEnoughStockException {
    	if(amount > stock.getStock(music)){
    		throw new NotEnoughStockException();
    	}
        stock.decreaseStock(music, amount);
    }
    
}