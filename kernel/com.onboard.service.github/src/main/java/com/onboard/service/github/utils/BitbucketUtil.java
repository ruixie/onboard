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
package com.onboard.service.github.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class BitbucketUtil {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    public static final String mixings = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();

        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        return formatter.toString();
    }

    // oauth_signature
    public static String calculateRFC2104HMAC(String secret, String key) throws SignatureException,
            NoSuchAlgorithmException, InvalidKeyException {
        long epoch = System.currentTimeMillis() / 1000L;
        String keyPlusEpoch = String.valueOf(epoch) + key;
        SecretKeySpec signingKey = new SecretKeySpec(keyPlusEpoch.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        return toHexString(mac.doFinal(secret.getBytes()));
    }

    // oauth_nonce
    public static String createRandomString(int length) {

        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(mixings.charAt(random.nextInt(mixings.length())));
        }
        return sb.toString();
    }

}
