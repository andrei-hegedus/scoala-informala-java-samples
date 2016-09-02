package siit.java4.metricweightcalc;

import org.junit.Test;
import org.junit.Assert;

public class WeightConverterTest {
	
	@Test
	public void gramsToKilogramsConvertion(){
		Weight g1000 = new Weight(Weight.GRAMS, 1000);
		MetricWeightConverter weightConverter = new MetricWeightConverter();
		
		Weight result = weightConverter.convert(g1000, Weight.KILO_GRAMS);
		Weight expected = new Weight(Weight.KILO_GRAMS, 1);
		
		Assert.assertEquals("Convertion from grams to kgs is incorrect.", expected,  result);
	}
	
	@Test
	public void kilogramsToGramsConvertion(){
		Weight kg1 = new Weight(Weight.KILO_GRAMS, 1);
		MetricWeightConverter weightConverter = new MetricWeightConverter();
		
		Weight result = weightConverter.convert(kg1, Weight.GRAMS);
		Weight expected = new Weight(Weight.GRAMS, 1000);
		
		Assert.assertEquals("Convertion from kgs to gs is incorrect.", expected,  result);
	}

}
