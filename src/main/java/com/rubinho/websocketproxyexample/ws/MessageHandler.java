package com.rubinho.websocketproxyexample.ws;

import com.rubinho.websocketproxyexample.services.WebSocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
public class MessageHandler implements WebSocketHandler {
    private final WebSocketService webSocketService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws ExecutionException, InterruptedException {
        Sessions.clientSession = session;
        webSocketService.connectToEchoServer();
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        Sessions.serverSession.sendMessage(message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        Sessions.serverSession.close();
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


}