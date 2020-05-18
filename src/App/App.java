package App;

import Client.Client;

public class App {
    public static void main(String[] args) {
        Client client = Client.getInstance();
        client.app();
    }
}
