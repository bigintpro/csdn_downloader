package com.csdndownload.service;

import com.sun.istack.internal.NotNull;

import java.util.concurrent.CompletableFuture;

public interface CsdnDownloadService {

    /**
     * 下载csdn对应的资源
     * @param resourceId 资源ID
     * @param originUrl 资源url
     * @return 是否下载成功
     */
    CompletableFuture<Boolean> downloadResource(@NotNull String resourceId, String originUrl);
}
