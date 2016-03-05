public class MusicStoreApp {
    
    public static void main(String...args) {
        MusicStore musicStore = new MusicStore();
        Music imMusic = new Music("Iron Maiden", "The Book of Life", 2015, Music.Genre.METAL, Music.Format.CD);
        float basePrice = 9.99f; // add currency in future.
        int stock = 15;
        musicStore.addMusic(imMusic, basePrice, stock);
        musicStore.addMusic(imMusic, basePrice, stock);
        musicStore.listMusic();
        System.out.println("Purchase: "+imMusic);
        musicStore.purchase(imMusic, 30);
        musicStore.listMusic();
    }
    
}