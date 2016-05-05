package com.siit.java2.streams;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class CarOutputStream extends OutputStream implements AutoCloseable, CarIO {

	
	private final byte[] COMMA_BYTES;

	private OutputStream os;

	public CarOutputStream(OutputStream os) throws UnsupportedEncodingException {
		this.os = os;
		COMMA_BYTES = COMMA.getBytes(IO_CHARSET);
	}

	@Override
	public void write(int b) throws IOException {
		os.write(b);
	}

	public void writeCar(Car car) throws IOException {
		writeString(car.getManufacturer(), true);
		writeString(car.getModel(), true);
		writeString(Integer.toString(car.getYear()), false);
	}

	private void writeString(String string, boolean addComma) throws IOException {
		byte[] stringBytes = string.getBytes(IO_CHARSET);
		os.write(stringBytes, 0, stringBytes.length);
		if (addComma) {
			os.write(COMMA_BYTES, 0, COMMA_BYTES.length);
		}
	}

	@Override
	public void close() throws IOException {
		os.close();
	}

}
