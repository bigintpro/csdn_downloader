package com.csdndownload.common;

public class ComUtils {

    /**
     * 获取处理器数量
     * @return
     */
    public static int getProcessorCount(){

        return Runtime.getRuntime().availableProcessors();
    }

}
