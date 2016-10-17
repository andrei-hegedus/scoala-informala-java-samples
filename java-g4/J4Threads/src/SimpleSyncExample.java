
public class SimpleSyncExample {

	public static void main(String[] args) {
		for(int i=0;i<50;i++){
			(new Thread(){
				@Override
				public void run() {
					Singleton s = Singleton.getInstance();
					Integer integer = s.hashCode();
					System.out.println(integer.hashCode());
				}
			}).start();
		}
	}

}
