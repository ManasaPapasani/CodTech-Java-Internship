/*
 * CodTech Internship - Task 2
 * REST API Client
 * This program:
 * 1. Sends HTTP GET request
 * 2. Receives JSON response
 * 3. Parses JSON data
 * 4. Displays structured output
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class RestApiClient {

    public static void main(String[] args) {

        try {

            // STEP 1: API URL (using your name)
            String urlString = "https://api.agify.io/?name=manasa";
            URL url = new URL(urlString);

            // STEP 2: Open HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // STEP 3: Read API response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }

            reader.close();

            // STEP 4: Convert response to JSON
            JSONObject jsonObject = new JSONObject(response.toString());

            // STEP 5: Extract values from JSON
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            int count = jsonObject.getInt("count");

            // STEP 6: Display structured output
            System.out.println("----- API RESULT -----");
            System.out.println("Name           : " + name);
            System.out.println("Predicted Age  : " + age);
            System.out.println("Count          : " + count);

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
