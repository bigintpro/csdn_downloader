package com.csdndownload.service.impl;

import com.csdndownload.service.CsdnDownloadService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CsdnDownloadServiceImpl implements CsdnDownloadService {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public CompletableFuture<Boolean> downloadResource(String resourceId, String originUrl) {

        return CompletableFuture.supplyAsync(() -> {
            List<Long> excludeAccountIds = new ArrayList<>();
            String lockPath = "csdn_" + resourceId;
            Lock lock = LockFactory.getInstance(lockPath);

            Boolean result = downloadResource(resourceId,originUrl, excludeAccountIds, 1, lock);
            try {
                lock.close();
            }catch (Exception e){
                log.error("downloadResource error happened:{}",e.getMessage(),e);
            }
            return result;

        }, threadPoolTaskExecutor);
    }
}
