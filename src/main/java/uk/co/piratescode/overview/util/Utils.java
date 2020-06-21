package uk.co.piratescode.overview.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Level;
import uk.co.piratescode.overview.Main;
import uk.co.piratescode.overview.entitys.Server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {
    public static HashMap<Integer, Server> getServers() {
        return Main.servers;
    }

    public static Server getServerByName(String serverName) {
        Server outputServer = null;
        for (Server server : getServers().values()) {
            if (server.getServerName().equals(serverName)) {
                outputServer = server;
            }
        }
        return outputServer;
    }

    public static Server getServerByID(int id) {
        Server outputServer = null;
        for (Server server : getServers().values()) {
            if (server.getListID() == id) {
                outputServer = server;
            }
        }
        return outputServer;
    }

    public static boolean InitialStartup() {
        File servers = new File(Paths.get("").toAbsolutePath().toFile(), "/servers.json");
        return servers.exists();
    }

    public static void loadJsonServersFile() {
        File servers = new File(Paths.get("").toAbsolutePath().toFile(), "/servers.json");
        Gson gson = new Gson();

        if (!servers.exists()) {
            gson = new GsonBuilder().setPrettyPrinting().create();

            Server server = createServerObject(0);
            Server server2 = createServerObject(1);
            List<Server> serverList = new ArrayList<>();

            serverList.add(server);
            serverList.add(server2);

            // Java objects to String
            String json = gson.toJson(serverList);

            LoggingUtil.log(Level.INFO, json.replace("\n", "").replace("    ", "").replace("  ", ""));

            try {
                FileWriter writer = new FileWriter(servers);
                gson.toJson(serverList, writer);
                writer.close();
            } catch (IOException e) {
                LoggingUtil.log(Level.INFO, e.getMessage());
            }
        }
    }

    private static Server createServerObject(int id) {
        return new Server(id, "test" + id, "", 2222 + id, true);
    }
}
