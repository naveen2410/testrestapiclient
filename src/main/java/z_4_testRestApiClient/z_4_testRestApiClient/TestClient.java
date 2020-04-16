package z_4_testRestApiClient.z_4_testRestApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestClient {

	public static void main(String[] args) {

		TestClient ncg = new TestClient();
		ncg.executeGETService();
	}
	
	public String executePOSTService(){
		
		String outputVal = "";
		
		try {

			URL url = new URL("http://test-rest-api-xml-testrestapixml.apps.sapinnovation-shared.os.fyre.ibm.com/spring-boot-restful-post-xml/save-cust-info");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			//conn.setRequestProperty("Content-Type", "application/json");
			//conn.setRequestProperty("X-Authorization-Token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJibGFja2xpc3Rfa2V5IjoiQUIwNTc0ODA6Zk1OWVNMWERCd2hjUEpmYWZEb3FJUSIsImNsaWVudF9pZCI6IkFCMDU3NDgwIiwiY2xpZW50X3Rva2VuIjoiWndZeTVMTzZrMlVUMStZaUFBMy90ZyIsImRldmljZSI6IndlYiIsImV4cCI6MTU4MTYwMTY1MjQ2MX0.Q_pyFyDkgNdD-Fn5fQxI6L2Rc9-LGw8os0i0V3D2stE");
			String input = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><customer><country>United States</country><custNo>100</custNo><name>Google</name></customer>";
			//String input = "{\"exchange\":\"NFO\",\"order_type\":\"LIMIT\",\"instrument_token\":40113,\"quantity\":75,\"disclosed_quantity\":0,\"price\":100,\"transaction_type\":\"BUY\",\"trigger_price\":0,\"validity\":\"DAY\",\"product\":\"MIS\",\"source\":\"web\",\"order_tag\": \"order1\"}";
			//String input = "{\"exchange\":\"NFO\",\"order_type\":\"LIMIT\",\"instrument_token\":40112,\"quantity\":75,\"disclosed_quantity\":0,\"price\":100,\"transaction_type\":\"BUY\",\"validity\":\"DAY\",\"product\":\"BO\",\"source\":\"web\",\"order_tag\": \"order1\",\"square_off_value\":105,\"stop_loss_value\":95,\"trailing_stop_loss\":1}";

			
			
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			System.out.println(conn.getResponseMessage());
			
			/*if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}*/

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				outputVal = output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			  outputVal = e.getLocalizedMessage();

		  } catch (IOException e) {

			  outputVal = e.getLocalizedMessage();

		 }	
		return outputVal;
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
