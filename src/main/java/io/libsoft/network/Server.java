package io.libsoft.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {


  private final Thread thread;
  private ServerSocket serverSocket;
  private final ClientManager clientManager;
  private boolean running;

  public Server() {
    clientManager = new ClientManager();

    try {
      serverSocket = new ServerSocket(10000, 2, InetAddress.getLoopbackAddress());
    } catch (IOException e) {
      e.printStackTrace();
    }
    thread = new Thread(this);
    thread.start();
  }

  public static Server start() {
    return InstanceHolder.INSTANCE;
  }

  @Override
  public void run() {
    running = true;
    System.out.println("Listening on " + serverSocket.getInetAddress());

    Socket accepted;
    while (running) {
      try {
        accepted = serverSocket.accept();
        clientManager.addClient(accepted);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  static class InstanceHolder {

    private static final Server INSTANCE;

    static {
      INSTANCE = new Server();
    }
  }


}
