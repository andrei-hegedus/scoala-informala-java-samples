package ro.siit.g5.io.parsing.csv;

import ro.siit.g5.io.Novel;
import ro.siit.g5.io.Novel.Genre;

class NovelCSVParser implements CSVBookParser<Novel> {
	
	private static final String SEPARATOR = ",";

	@Override
	public Novel parseBook(String source) {
		String [] tokens = source.split(SEPARATOR);
		return new Novel(tokens[1], tokens[2], Genre.valueOf(tokens[3]));
	}

	@Override
	public String getParsedTypeName() {
		return Novel.class.getSimpleName();
	}

}
