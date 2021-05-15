import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

class UDPServerBuilder extends UDPInfo  {
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
        s = new DatagramSocket();
        s.setSoTimeout(this.timer);
        isA = new InetSocketAddress("localhost", 8083);
    }
}
