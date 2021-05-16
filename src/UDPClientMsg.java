import java.io.IOException;

class UDPClientMsg extends UDPClientBuilder implements Runnable {
    private String msg;

    public UDPClientMsg() {
    }

    @Override
    public void run() {
        try {
            setConnection();
            req = getSendingPacket(isA, 2048);
            System.out.println("Packet sent");
            setMsg(req, "Hi it's Lamia");
            s.send(req);
            System.out.println("message sent");
        } catch (IOException e) {
            System.out.println("Exception UDPClient");
        }finally {
            s.close();
            System.out.println("connexion closed");
        }
    }
}
