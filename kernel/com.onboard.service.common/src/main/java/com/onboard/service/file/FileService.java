package com.onboard.service.file;


/**
 * {@link File} 相关服务，文件保存与获取。
 * 
 * @author yewei
 * 
 */
public interface FileService {

    /**
     * 读取指定路径的文件，请注意文件路径中的分隔符务必使用平台无关的{@link File.separator}
     * @param path
     * @return
     */
    byte[] readFile(String path);

    /**
     * 将文件存储指定路径，请注意文件路径中的分隔符务必使用平台无关的{@link File.separator}
     * @param path
     * @param data
     * @return
     */
    boolean writeFile(String path, byte[] data);

    /**
     * 删除指定路径的文件，请注意文件路径中的分隔符务必使用平台无关的{@link File.separator}
     * @param path
     * @return
     */
    boolean deleteFile(String path);
    
    /**
     * 修改文件路径
     * @param path 原路径
     * @param newPath 新路径
     * @param auto 是否自动创建目录
     * @return
     */
    boolean renameFile(String path, String newPath, boolean auto);
}
