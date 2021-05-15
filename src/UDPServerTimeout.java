import java.io.IOException;

class UDPServerTimeout extends UDPServerBuilder implements Runnable {
    UDPServerTimeout() {
    }

    public void run() {
        try {
            setConnection();
            socketInfo("Server sets the connection", s);
            s.close();
            socketInfo("Server closes the connection", s);
        } catch (IOException e) {
            System.out.println("Exception UDPServer");
        }

    }
}
