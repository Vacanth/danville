package com.vendertool.batch.category;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component("categorySyncReader")
public class CategoryReader implements ItemReader<Category> {
	private static Set<Map.Entry<String, JsonElement>> entrySet = null;
	private static Iterator<Map.Entry<String, JsonElement>> iterator = null;
	static int total = 0;
	static int sucess = 0;
	static int failure = 0;
	static {
		// TODO change the C:// contexts. Just put it in default folders.
		String OUTPUT_FILE = "C:/Users/Girish/Desktop/Category/samplecategory.json";
		String saveTo = "C:/Users/Girish/Desktop/Category";
		String INPUT_GZIP_FILE= "C:/Users/Girish/Desktop/Category/output.gz";
		String categoryURL = "https://api.mercadolibre.com/sites/MLA/categories/all";
		try {
			URL url = new URL(categoryURL);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("Accept-Encoding", "gzip");
			InputStream in = conn.getInputStream();
			InputStream gis = new GZIPInputStream(in);
			FileOutputStream out = new FileOutputStream(saveTo + "/category.gz");
			byte[] b = new byte[1024];
			int count;
			while ((count = gis.read(b)) >= 0) {
				out.write(b, 0, count);
			}
			out.flush();
			out.close();
			in.close();

			GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(INPUT_GZIP_FILE), 1024);
			FileOutputStream fos = new FileOutputStream(OUTPUT_FILE);
			byte[] buffer = new byte[1024];
			int len;
			while ((len = gzis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			gzis.close();
			fos.close();
			System.out.println("Done");

			InputStream is = new FileInputStream(OUTPUT_FILE);
			InputStreamReader reader = new InputStreamReader(is, "UTF-8");// reader.getEncoding()
			BufferedReader br = new BufferedReader(reader);
			/*
			 * Category result1 = new Gson().fromJson(reader, Category.class);
			 */
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(new FileReader(OUTPUT_FILE));
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			entrySet = jsonObject.entrySet();
			iterator = entrySet.iterator();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Category read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {

		if (entrySet == null || iterator == null) {
			return null;
		}

		if (iterator.hasNext()) {
			Entry<String, JsonElement> entry = iterator.next();
			total++;
			String key = entry.getKey();
			JsonElement value = entry.getValue();
			ObjectMapper mapper = new ObjectMapper();
			Category cat = null;
			try {
				cat = mapper.readValue(value.toString(), Category.class);
				sucess++;
			} catch (Exception e) {
				System.out.println("" + value);
				failure++;
			}
			return cat;
		}
		System.out.println("Total Categories : "+total+" Sucess : "+sucess+" Failure"+failure);
		return null;
	}
}