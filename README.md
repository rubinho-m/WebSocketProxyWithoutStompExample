# What it for?
I tried to find an implementation of fetching a remote websocket server from a Java server without using the STOMP but I couldn't. Therefore, I wrote my own version of the solution to this problem
##
Explanation
### WebSocketConfig
Just a simple WebSocket configuration: we register an endpoint and a handler for it.
### MessageHandler
The handler that will handle requests from the user.
### EchoServerHandler
The handler that will handle requests from the remote server.
### Sessions
The data class which contains actual sessions for user and remote server.
### WebSocketService
Contains one method for handshake with a remote server.
## Usage
![](https://github.com/rubinho-m/WebSocketProxyWithoutStompExample/blob/master/media/ws.gif)
