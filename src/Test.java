import java.net.*;
import java.io.*;
import java.util.*;

public class Test {
    public static void Q1(String[] args) {
        new Thread(new UDPServer()).start();
        new Thread(new UDPClient()).start();
    }

    public static void Q2(String[] args) {
        new Thread(new UDPServerHello()).start();
        new Thread(new UDPClientHello()).start();
    }

    public static void Q3(String[] args) {
        new Thread(new UDPServerInfo()).start();
        new Thread(new UDPClientInfo()).start();
    }

    public static void Q4(String[] args) {
        new Thread(new UDPServerTimeout()).start();
        new Thread(new UDPClientTimeout()).start();
    }

    public static void Q5(String[] args) {
        new Thread(new UDPServerMsg()).start();
        new Thread(new UDPClientMsg()).start();
    }

    public static void Q6(String[] args) {
        new Thread(new UDPServerChat()).start();
        new Thread(new UDPClientChat()).start();
    }

    public static void main(String[] args) {
        new Thread(new UDPServerTime()).start();
        new Thread(new UDPClientTime()).start();
    }

}