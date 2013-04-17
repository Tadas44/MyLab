package lt.appcamp.lab.mylab06;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * WebServiceClient. Network communication client based on apache HttpPost
 * 
 * @see http://developer.android.com/reference/org/json/JSONObject.html
 * @see http://developer.android.com/reference/org/apache/http/client/methods/HttpPost.html
 * @author Vykintas Valkatis
 */
public class WebServiceClient {
	/** Singleton pattern instance */
	protected static WebServiceClient sInstance = null;

	/** api base url */
	// Development
	protected static final String API_URL = "http://search.twitter.com/";

	/** webservice list */
	protected static final String WS_SEARCH = "search.json";

	/**
	 * Constructor, protected from public call use getInstance
	 */
	protected WebServiceClient() {}

	/**
	 * Get WebServiceClient instance (Singleton pattern)
	 * 
	 * @return instance
	 */
	public static WebServiceClient getInstance() {
		// create new object
		if (sInstance == null) {
			sInstance = new WebServiceClient();
		}

		return sInstance;
	}

	/**
	 * Search for tweets
	 * 
	 * @return JSONObject response
	 */
	public JSONObject search(String query) {
		// build params list
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		
		// query
		params.add(new BasicNameValuePair("q", String.valueOf(query)));
		
		// results per page
		params.add(new BasicNameValuePair("rpp", "10"));
		
		// additional params
		params.add(new BasicNameValuePair("include_entities", "1"));
		params.add(new BasicNameValuePair("result_type", "mixed"));

		// get webservice url
		String url = getWebserviceUrl(WS_SEARCH);

		return getJSONResponse(url, params);
	}

	/**
	 * Get JSONObject output from url
	 * 
	 * @param url
	 * @param params
	 * @return JSONObject response
	 */
	private JSONObject getJSONResponse(String url, ArrayList<BasicNameValuePair> params) {
		// default output
		JSONObject output = new JSONObject();

		// get response
		String response = makeRequest(getHttpPost(url, params));

		// try parsing response
		try {
			output = new JSONObject(response);
		} catch (JSONException e) {
			// TODO implement exception handling
		}

		return output;
	}

	/**
	 * Make http request and return String response
	 * 
	 * @param post
	 *            - formated http post request object
	 * @return string request response
	 */
	private String makeRequest(HttpPost post) {
		// http client
		DefaultHttpClient client = new DefaultHttpClient();

		// default output
		String output = "";

		try {
			// get response entity
			HttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			output = EntityUtils.toString(entity);

		} catch (UnsupportedEncodingException e) {
			// TODO implement exception handling
		} catch (ClientProtocolException e) {
			// TODO implement exception handling
		} catch (IOException e) {
			// TODO implement exception handling
		}

		return output;
	}

	/**
	 * Get http post object
	 * 
	 * @param url
	 *            - request url
	 * @param params
	 *            - request params
	 * @return HttpPost
	 */
	private HttpPost getHttpPost(String url, ArrayList<BasicNameValuePair> params) {
		String body = URLEncodedUtils.format(params, "utf-8");
		return new HttpPost(url + "?" + body);
	}

	/**
	 * Get full url to webservice
	 * 
	 * @param webservice
	 * @return String url
	 */
	private String getWebserviceUrl(String webservice) {
		return API_URL + webservice;
	}
}