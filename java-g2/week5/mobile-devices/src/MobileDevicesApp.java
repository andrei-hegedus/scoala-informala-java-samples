public class MobileDevicesApp {
  
    public static void main(String...args) throws InterruptedException{
        System.out.println("MobileDevicesApp");
        System.out.println("\nTest Nokia 3310");
        MobileDevice mobile1 = new Nokia3310();
        mobile1.on();
        System.out.println("mobile1 battery: "+mobile1.getChargeLevel());
        System.out.println("..wait 3 seconds");
        Thread.sleep(3000); // wait for 3 seconds
        System.out.println("mobile1 battery: "+mobile1.getChargeLevel());
        
        System.out.println("..play snake and wait 3 seconds");
        Nokia nokia = (Nokia) mobile1;
        nokia.playSnake();
        Thread.sleep(3000); // wait for 3 seconds
        System.out.println("mobile1 battery: "+nokia.getChargeLevel());
        
        System.out.println("\nTest Lumia600");
        MobileDevice mobile2 = new Lumia600();
        mobile2.on();
        System.out.println("mobile2 battery: "+mobile2.getChargeLevel());
        System.out.println("..wait 3 seconds");
        Thread.sleep(3000); // wait for 3 seconds
        System.out.println("mobile2 battery: "+mobile2.getChargeLevel());
        
        System.out.println("..play snake and wait 3 seconds");
        nokia = (Nokia) mobile2;
        nokia.playSnake();
        Thread.sleep(3000); // wait for 3 seconds
        System.out.println("mobile2 battery: "+nokia.getChargeLevel());
    }
}