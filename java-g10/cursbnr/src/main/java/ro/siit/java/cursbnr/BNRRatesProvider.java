package ro.siit.java.cursbnr;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface BNRRatesProvider {
    public List<BNRRate> getRates() throws Exception;
}
