package siit.java4.metricweightcalc;

import org.junit.Test;
import static org.junit.Assert.*;

public class MetricWeightCalculatorTest {
	
	@Test
	public void simpleExpressionIsCalculated() throws UnknownWeightFormatException{
		// given
		MetricWeightExpressionParser mockParser = new MetricWeightExpressionParser(){
			@Override
			public Weight[] parse(String expression) throws UnknownWeightFormatException {
				return new Weight[]{new Weight(Weight.KILO_GRAMS, 1), new Weight(Weight.GRAMS, 1)};
			}	
		};
		MetricWeightConverter mockConverter = new MetricWeightConverter(){
			@Override
			public Weight convert(Weight weight, String toFormat) throws UnknownWeightFormatException {
				if(weight.getFormatName().equals(Weight.KILO_GRAMS)){
					return new Weight(Weight.GRAMS, 1000);
				} else {
					return weight;
				}
			}
		};
		MetricWeightCalculator calc = new MetricWeightCalculator(mockParser, mockConverter);
		
		// when
		Weight actual = calc.computeWeight("1kg+1g", Weight.GRAMS);
		
		// then
		Weight expected = new Weight(Weight.GRAMS, 1001);
		assertEquals(expected, actual);
	}

}
