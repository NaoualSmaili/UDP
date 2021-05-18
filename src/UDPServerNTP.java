import java.io.IOException;
import java.net.InetSocketAddress;

public class UDPServerNTP extends UDPServerBuilder implements Runnable {
    public UDPServerNTP() {
    }

    public void run() {
        try {
            this.setConnection();
            System.out.println("Server started ....");

            while (true) {
                this.req = this.getReceivingPacket(2048);
                this.s.receive(this.req);
                this.rep = this.getSendingPacket((InetSocketAddress) this.req.getSocketAddress(), 2048);
                this.s.send(this.rep);
            }
        } catch (IOException e) {
            this.s.close();
            System.out.println("Exception UDPServer");
        }
    }

}
