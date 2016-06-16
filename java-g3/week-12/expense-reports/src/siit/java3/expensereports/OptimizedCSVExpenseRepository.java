package siit.java3.expensereports;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OptimizedCSVExpenseRepository extends CSVExpenseRepository implements AutoCloseable {

	private FileWriter writer;

	public void openCSV() throws IOException {
		File file = new File(CSV_FILE_NAME);
		writer = new FileWriter(file, true);
	}
	
	public void closeCSV() throws IOException{
		if(writer!=null){
			writer.close();
		}
	}

	@Override
	public void save(Expense expense) throws IOException {
		writer.append(csvFormater.toCSV(expense) + "\n");
	}

	@Override
	public void close() throws Exception {
		closeCSV();
	}

}
