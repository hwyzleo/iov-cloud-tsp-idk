package net.hwyz.iov.cloud.tsp.idk.api.feign.service.factory;

import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.idk.api.contract.request.BatchImportBtmRequest;
import net.hwyz.iov.cloud.tsp.idk.api.feign.service.ExBtmInfoService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 蓝牙模块信息相关服务降级处理
 *
 * @author hwyz_leo
 */
@Slf4j
@Component
public class ExBtmInfoServiceFallbackFactory implements FallbackFactory<ExBtmInfoService> {

    @Override
    public ExBtmInfoService create(Throwable throwable) {
        return new ExBtmInfoService() {
            @Override
            public void batchImport(BatchImportBtmRequest request) {
                logger.error("蓝牙模块信息相关服务批量导入蓝牙模块数据[{}]调用异常", request.getBatchNum(), throwable);
            }
        };
    }
}
