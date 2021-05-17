import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

class UDPServerBuilder extends UDPRWText  {
    InetSocketAddress isA;
    DatagramSocket s;
    DatagramPacket req, rep;
    final int size = 2048;
    private int timer = 4000;

    UDPServerBuilder() {
        isA = null;
        s = null;
        req = rep = null;
    }

    protected void setConnection() throws IOException {
        isA = new InetSocketAddress("localhost", 8083);
        s = new DatagramSocket(isA.getPort());
        s.setSoTimeout(this.timer);
    }
}
