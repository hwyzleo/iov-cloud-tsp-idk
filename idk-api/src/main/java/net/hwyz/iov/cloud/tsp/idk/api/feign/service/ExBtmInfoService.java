package net.hwyz.iov.cloud.tsp.idk.api.feign.service;

import net.hwyz.iov.cloud.framework.common.constant.ServiceNameConstants;
import net.hwyz.iov.cloud.tsp.idk.api.contract.request.BatchImportBtmRequest;
import net.hwyz.iov.cloud.tsp.idk.api.feign.service.factory.ExBtmInfoServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 蓝牙模块信息相关服务接口
 *
 * @author hwyz_leo
 */
@FeignClient(contextId = "exBtmInfoService", value = ServiceNameConstants.TSP_IDK, path = "/service/btm", fallbackFactory = ExBtmInfoServiceFallbackFactory.class)
public interface ExBtmInfoService {

    /**
     * 批量导入蓝牙模块数据
     *
     * @param request 批量导入蓝牙模块请求
     */
    @PostMapping("/batchImport")
    void batchImport(@RequestBody @Validated BatchImportBtmRequest request);

}
