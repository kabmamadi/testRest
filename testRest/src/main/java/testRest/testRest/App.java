package testRest.testRest;

/**
 * Hello world!
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
public class App {
	
	private final String cle = "VO3W5GID9TBGBLB";
	
	public static void main(String[] args) throws  IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = null;
		try {
			String req1 = "http://data.keolis-rennes.com/json/?version=2.0&key=VO3W5GID9TBGBLB&cmd=getlines&param[network]=star&param[mode]=all&name=1";
			String req2 = "http://data.keolis-rennes.com/json/?version=1.0&key=VO3W5GID9TBGBLB&cmd=getstation&param[request]=number&param[value]=5";
			request = new HttpGet(req2);

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpResponse response = null;
		try {
			response = client.execute(request);
		} catch (HttpException e) {
			e.printStackTrace();
		}
		BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}
	}
}
