package nl.maastrichtuniversity.networklibrary.CyNetLibSync.internal.ResponseHandlers;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.codehaus.jackson.map.ObjectMapper;

public class TransactionResponseHandler implements ResponseHandler<String> {

	@Override
	public String handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {

//		{
//			  "commit": "http:\/\/localhost:7474\/db\/data\/transaction\/13\/commit",
//			  "results": [
//			    
//			  ],
//			  "transaction": {
//			    "expires": "Tue, 28 Jan 2014 14:02:29 +0000"
//			  },
//			  "errors": [
//			    
//			  ]
//			}
		int responseCode = response.getStatusLine().getStatusCode();
		String commitLocation = null;
		
		if(responseCode >= 200 && responseCode < 300){

			ObjectMapper mapper = new ObjectMapper();
			Map<String,Object> transactionInfo = mapper.readValue(response.getEntity().getContent(), Map.class);

			commitLocation =  (String)transactionInfo.get("commit");
			
		} else {
			System.out.println("ERROR " + responseCode);
			ObjectMapper mapper = new ObjectMapper();

			Map<String,String> error = mapper.readValue(response.getEntity().getContent(),Map.class);
			System.out.println(error);
		}
		
		return commitLocation;
	}

}
