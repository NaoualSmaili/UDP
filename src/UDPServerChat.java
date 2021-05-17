import java.io.IOException;
import java.net.InetSocketAddress;

public class UDPServerChat extends UDPServerBuilder implements Runnable {
    private String msg;

    public UDPServerChat() {
    }

    @Override
    public void run() {
        try {
            setConnection();
            while(true) {
                System.out.println("Server waiting...");
                this.req = this.getReceivingPacket(2048);
                this.s.receive(this.req);
                System.out.println("\nrequest received");
                this.msg = this.getMsg(this.req);
                System.out.print("Client:- " + this.msg + "\n");
                if (msg.equals("bye"))
                {
                    System.out.println("Client sent bye.....EXITING");
                    break;
                }
                this.rep = this.getSendingPacket((InetSocketAddress)this.req.getSocketAddress(), 2048);
                this.s.send(this.rep);
                System.out.println("reply sent");
            }

        } catch (IOException e) {
            s.close();
            System.out.println("\nException UDPServer");
        }
    }

}
