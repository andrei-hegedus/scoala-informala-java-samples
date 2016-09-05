package siit.java4.metricweightcalc;

public class MetricWeightConverter {
	
	private static final Convertion [] CONVERTIONS = new Convertion[]{
		new Convertion(Weight.KILO_GRAMS, Weight.GRAMS, 1000),
		new Convertion(Weight.GRAMS, Weight.KILO_GRAMS, 0.001),
		new Convertion(Weight.KILO_GRAMS, Weight.POUNDS, 2.2),
		new Convertion(Weight.POUNDS, Weight.KILO_GRAMS, 0.45),
		new Convertion(Weight.POUNDS, Weight.GRAMS, 453.59),
		new Convertion(Weight.GRAMS, Weight.POUNDS, 0.0022),
	};

	
	public Weight convert(Weight weight, String toFormat) throws UnknownWeightFormatException{
		if(weight.getFormatName().equals(toFormat)){
			return weight;
		}
		Convertion convertion = null;
		for(Convertion c : CONVERTIONS){
			if(c.fromFormat.equals(weight.getFormatName()) && c.toFormat.equals(toFormat)){
				convertion = c;
				break;
			}
		}
		if(convertion==null){
			throw new UnknownWeightFormatException("No rate found for "+weight.getFormatName()+" - "+toFormat);
		}
		return new Weight(toFormat, weight.getValue()*convertion.rate);
	}
	
	private static class Convertion {
		double rate;
		String fromFormat;
		String toFormat;
		
		public Convertion(String fromFormat, String toFormat, double rate) {
			super();
			this.rate = rate;
			this.fromFormat = fromFormat;
			this.toFormat = toFormat;
		}
		
		
		
	}

}
