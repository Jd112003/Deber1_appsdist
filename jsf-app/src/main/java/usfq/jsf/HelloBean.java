package usfq.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Named
@RequestScoped
public class HelloBean {
    
    private String message;
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void fetchMessage() {
        try {
            // URL del servicio REST en el contenedor rest-app
            String restUrl = "http://rest-app:8080/rest-app/api/hello";
            URL url = new URL(restUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/plain");
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            StringBuilder response = new StringBuilder();
            
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            
            conn.disconnect();
            this.message = response.toString();
            
        } catch (Exception e) {
            this.message = "Error: " + e.getMessage();
            e.printStackTrace();
        }
    }
}
