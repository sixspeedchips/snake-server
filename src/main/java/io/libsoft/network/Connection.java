package io.libsoft.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements Runnable {

  private final Socket socket;
  private ObjectOutputStream writer;
  private ObjectInputStream reader;
  private boolean running;

  private Connection(Socket socket) {
    this.socket = socket;
    try {
      writer = new ObjectOutputStream(socket.getOutputStream());
      reader = new ObjectInputStream(socket.getInputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
    new Thread(this).start();
  }


  public void sendMessage(String message){
    try {
      writer.writeBytes(message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static Connection from(Socket accepted) {
    Connection connection = new Connection(accepted);
    return connection;
  }



  @Override
  public void run() {
    running = true;
    while (running) {
      String message;

      try {
        message = reader.readUTF();
        System.out.println(message);
      } catch (IOException e) {
        e.printStackTrace();
      }


    }


  }
}
