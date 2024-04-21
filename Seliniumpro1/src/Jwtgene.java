import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class Jwtgene {

    public static void main(String[] args) {
    	 Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Generate a secure random key
 
         long expirationMs = 3600000; // Token expiration time in milliseconds (1 hour in this example)

         // Generate the JWT token
         String jwtToken = Jwts.builder()
                 .setSubject("user123") // Subject of the token
                 .setIssuedAt(new Date()) // Issue date
                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs)) // Expiration date
                 .signWith(key) // Sign with the secure random key
                 .compact();

         // Print the JWT token
         System.out.println("JWT Token: " + jwtToken);
    
    }
}
