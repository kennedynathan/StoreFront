package adminApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

public class FileService < E extends SalableProduct> {
	
	//read inventory from external json file
	public String readInventoryJson() throws IOException { 
		BufferedReader reader = new BufferedReader(new FileReader("admin_inventory.json"));
		
		String json = reader.readLine();
		reader.close();
		return json;
	}
	
	// In a file with array of products and output json file
	public void saveToFile(String filename, E[] inventory) throws IOException {
		PrintWriter pw;
		File file = new File(filename);
		FileWriter fw = new FileWriter(file);
		pw = new PrintWriter(fw);
		//convert to json
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(inventory);
		
		//write to json
		pw.println(json);
		pw.close();
	}
}