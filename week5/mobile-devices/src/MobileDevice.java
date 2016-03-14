public interface MobileDevice {
  void charge(int hours);
  void on();
  void off();
  int getChargeLevel();
}