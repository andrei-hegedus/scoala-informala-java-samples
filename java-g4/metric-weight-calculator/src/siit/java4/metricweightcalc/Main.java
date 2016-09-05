package siit.java4.metricweightcalc;

public class Main {

	public static void main(String[] args) throws UnknownWeightFormatException {
		String s = "2kg+500g-1lbs";
		MetricWeightCalculator calc = new MetricWeightCalculator();
		System.out.println(calc.computeWeight(s, Weight.KILO_GRAMS));
	}

}
