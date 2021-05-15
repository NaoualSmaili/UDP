import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

class UDPServerHello extends UDPServerBuilder implements Runnable {
    public void run() {
        try {
            setConnection();
            s = new DatagramSocket(isA.getPort());
            req = new DatagramPacket(new byte[size], size);
            s.receive(req);
            System.out.println("request received");
            rep = new DatagramPacket(new byte[size], 0, size, req.getSocketAddress());
            s.send(rep);
            System.out.println("reply sent");
            s.close();
        } catch (IOException e) {
            System.out.println("Exception UDPServer");
        }
    }

}
