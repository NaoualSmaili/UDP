import java.net.InetSocketAddress;
import java.io.IOException;


public class UDPServerTime  extends UDPServerBuilder implements Runnable{

    public UDPServerTime() {
    }

    @Override
    public void run() {
        try {
            this.setConnection();
            System.out.println("Server waiting ....");

            while(true) {
                this.req = this.getReceivingPacket(2048);
                this.s.receive(this.req);
                System.out.println("Server :- Time recieved T2");
                this.rep = this.getSendingPacket((InetSocketAddress)this.req.getSocketAddress(), 2048);
                this.setTimeStamp(this.rep);
                this.s.send(this.rep);
                System.out.println("Server :- Time sent T3");
            }
        } catch(IOException e) {
            this.s.close();
            System.out.println("Exception UDPServer");
        }
    }
}
