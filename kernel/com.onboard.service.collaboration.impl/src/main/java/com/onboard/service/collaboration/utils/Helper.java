package com.onboard.service.collaboration.utils;

import java.io.IOException;

/**
 * 工具类
 * 
 * @author huangsz, yewei
 * 
 */
public class Helper {
    /**
     * 从本地文件系统中删除文件删除文件 与File.service的FileUtils重复，建议将file.service也归并到collaboration.service @huangsz
     * 
     * @param name
     * @param path
     * @throws IOException
     */
    public static void deleteFileFromDisk(String name, String path) throws IOException {
        java.io.File file = new java.io.File(path + name);
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }
}
