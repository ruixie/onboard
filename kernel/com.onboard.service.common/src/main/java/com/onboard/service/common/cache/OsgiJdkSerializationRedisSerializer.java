package com.onboard.service.common.cache;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * custom deserializer for OSGI environment
 * 
 * @author XingLiang
 * 
 */
public class OsgiJdkSerializationRedisSerializer extends JdkSerializationRedisSerializer {

    @Override
    public Object deserialize(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes)) {
                Set<ClassLoader> classLoaders = new LinkedHashSet<ClassLoader>();
                {
                    classLoaders.add(getClass().getClassLoader());
                    classLoaders.add(com.onboard.dto.ActivityDTO.class.getClassLoader());
                }

                @Override
                protected Class<?> resolveClass(ObjectStreamClass desc) throws ClassNotFoundException, IOException {
                    String name = desc.getName();
                    for (ClassLoader classLoader : classLoaders)
                        try {
                            Class<?> c = classLoader.loadClass(name);
                            return c;
                        } catch (Exception e) {
                        }

                    return super.resolveClass(desc);
                }
            };

            return objectInputStream.readObject();
        } catch (Exception ex) {
            throw new SerializationException("Cannot deserialize", ex);
        }
    }

}
