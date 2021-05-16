import java.io.IOException;

class UDPServerMsg extends UDPServerBuilder implements Runnable {
    private String msg;

    public UDPServerMsg() {
    }

    @Override
    public void run() {
        try {
            setConnection();

            while(true) {
                System.out.println("UDPServerMsg waiting ....");
                System.out.printf("Listening on udp:%s:%d%n", isA.getAddress(), isA.getPort());
                this.req = this.getReceivingPacket(2048);
                System.out.println("Packet recieved ");
                this.s.receive(this.req);
                System.out.println("Request recieved");
                this.msg = this.getMsg(this.req);
                System.out.println(this.msg);
            }
        } catch (IOException e) {
            this.s.close();
            System.out.println("Exception UDPServer");
            e.getStackTrace();
        }
    }
}
