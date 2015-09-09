package com.onboard.service.notification;

import java.util.List;

import com.onboard.domain.mapper.model.NotificationExample;
import com.onboard.domain.model.Notification;

/**
 * {@link Notification} Service Interface
 * 
 * @author SERC
 * 
 */
public interface NotificationService {
    /**
     * Get item by id
     * 
     * @param id
     * @return item
     */
    Notification getNotificationById(int id);

    /**
     * Get item list
     * 
     * @param start
     * @param limit
     * @return the item list
     */
    List<Notification> getNotifications(int start, int limit);

    /**
     * 通过companyId和userId获取通知
     * 
     * @param companyId
     * @param userId
     * @param start
     * @param limit
     * @return
     */
    List<Notification> getNotificationsByCompanyIdAndUserId(int companyId, int userId, int start, int limit,
            boolean isRead);

    /**
     * Get item list by example
     * 
     * @param item
     * @param start
     * @param limit
     * @return the item list
     */
    List<Notification> getNotificationsBySample(Notification item, int start, int limit);

    /**
     * 通过NotificationExample获取Notification，并填充activity
     * 
     * @param example
     * @return
     */
    public List<Notification> getNotificationsByExample(NotificationExample example);

    /**
     * Get item count by example
     * 
     * @param item
     * @return the count
     */
    int countByExample(Notification item);

    /**
     * Create
     * 
     * @param item
     * @return the created Notification
     */
    Notification createNotification(Notification item);

    /**
     * Update
     * 
     * @param item
     * @return the updated item
     */
    Notification updateNotification(Notification item);

    /**
     * Delete
     * 
     * @param id
     */
    void deleteNotification(int id);

    /**
     * 获取notification的数量
     * 
     * @param userId
     * @return
     */
    int countNotificationsByUserIdAndCompanyId(int userId, int companyId, boolean isRead);
}
