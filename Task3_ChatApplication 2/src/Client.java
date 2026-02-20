import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server!");

        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true);

        BufferedReader console = new BufferedReader(
                new InputStreamReader(System.in));

        String message;

        while (true) {
            message = console.readLine();
            output.println(message);

            System.out.println("Server: " + input.readLine());
        }
    }
}