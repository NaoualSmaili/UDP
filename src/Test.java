import java.net.*;
import java.io.*;
import java.util.*;

public class Test {
    public static void Q1(String[] args) {
        new Thread(new UDPServer()).start();
        new Thread(new UDPClient()).start();
    }

    public static void main(String[] args) {
        new Thread(new UDPServerHello()).start();
        new Thread(new UDPClientHello()).start();
    }
}