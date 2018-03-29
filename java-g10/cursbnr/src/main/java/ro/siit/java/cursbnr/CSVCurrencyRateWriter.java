package ro.siit.java.cursbnr;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class CSVCurrencyRateWriter extends Writer {

    private static final String CSV_LINE_PATTERN = "{0},{1,number,0.00},{2,number,0.00}\n";

    private Writer writer;

    public CSVCurrencyRateWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        writer.write(cbuf, off, len);
    }

    @Override
    public void flush() throws IOException {
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }

    public void writeRates(List<BNRRate> rates) throws IOException {
        for (BNRRate rate : rates) {
            String csvLine = MessageFormat.format(CSV_LINE_PATTERN, rate.getCurrency().name(), rate.getRate(), rate.getMultiplier());
            write(csvLine, 0, csvLine.length());
        }
    }
}
