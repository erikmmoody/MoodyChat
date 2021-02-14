package com.moody.chat.resources;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.moody.chat.api.Message;

@Path("/connect")
@ServerEndpoint("/connect")
@Produces(MediaType.APPLICATION_JSON)
public class ConnectionResource {
    
    private Session session;


    @OnOpen
    public void onOpen(Session session) throws IOException {
        this.session = session;
        
        Message message = new Message(0, "you", "session opened: " + session.getId());
        sendResponse(message);
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws IOException {
        
    }

    @OnClose
    public void onClose(Session session) throws IOException {

    }

    @OnError
    public void onError(Session session, Throwable throwable) {

    }

    private void sendResponse(Message message) {
        try {
            this.session.getBasicRemote()
            .sendObject(message);
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }
        
    }
}
