package ru.geekbrains.homework6.server;

import ru.geekbrains.homework6.Handler;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerApp {
    private static final int PORT = 8290;
    private boolean VERBOSE;

    ServerApp(int port) {
        this.VERBOSE = true;
    }

    ServerApp(int port, boolean verbose) {
        this(port);
        this.VERBOSE = verbose;
    }

    void start() {
        try (ServerSocket server = new ServerSocket(PORT)) {

            if (VERBOSE) System.out.println("Сервер запущен, ожидаем подключения...");

            try (Socket socket = server.accept()) {

                if (VERBOSE) System.out.println("Клиент подключился");

                new Handler(socket, "Client");

            } catch (IOException e) {
                System.out.println("Ошибка запуска сервера");
            }
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        }
    }
}
