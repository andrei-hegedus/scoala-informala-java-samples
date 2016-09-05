package siit.java4.metricweightcalc;

public class MetricWeightCalculator {
	
	private MetricWeightExpressionParser parser;
	private MetricWeightConverter converter;
	
	public MetricWeightCalculator() {
		this(new MetricWeightExpressionParser(), new MetricWeightConverter());
	}
	
	MetricWeightCalculator(MetricWeightExpressionParser parser, MetricWeightConverter converter) {
		this.parser = parser;
		this.converter = converter;
	}

	public Weight computeWeight(String expression, String resultWeightFormat) throws UnknownWeightFormatException{
		Weight[] weights = parser.parse(expression);
		Weight result = new Weight(resultWeightFormat, 0);
		for(Weight weight :  weights){
			Weight converted = converter.convert(weight, resultWeightFormat);
			result.add(converted.getValue());
		}
		return result;
	}

}
