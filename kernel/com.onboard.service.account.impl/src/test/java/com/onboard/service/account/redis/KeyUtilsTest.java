package com.onboard.service.account.redis;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by luoruici on 13-12-12.
 */
@RunWith(JUnit4.class)
public class KeyUtilsTest {

    @Test(expected = NullPointerException.class)
    public void userTokenWithNullType() {
        KeyUtils.userToken(null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void userTokenWithNullUid() {
        KeyUtils.userToken(new String(), null);
    }

    @Test(expected = NullPointerException.class)
    public void userTokenWithNullTypeAndUid() {
        KeyUtils.userToken(null, null);
    }

    @Test
    public void userToken() {
        String type = "type";
        Integer uid = 1;
        String result = KeyUtils.userToken(type, uid);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.startsWith("account:"));
        assertTrue(result.contains(type));
        assertTrue(result.contains(String.valueOf(uid)));
    }

}
