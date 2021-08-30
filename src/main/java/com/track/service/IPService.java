package com.track.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class IPService {
	
	public String getInfo(String ipAddress) {
		StringBuilder result = new StringBuilder();
		try {
			URL url = new URL("https://api.ipgeolocation.io/ipgeo?apiKey=450193c644c24df29366b33d6b6bd0fc&ip=" + ipAddress);
		      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		      conn.setRequestMethod("GET");
		      try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
		          for (String line; (line = reader.readLine()) != null; ) {
		              result.append(line);
		          }
		      }
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	    return result.toString();
	}
}
