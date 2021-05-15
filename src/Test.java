import java.net.*;
import java.io.*;
import java.util.*;
public class Test {
    public static void main (String[] args) {
        new Thread(new UDPServer()).start();
        new Thread(new UDPClient()).start();
    }
} 