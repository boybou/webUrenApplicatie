package Api.model;

/**
 * Created by Wytze.
 * this model represents the client
 */
public class Client {
    String client_name;

    public Client(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_name() {
        return client_name;
    }
}
