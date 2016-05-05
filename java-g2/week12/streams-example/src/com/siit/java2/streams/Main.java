package com.siit.java2.streams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.stream.FileImageInputStream;

public class Main {

	public static void main(String[] args) throws IOException, CarInputStreamException {

		Car car = new Car("Tesla", "Model S", 2015);

		File file = new File("masina.txt");
		//OutputStream os = new FileOutputStream(file);
		OutputStream os = new ByteArrayOutputStream(100);
		try (CarOutputStream cos = new CarOutputStream(os)) {
			cos.writeCar(car);
		}
		ByteArrayOutputStream bos = (ByteArrayOutputStream) os;
		System.out.println(new String(bos.toByteArray()));
		
		//InputStream is = new FileInputStream(file);
		InputStream is = new ByteArrayInputStream("Tesla,Model S,2016".getBytes());
		CarInputStream cis = new CarInputStream(is);
		Car car2 = cis.readCar();
		System.out.println(car2);
	}

}
