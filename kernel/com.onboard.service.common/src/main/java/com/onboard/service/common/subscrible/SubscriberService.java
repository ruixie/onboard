package com.onboard.service.common.subscrible;

import java.util.List;

import com.onboard.domain.model.Subscriber;
import com.onboard.domain.model.User;
import com.onboard.domain.model.type.Subscribable;

/**
 * {@link Subscriber}服务接口
 * 
 * @author yewei
 * 
 */
public interface SubscriberService {
    /**
     * 根据id获取Subscriber对象
     * 
     * @param id
     *            Subscriber id
     * @return
     */
    Subscriber getSubscriberById(int id);

    /**
     * 获取一个topic的订阅用户
     * 
     * @param id
     *            Subscriber id
     * @return
     */
    List<User> getSubscribeUsersByTopic(String subscribeType, int subscribeId);

    /**
     * Get item count by example
     * 
     * @param item
     * @return the count
     */
    int countByExample(Subscriber item);

    /**
     * 填充Subscribable对象
     * 
     * @param subscribable
     */
    void fillSubcribers(Subscribable subscribable);

    /**
     * 增加subscriber对象
     * 
     * @param type
     * @param id
     * @param usersId
     */
    void addSubscribers(Subscribable subscribable);

    /**
     * 根据topic获取Subscriber对象
     * 
     * @param subscribeType
     * @param subscribeId
     * @return
     */
    List<Subscriber> getSubscribersByTopic(String subscribeType, int subscribeId);

    /**
     * 创建一个Subscriber对象
     * 
     * @param bubscriber
     * @return 返回创建的Subscriber对象，包括数据库中的id
     */
    Subscriber createSubscriber(Subscriber bubscriber);

    /**
     * 更新Subscriber
     * 
     * @param bubscriber
     * @return
     */
    Subscriber updateSubscriber(Subscriber bubscriber);

    /**
     * 删除Subscriber
     * 
     * @param id
     */
    void deleteSubscriber(int id);

    /**
     * 根据实例删除subscr
     * 
     * @param subscriber
     */
    void deleteSubscriberByExample(Subscriber subscriber);

    /**
     * 根据表单数据生成subscriber列表，同时需要包含当前用户
     * 
     * @param subscribers
     * @param defaultUser
     *            当前用户
     * @return
     */
    void generateSubscribers(Subscribable subscribable, User defaultUser);

    /**
     * 根据类型和id获取Subscribable对象
     * 
     * @param type
     * @param id
     * @return
     */
    Subscribable getSubscribleByTypeAndId(String type, Integer id);

    /**
     * 根据subscribable更新其提醒用户
     * 
     * @param subscribable
     * @return
     */
    void updateSubscribers(Subscribable subscribable);

}
