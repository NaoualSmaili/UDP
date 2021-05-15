import java.io.IOException;

class UDPClientTimeout extends UDPClientBuilder implements Runnable {
    UDPClientTimeout() {
    }

    public void run() {
        try {
            setConnection();
            socketInfo("client sets the connection", s);
            s.close();
            socketInfo("client closes the connection", s);
        } catch (IOException e) {
            System.out.println("Exception UDPClient");
        }

    }
}