package com.siit.java2.streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class CarInputStream extends InputStream implements AutoCloseable, CarIO {

	private InputStream is;

	public CarInputStream(InputStream is) throws UnsupportedEncodingException {
		this.is = is;
	}

	@Override
	public int read() throws IOException {
		return is.read();
	}

	public Car readCar() throws IOException, CarInputStreamException {
		String serializedCar = "";
		byte[] buffer = new byte[5];
		int bytesRead = is.read(buffer);
		while (bytesRead > -1) {
			serializedCar += new String(buffer, 0, bytesRead, IO_CHARSET);
			bytesRead = is.read(buffer);
		}
		if (serializedCar.isEmpty()) {
			return null;
		}
		String[] tokens = serializedCar.split(COMMA);
		try{
		return new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
		} catch (Exception e){
			throw new CarInputStreamException("Could not parse input: "+serializedCar, e);
		}
	}

}
