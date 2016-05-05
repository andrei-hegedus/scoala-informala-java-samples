package siit.java2.threads;

public class UnsafeSingleton {
	
	private static UnsafeSingleton instance;
	
	private UnsafeSingleton(){
		
	}
	
	public static UnsafeSingleton getInstance() {
		/*
		 * Because this method is NOT synchronized there is a chance that two threads enter the method almost at the same time.
		 * The first thread checks if the instance is null -> it is null so it goes to the next call in the Thread stack which calls the constructor.
		 * The second thread also check if the instance is null -> it still is null because the first thread did not manage to finish instantiation -> a second instance is created -> the class is not a singleton anymore.
		 */
		if(instance==null){
			instance = new UnsafeSingleton();
		}
		return instance;
	}

}
