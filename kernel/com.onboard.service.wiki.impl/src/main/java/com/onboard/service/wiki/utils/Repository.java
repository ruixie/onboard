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
package com.onboard.service.wiki.utils;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component("documentRepository")
public class Repository {

    @Autowired
    private StringRedisTemplate template;

    private ValueOperations<String, String> valueOps;

    @PostConstruct
    public void init() {
        valueOps = template.opsForValue();
    }

    public int getUidOfLocker(int documentId) {
        String value = valueOps.get(KeyUtils.documentLockKey(documentId));
        if (value == null) {
            return 0;
        }

        return Integer.parseInt(value);
    }

    public void lockDocument(int documentId, int userId, int timeout) {
        valueOps.set(KeyUtils.documentLockKey(documentId), String.valueOf(userId), timeout, TimeUnit.SECONDS);
    }

    public void updateLockerOfDocument(int documentId, int timeout) {
        template.expire(KeyUtils.documentLockKey(documentId), timeout, TimeUnit.SECONDS);
    }

    public void unlockDocument(int documentId) {
        template.delete(KeyUtils.documentLockKey(documentId));
    }
}
