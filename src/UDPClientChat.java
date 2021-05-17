import java.io.IOException;
import java.util.Scanner;

public class UDPClientChat extends UDPClientBuilder implements Runnable{
    private Scanner sc;
    private String msg;

    public UDPClientChat() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        try {
            setConnection();
            while(true) {
                System.out.print("Enter the message: ");
                this.msg = this.sc.nextLine();
                this.req = this.getTextSendingPacket(this.isA, this.msg, 2048);
                this.s.send(this.req);
                System.out.println("request sent");
                if (msg.equals("bye"))
                    break;
                this.rep = this.getReceivingPacket(2048);
                this.s.receive(this.rep);
                System.out.println("reply received");
            }

        } catch (IOException e) {
            sc.close();
            s.close();
            System.out.println("\nException UDPClient");
        }
    }
}
