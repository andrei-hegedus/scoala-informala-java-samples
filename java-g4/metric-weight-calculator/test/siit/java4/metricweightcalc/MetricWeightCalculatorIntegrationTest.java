package siit.java4.metricweightcalc;

import org.junit.Assert;
import org.junit.Test;

public class MetricWeightCalculatorIntegrationTest {
	
	@Test
	public void weightCalculatorWorksWithCorrectInput() throws UnknownWeightFormatException {
		// given
		String s = "2kg+500g-1lbs";
		MetricWeightCalculator calc = new MetricWeightCalculator();
		// when
		Weight result = calc.computeWeight(s, Weight.KILO_GRAMS);
		// then
		Weight expected = new Weight(Weight.KILO_GRAMS, 2.05);
		Assert.assertEquals(expected, result);		
	}

}
