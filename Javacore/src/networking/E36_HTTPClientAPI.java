/**
 * Exercise 36: HTTP Client API (Java 11+)
 * Objective: Make HTTP requests from Java.
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class E36_HTTPClientAPI {
    public static void main(String[] args) {
        try {
            // Example 1: Simple GET request
            System.out.println("=== HTTP GET Request ===\n");
            makeGETRequest("https://jsonplaceholder.typicode.com/posts/1");
            
            // Example 2: Get JSON response
            System.out.println("\n=== JSON Response ===\n");
            makeGETRequest("https://jsonplaceholder.typicode.com/users/1");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void makeGETRequest(String urlString) throws Exception {
        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();
        
        // Create HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(urlString))
                .GET()
                .build();
        
        // Send request and get response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        // Display response
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body:\n" + response.body());
    }
}

/**
 * Alternative: Using external JSON library (Jackson)
 * 
 * If you want to parse JSON, add Jackson dependency:
 * maven: com.fasterxml.jackson.core:jackson-databind
 * 
 * Example parsing code:
 * 
 * import com.fasterxml.jackson.databind.JsonNode;
 * import com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * ObjectMapper mapper = new ObjectMapper();
 * JsonNode jsonNode = mapper.readTree(response.body());
 * String userId = jsonNode.get("userId").asText();
 */
