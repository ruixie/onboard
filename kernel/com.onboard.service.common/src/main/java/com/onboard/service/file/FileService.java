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
