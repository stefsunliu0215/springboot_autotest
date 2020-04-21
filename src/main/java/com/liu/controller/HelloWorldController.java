package com.liu.controller;

import com.liu.bean.CustGroupDefBO;
import com.liu.bean.MarketingCaseApprovalDetailBO;
import com.liu.bean.McdApprovalDetailDO;
import com.liu.bean.McdCampProdDefBO;
import com.liu.util.ExcelUtils;
import com.liu.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: HelloWorldController
 * @Description: restful controller
 * @Author: 52945
 * @Date: 2019/10/16 17:18
 * @Version: 1.0
 */
@RestController
public class HelloWorldController {

    private Logger log = LoggerFactory.getLogger(FileUtils.class);

    @GetMapping("/export")
    public String export(HttpServletResponse response) {
        FileUtils util = new FileUtils();
        List<File> srcFiles = new ArrayList<>();
        String importFilePath = this.getClass().getClassLoader().getResource("xlsx/template.xlsx").getPath();
        //生成时间戳，用于文件夹命名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String path = sdf.format(new Date());
        //项目根目录
        String serverPath = System.getProperty("user.dir") + File.separator;
        //在服务器端创建文件夹
        File file = new File(serverPath, path);
        if (!file.exists()) {
            //级联创建
            file.mkdirs();
        }
        String exportFilePath = serverPath + path + File.separator + "test.xlsx";
        Map<String, Object> data = new HashMap<>(100);
        McdCampProdDefBO bo = new McdCampProdDefBO();
        bo.setCampaignStatus(6);
        bo.setCampaignStatusName("执行中");
        bo.setCampaignName("营销案0902");
        bo.setCampaignId("201909020853404668095");
        bo.setMarketingPlanCityName("全省");
        bo.setCampaignTypeName("入网类营销");
        bo.setServiceTypeName("业务类型4");
        bo.setCampSceneName("营销场景1");
        bo.setMainTopicName("营销专题1");
        bo.setBusinessTypeName("营销业务类型1");
        bo.setLaunchModeName("发起方式1");
        bo.setOwnMarketName("所属市场1");
        bo.setMainBusinessName("主推业务1");
        bo.setStartTime(new Date());
        bo.setEndTime(new Date());
        bo.setIsExcludeOrdered(0);
        bo.setIsSendSms("Y");
        bo.setHandlingSuccessTips("测试");
        //业务维度
        bo.setFirstClass("1");
        bo.setSecondClassName("维度二1");
        bo.setCampaignBackground("活动背景/促销方案1");
        bo.setCampaignRule("宣传方案1");
        bo.setExpectedTarget("预期目标1");
        bo.setResourceInputDesc1("");
        bo.setResourceInputDesc2("");
        bo.setResourceInputDesc3("");
        bo.setResourceInputDesc4("");
        bo.setEconomicEstimation("经济性测算1");
        bo.setRiskManagement("风险管控1");
        //营销策略描述
        bo.setAnalysisPlanProduct("产品简介与竞品分析12");
        bo.setFavorablePrice("价格及优惠与促销内容12");
        bo.setChannelAndReward("渠道承载及对应酬金/量酬11");
        bo.setAdvertisingAndPromotion("是");
        //上传附件列表
        bo.setCustService("IMPORT_FILE (1)_27519.csv");
        bo.setCustServiceTime("2019-09-02 08:53:27");
        bo.setCustServiceSize("0.0003");
        bo.setNeleVerification("IMPORT_FILE_29273.csv");
        bo.setNeleVerificationTime("2019-09-02 08:53:29");
        bo.setNeleVerificationSize("0.0003");
        bo.setBenefitAnalysis("IMPORT_FILE_31449.csv");
        bo.setBenefitAnalysisTime("2019-09-02 08:53:31");
        bo.setBenefitAnalysisSize("0.0003");
        bo.setAttachment("cs.csv");
        bo.setAttachmentTime("2019-12-10 00:00:00");
        bo.setAttachmentSize("0.012");
        data.put("baseInfo", bo);
        //客户群信息
        CustGroupDefBO custBo = new CustGroupDefBO();
        custBo.setCustomGroupName("iphone客户群");
        custBo.setCustomGroupId("jjsks73724");
        custBo.setUpdateCycleName("一次性");
        custBo.setActualCustomNum(11);
        custBo.setDataDate("20190212");
        data.put("custGroupInfo", custBo);
        //审批流转记录
        List<MarketingCaseApprovalDetailBO> approvalList = new LinkedList<>();
        MarketingCaseApprovalDetailBO detailBO1 = new MarketingCaseApprovalDetailBO();
        List<McdApprovalDetailDO> detailDOS1 = new LinkedList<>();
        McdApprovalDetailDO detailDO11 = new McdApprovalDetailDO();
        detailDO11.setNode("节点11");
        detailDO11.setApproveUser("审批人11");
        detailDO11.setCreateTime(new Date());
        detailDO11.setApproveTime(new Date());
        detailDO11.setAdvice("意见11");
        detailDO11.setNextNodes("下一提交路径11");
        detailDOS1.add(detailDO11);
        McdApprovalDetailDO detailDO12 = new McdApprovalDetailDO();
        detailDO12.setNode("节点12");
        detailDO12.setApproveUser("审批人12");
        detailDO12.setCreateTime(new Date());
        detailDO12.setApproveTime(new Date());
        detailDO12.setAdvice("意见12");
        detailDO12.setNextNodes("下一提交路径12");
        detailDOS1.add(detailDO12);
        detailBO1.setDetailDO(detailDOS1);

        MarketingCaseApprovalDetailBO detailBO2 = new MarketingCaseApprovalDetailBO();
        List<McdApprovalDetailDO> detailDOS2 = new LinkedList<>();
        McdApprovalDetailDO detailDO21 = new McdApprovalDetailDO();
        detailDO21.setNode("节点21");
        detailDO21.setApproveUser("审批人21");
        detailDO21.setCreateTime(new Date());
        detailDO21.setApproveTime(new Date());
        detailDO21.setAdvice("意见21");
        detailDO21.setNextNodes("下一提交路径21");
        detailDOS2.add(detailDO21);
        McdApprovalDetailDO detailDO22 = new McdApprovalDetailDO();
        detailDO22.setNode("节点22");
        detailDO22.setApproveUser("审批人22");
        detailDO22.setCreateTime(new Date());
        detailDO22.setApproveTime(new Date());
        detailDO22.setAdvice("意见22");
        detailDO22.setNextNodes("下一提交路径22");
        detailDOS2.add(detailDO22);
        detailBO2.setDetailDO(detailDOS2);

        approvalList.add(detailBO1);
        approvalList.add(detailBO2);
        data.put("approvalList", approvalList);
        //生成excel
        ExcelUtils.createXLSX(importFilePath, exportFilePath, data);
        //压缩文件文件夹路径
        String downloadPath = serverPath + path;
        //将excel添加到zip
        srcFiles.add(new File(exportFilePath));
        //将附件添加到zip
        util.getInternetRes("http://archive.apache.org/dist/kafka/0.10.0.0/RELEASE_NOTES.html", downloadPath, "RELEASE_NOTES.html");
        srcFiles.add(new File(downloadPath + File.separator + "RELEASE_NOTES.html"));
        boolean result = util.exportZip(response, serverPath, path, srcFiles);
        if (result) {
            return "success";
        }
        return "failure";
    }

}
