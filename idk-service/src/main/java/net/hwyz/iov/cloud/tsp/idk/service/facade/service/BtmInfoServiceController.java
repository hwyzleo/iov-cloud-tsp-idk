package net.hwyz.iov.cloud.tsp.idk.service.facade.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.idk.api.contract.request.BatchImportBtmRequest;
import net.hwyz.iov.cloud.tsp.idk.service.application.service.BtmInfoAppService;
import net.hwyz.iov.cloud.tsp.idk.service.facade.assembler.BtmExServiceAssembler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 蓝牙模块信息相关服务接口实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/service/btm")
public class BtmInfoServiceController {

    private final BtmInfoAppService btmInfoAppService;

    /**
     * 批量导入蓝牙模块数据
     *
     * @param request 批量导入蓝牙模块请求
     */
    @PostMapping("/batchImport")
    public void batchImport(@RequestBody @Validated BatchImportBtmRequest request) {
        logger.info("批量导入蓝牙模块数据[{}]", request.getBatchNum());
        btmInfoAppService.batchImport(request.getBatchNum(), request.getSupplierCode(),
                BtmExServiceAssembler.INSTANCE.toPoList(request.getBtmList()));
    }

}
