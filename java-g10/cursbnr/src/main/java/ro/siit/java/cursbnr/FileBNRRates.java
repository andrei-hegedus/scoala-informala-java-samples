package ro.siit.java.cursbnr;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBNRRates implements BNRRatesProvider {

    private File file;
    private ArrayList<BNRRate> rates;

    public FileBNRRates(File file) {
        this.file = file;
    }

    public List<BNRRate> getRates() throws IOException, SAXException, ParserConfigurationException {
        if (rates == null) {
            rates = new ArrayList<BNRRate>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            NodeList rateNodes = doc.getElementsByTagName("Rate");
            for (int i = 0; i < rateNodes.getLength(); i++) {
                Node item = rateNodes.item(i);
                String currency = item.getAttributes().getNamedItem("currency").getNodeValue();
                Node multiplierNode = item.getAttributes().getNamedItem("multiplier");
                float multilpier = multiplierNode==null?1:Float.parseFloat(multiplierNode.getNodeValue());
                String nodeValue = item.getNodeValue();
                float rate = Float.parseFloat(item.getChildNodes().item(0).getNodeValue());
                rates.add(new BNRRate(Currency.valueOf(currency), multilpier, rate));
            }
        }
        return rates;
    }
}
