package z_4_testRestApiClient.z_4_testRestApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestClient {

	public static void main(String[] args) {

		TestClient ncg = new TestClient();
		ncg.executeGETService();
	}

	public String executeGETService(){

		String outputVal = "";
		
		try {

			//URL url = new URL("http://testweb5-testweb5.192.168.99.100.nip.io/webapi/myresource");
			URL url = new URL("http://test-rest-2-testrest2.apps.sapinnovation-shared.os.fyre.ibm.com/abcd");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;

			while ((output = br.readLine()) != null) {

				outputVal = output;
				return outputVal;
				//System.out.print(output);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			return e.getLocalizedMessage();

		} catch (IOException e) {

			return e.getLocalizedMessage();
		}
		return outputVal;
	}
}
