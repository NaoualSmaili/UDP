import java.io.IOException;

public class UDPClientNTP extends UDPClientBuilder implements Runnable {
    private long ts0;
    private long ts1;

    public UDPClientNTP() {
    }

    public void run() {
        try {
            this.setConnection();

            while (true) {
                this.req = this.getSendingPacket(this.isA, 2048);
                this.ts0 = this.getLocalTime();
                this.s.send(this.req);
                this.rep = this.getReceivingPacket(2048);
                this.s.receive(this.rep);
                this.ts1 = this.getLocalTime();
                System.out.println(this.toms(this.ts1 - this.ts0) + "\t ms");
                Thread.sleep(250L);
            }
        } catch (IOException | InterruptedException e) {
            this.s.close();
            System.out.println("Exception UDPClient");
        }

    }

    private double toms(long var1) {
        return (double) var1 / 1000000.0D;
    }
}
