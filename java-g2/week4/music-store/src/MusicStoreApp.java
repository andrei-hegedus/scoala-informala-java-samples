import java.util.Comparator;

public class MusicStoreApp {

	public static void main(String... args) {
		testMusicStore();
		testComparators();
	}

	private static void testComparators() {
		Music imMusic = new Music("Iron Maiden", "The Book of Life", 2015, Music.Genre.METAL, Music.Format.CD);
		Music beyonce = new Music("Beyonce", "Beyonce", 2016, Music.Genre.POP, Music.Format.CD);

		System.out.println(beyonce.compareTo(imMusic));
		System.out.println(Music.COMPARATOR_BY_ARTIST.compare(imMusic, beyonce));
		MyMusicComparartorByAge comparatorByAge = new MyMusicComparartorByAge();
		System.out.println(comparatorByAge.compare(imMusic, beyonce));
	}

	private static void testMusicStore() {
		MusicStore musicStore = new MusicStore();
		Music imMusic = new Music("Iron Maiden", "The Book of Life", 2015, Music.Genre.METAL, Music.Format.CD);
		float basePrice = 9.99f; // add currency in future.
		int stock = 15;
		musicStore.addMusic(imMusic, basePrice, stock);
		musicStore.listMusic();
		musicStore.addMusic(imMusic, basePrice, stock);
		musicStore.listMusic();
		System.out.println("Purchase: " + imMusic);
		try {
			musicStore.purchase(imMusic, 30);
		} catch (NotEnoughStockException e) {
			System.out.println("You are trying to buy more items than we have in stock.");
		}
		musicStore.listMusic();
	}

	public static class MyMusicComparartorByAge implements Comparator<Music> {

		@Override
		public int compare(Music o1, Music o2) {
			if (o1.getYear() == o2.getYear()) {
				return 0;
			} else if (o1.getYear() > o2.getYear()) {
				return 1;
			}
			return -1;
		}

	}
}