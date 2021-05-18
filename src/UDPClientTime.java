import java.io.IOException;

public class UDPClientTime extends UDPClientBuilder implements Runnable{
    private long ts0;
    private long ts1;
    private long ts2;

    public UDPClientTime() {
    }

    @Override
    public void run() {
        try {
            this.setConnection();
            this.ts0 = this.getTimeStamp();

            while(true) {
                this.req = this.getSendingPacket(this.isA, 2048);
                this.s.send(this.req);
                System.out.println("Client :- Time sent T1");
                this.ts1 = this.getTimeStamp();
                this.rep = this.getReceivingPacket(2048);
                this.s.receive(this.rep);
                System.out.println("Client :- Time recieved T4");
                this.ts2 = this.getTimeStamp(this.rep);
                System.out.println(this.tos(this.ts1 - this.ts0) + "\t s \t" + (this.ts2 + 1L - this.ts1) + "\t ms");
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            this.s.close();
            System.out.println("Exception UDPClient");
        }
    }

    private double tos(long var1) {
        return (double)var1 / 1000.0D;
    }
}
