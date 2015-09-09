package com.onboard.service.websocket;

import java.io.IOException;

import org.apache.catalina.websocket.MessageInbound;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Notification;
import com.onboard.domain.model.User;

/**
 * 提供WebSocket相关的服务
 * 
 * @author Gourui
 * 
 */
public interface WebSocketService {

    public void registerClient(String user, MessageInbound inbound);

    public void unregisterClient(String user, MessageInbound inbound);

    /**
     * 将信息发送给某个特定用户的所有页面
     * 
     * @param user
     * @param actionMap
     */
    public void broadcastOne(String user, Activity activity);

    public void broadcastOne(String user, String message);

    public void broadcastOne(User user, Object object);

    /**
     * 对所有已经注册了websocket连接的页面发送消息
     * 
     * @throws IOException
     */
    public void broadcastAll(Activity activity);

    /**
     * 对单个websocket连接对应的页面发送消息
     * 
     * @param inbound
     * @param message
     * @throws IOException
     */
    public void sendToPage(MessageInbound inbound, String message) throws IOException;

    void broadcastOne(String user, Notification notification);

}
