package com.archlogixdevelopertest.controllers;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.archlogixdevelopertest.models.WorkDetail;

public class PostController {

	public static void logHours(int id, ArrayList<WorkDetail> work) {
		for(WorkDetail detail : work) {
			String parameters = "";
			try {			
				URL url = new URL("http://www.eacdata.com/employee/loghours");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				parameters = "{\"id\":" + id + ","
					+ "\"date\":\"" + detail.getDate() + "\","
					+ "\"hours\":" + detail.getHours() + "}";
				System.out.println(parameters);
				conn.setDoOutput(true);
				DataOutputStream os = new DataOutputStream(conn.getOutputStream());
				os.writeBytes(parameters);
				os.flush();
				os.close();
				int responseCode = conn.getResponseCode();
				System.out.println("Sending POST request to URL: " + url);
				System.out.println("Data: " + parameters);
				System.out.println("Response code: " + responseCode);
				conn.disconnect();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			  } catch (IOException e) {
				e.printStackTrace();
			  }	
		}
	}
	
	public static void clearHours() {
		try {			
			URL url = new URL("http://www.eacdata.com/employee/clear");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			DataOutputStream os = new DataOutputStream(conn.getOutputStream());
			os.writeBytes("");
			os.flush();
			os.close();
			int responseCode = conn.getResponseCode();
			System.out.println("Sending POST request to URL: " + url);
			System.out.println("Response code: " + responseCode);
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }
	}
	
}
