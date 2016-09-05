package siit.java4.metricweightcalc;

import org.junit.Test;
import static org.junit.Assert.*;

public class MetricWeightExpressionParserTest {

	@Test
	public void nextOperatorTest1() {
		// given
		MetricWeightExpressionParser parser = new MetricWeightExpressionParser();
		String s = "123-";
		
		// when
		int opPos = parser.nextOperatorPos(s);
		
		//then
		assertEquals(3, opPos);
	}

	@Test
	public void nextOpPosNotFound() {
		MetricWeightExpressionParser parser = new MetricWeightExpressionParser();
		String s = "123";
		assertEquals(-1, parser.nextOperatorPos(s));
	}

	@Test
	public void nextOperatorTestCorrectWithMultipleOps() {
		MetricWeightExpressionParser parser = new MetricWeightExpressionParser();
		String s = "123-+-";
		assertEquals(3, parser.nextOperatorPos(s));
	}

	@Test
	public void nextOperatorTestWithJustOp() {
		MetricWeightExpressionParser parser = new MetricWeightExpressionParser();
		String s = "+";
		assertEquals(0, parser.nextOperatorPos(s));
	}

	@Test
	public void correctFormatIsParsed() throws UnknownWeightFormatException {
		MetricWeightExpressionParser parser = new MetricWeightExpressionParser();
		String s = "1kg+1kg";
		Weight[] expected = new Weight[] { new Weight(Weight.KILO_GRAMS, 1), new Weight(Weight.KILO_GRAMS, 1) };
		Weight[] actual = parser.parse(s);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void correctFormatWithMinusIsParsed() throws UnknownWeightFormatException {
		MetricWeightExpressionParser parser = new MetricWeightExpressionParser();
		String s = "1kg-1kg";
		Weight[] expected = new Weight[] { new Weight(Weight.KILO_GRAMS, 1), new Weight(Weight.KILO_GRAMS, -1) };
		Weight[] actual = parser.parse(s);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void correctFormatIsParsed2() throws UnknownWeightFormatException {
		MetricWeightExpressionParser parser = new MetricWeightExpressionParser();
		String s = "1kg-13kg";
		Weight[] expected = new Weight[] { new Weight(Weight.KILO_GRAMS, 1), new Weight(Weight.KILO_GRAMS, -13) };
		Weight[] actual = parser.parse(s);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void correctFormatWithMultipleOpsAndNegativeSignAtStartIsParsed() throws UnknownWeightFormatException {
		MetricWeightExpressionParser parser = new MetricWeightExpressionParser();
		String s = "-1kg+5kg-3g";
		Weight[] expected = new Weight[] { new Weight(Weight.KILO_GRAMS, -1), new Weight(Weight.KILO_GRAMS, 5),
				new Weight(Weight.GRAMS, -3) };
		Weight[] actual = parser.parse(s);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void correctFormatWithMultipleOpsIsParsed() throws UnknownWeightFormatException {
		MetricWeightExpressionParser parser = new MetricWeightExpressionParser();
		String s = "1kg+5kg-3g";
		Weight[] expected = new Weight[] { new Weight(Weight.KILO_GRAMS, 1), new Weight(Weight.KILO_GRAMS, 5),
				new Weight(Weight.GRAMS, -3) };
		Weight[] actual = parser.parse(s);
		assertArrayEquals(expected, actual);
	}
	
	@Test(expected=UnknownWeightFormatException.class)
	public void parsingFailsWithInvalidWeightFormat() throws UnknownWeightFormatException {
		MetricWeightExpressionParser parser = new MetricWeightExpressionParser();
		String s = "-1kg+5kg-3s";
		parser.parse(s);
	}

}
