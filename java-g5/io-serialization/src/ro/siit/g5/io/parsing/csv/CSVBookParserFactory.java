package ro.siit.g5.io.parsing.csv;

import java.util.HashMap;

class CSVBookParserFactory {

	private HashMap<String, CSVBookParser<?>> parsers = new HashMap<>();

	public CSVBookParserFactory() {
		CSVBookParser<?> artAlbumCSVParser = new ArtAlbumCSVParser();
		parsers.put(artAlbumCSVParser.getParsedTypeName(), artAlbumCSVParser);
		CSVBookParser<?> novelCSVParser = new NovelCSVParser();
		parsers.put(novelCSVParser.getParsedTypeName(), novelCSVParser);
	}
	
	public CSVBookParser<?> getParserFor(String type){
		if(parsers.containsKey(type)){
			return parsers.get(type);
		} else {
			throw new IllegalArgumentException("No such type: "+type);
		}
	}

}
