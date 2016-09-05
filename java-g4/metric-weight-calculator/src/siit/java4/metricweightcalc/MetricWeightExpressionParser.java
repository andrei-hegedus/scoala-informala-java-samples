package siit.java4.metricweightcalc;

public class MetricWeightExpressionParser {
	
	private static final String MINUS = "-";
	private static final String PLUS = "\\+";

	public Weight [] parse(String expression) throws UnknownWeightFormatException{
		// count the operands
		int operandCount = countSubStringOccurrences(expression, PLUS)+countSubStringOccurrences(expression, MINUS)+1;
		if(expression.startsWith("-")){
			operandCount--;
		}
		Weight weights[] = new Weight[operandCount];
		int index = 0;
		expression = expression.trim().replaceAll(" ", "").replaceAll("\t", "").replaceAll("\n", ""); // loose the whitespaces 
		while(expression.length()>0){
			int sign = 1;
			if(expression.startsWith(MINUS)){
				expression = expression.replaceFirst(MINUS, "");
				sign = -1;
			} else if (expression.startsWith("+")){
				expression = expression.replaceFirst(PLUS, "");
			}
			int nextOpPos = nextOperatorPos(expression);
			String operand = null;
			if(nextOpPos==-1){// last operand
				operand = expression;
			} else {
				operand = expression.substring(0, nextOpPos);
			}
			expression = expression.replaceFirst(operand, "");
			weights[index++] = convertToWeight(operand, sign);
		}
		return weights;
	}
	
	int nextOperatorPos(String expression) {
		int plusPos = expression.indexOf("+");
		int minusPos = expression.indexOf("-");
		if(plusPos==-1){
			return minusPos;
		}
		if(minusPos==-1){
			return plusPos;
		}
		return plusPos<minusPos?plusPos:minusPos;
	}

	private Weight convertToWeight(String e, int sign) throws UnknownWeightFormatException {
		if(e.endsWith(Weight.POUNDS)){
			return convertToWeight(e, sign, Weight.POUNDS);
		} else if (e.endsWith(Weight.KILO_GRAMS)){
			return convertToWeight(e, sign, Weight.KILO_GRAMS);
		} else if(e.endsWith(Weight.GRAMS)){
			return convertToWeight(e, sign, Weight.GRAMS);
		}
		throw new UnknownWeightFormatException("Can not parse ["+e+"] as a valid weight.");
	}
	
	private Weight convertToWeight(String e, int sign, String weightFormat){
		return new Weight(weightFormat, sign * Integer.parseInt(e.replace(weightFormat, "")));
	}

	private int countSubStringOccurrences(String s, String sub){
		return s.length() - s.replaceAll(sub, "").length();
	}

}
