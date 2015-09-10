/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
