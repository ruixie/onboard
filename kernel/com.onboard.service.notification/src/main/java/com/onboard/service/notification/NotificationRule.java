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
