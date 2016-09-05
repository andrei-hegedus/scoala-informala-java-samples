package siit.java4.metricweightcalc;

public class MetricWeightCalculator {
	
	private MetricWeightExpressionParser parser = new MetricWeightExpressionParser();
	
	public Weight computeWeight(String expression, String resultWeightFormat) throws UnknownWeightFormatException{
		Weight[] weights = parser.parse(expression);
		Weight result = new Weight(resultWeightFormat, 0);
		MetricWeightConverter converter = new MetricWeightConverter();
		for(Weight weight :  weights){
			Weight converted = converter.convert(weight, resultWeightFormat);
			result.add(converted.getValue());
		}
		return result;
	}

}
