package com.onboard.service.notification;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.type.IdentifiableOperator;
import com.onboard.domain.model.type.Subscribable;

/**
 * 通知规则，用于判断是否需要发送通知
 * 
 * @author yewei
 * 
 */
public interface NotificationRule extends IdentifiableOperator {

    boolean ifNotify(Activity activity, Subscribable subscribable);

    boolean ifNotify(Activity activity, Subscribable original, Subscribable updated);

}
