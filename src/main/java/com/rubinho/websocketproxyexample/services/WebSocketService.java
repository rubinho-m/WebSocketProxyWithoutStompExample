package com.rubinho.websocketproxyexample.services;

import com.rubinho.websocketproxyexample.ws.EchoServerHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class WebSocketService {
    private final String URI = "wss://echo.websocket.org";


    public void connectToEchoServer() throws ExecutionException, InterruptedException {
        StandardWebSocketClient webSocketClient = new StandardWebSocketClient();
        webSocketClient.execute(new EchoServerHandler(), URI).get();


    }


}