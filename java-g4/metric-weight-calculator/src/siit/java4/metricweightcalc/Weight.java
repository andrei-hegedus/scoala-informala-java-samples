package siit.java4.metricweightcalc;

public class Weight {
	
	public static final String GRAMS = "g";
	public static final String KILO_GRAMS = "kg";
	public static final String POUNDS = "lbs";
	
	private String formatName;
	private double value;
	
	public Weight(String formatName, double value) {
		this.formatName = formatName;
		this.value = value;
	}

	public String getFormatName() {
		return formatName;
	}

	public double getValue() {
		return value;
	}

	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formatName == null) ? 0 : formatName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weight other = (Weight) obj;
		if (formatName == null) {
			if (other.formatName != null)
				return false;
		} else if (!formatName.equals(other.formatName))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weight [formatName=" + formatName + ", value=" + value + "]";
	}

	public void add(double value) {
		this.value += value;
	}
	
	

}
