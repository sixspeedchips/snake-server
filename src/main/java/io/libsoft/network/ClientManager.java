package io.libsoft.network;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ClientManager {


  private Map<UUID, Connection> connectionMap = new HashMap<>();

  public void addClient(Socket accepted) {
    UUID uuid = UUID.randomUUID();
    connectionMap.put(uuid, Connection.from(accepted));


  }
}
