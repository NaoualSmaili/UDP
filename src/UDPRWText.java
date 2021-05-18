import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;

class UDPRWText extends UDPRWTime {
    public UDPRWText() {
    }

    /**
     * The buffer array.
     */
    private byte[] sB;

    /**
     * To create a sending packet send with a txt message.
     */
    protected DatagramPacket getTextSendingPacket(InetSocketAddress isA, String msg, int size) throws
            IOException {
        sB = toBytes(msg, new byte[size]);
        return new DatagramPacket(sB, 0, sB.length, isA.getAddress(), isA.getPort());
    }

    /**
     * To set the Msg to a parametter packet.
     */
    protected void setMsg(DatagramPacket dP, String msg) throws IOException {
        toBytes(msg, dP.getData());
    }

    private byte[] toBytes(String msg, byte[] lbuf) {
        array = msg.getBytes();
        if (array.length < lbuf.length)
            System.arraycopy(array, 0, lbuf, 0, array.length);
        return lbuf;
    }

    private byte[] array;

    /**
     * To extract the txt message from a packet.
     */
    protected String getMsg(DatagramPacket dP) {
        sB = dP.getData();
        for (int i = 0; i < sB.length; i++) {
            if (sB[i] == 0) {
                p = i;
                i = sB.length;
            }
        }
        return new String(dP.getData(), 0, p);
    }

    private int p;

    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
