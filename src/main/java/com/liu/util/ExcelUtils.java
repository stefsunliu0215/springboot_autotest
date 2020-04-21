package com.liu.util;

import com.liu.bean.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: ExcelUtils
 * @Description: Excel工具类
 * @Author: 52945
 * @Date: 2020/1/9 9:36
 * @Version: 1.0
 */
public class ExcelUtils {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");

    /**
     * @Name createXLS
     * @Description (2003 xls后缀 在模板得基础上填充数据导出新文件)
     * @Date 2020/1/9 9:55
     * @Param [importFilePath, exportFilePath]
     * @return void
     **/
    public static void createXLS(String importFilePath, String exportFilePath, Map<String, Object> data) {
        FileOutputStream out = null;
        try {
            //1.读取excel模板
            File file = new File(importFilePath);
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            //读取了模板内所有sheet内容
            HSSFSheet sheet0 = wb.getSheetAt(0);
            HSSFSheet sheet1 = wb.getSheetAt(1);
            HSSFSheet sheet2 = wb.getSheetAt(2);
            HSSFSheet sheet3 = wb.getSheetAt(3);
            //如果这行没有了，整个公式都不会有自动计算的效果的
            sheet0.setForceFormulaRecalculation(true);
            sheet1.setForceFormulaRecalculation(true);
            sheet2.setForceFormulaRecalculation(true);
            sheet3.setForceFormulaRecalculation(true);
            //2.填充数据
            writeXlsData(sheet0, null);
            //3.修改模板内容后导出新模板
            out = new FileOutputStream(exportFilePath);
            wb.write(out);
        } catch (Exception e) {
            logger.error("文件读取错误!");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("文件输出流关闭异常！");
                }
            }
        }

    }

    /**
     * @Name createXLSX
     * @Description (2007 xlsx后缀 在模板得基础上填充数据导出新文件)
     * @Date 2020/1/9 10:13
     * @Param [importFilePath, exportFilePath, data]
     * @return void
     **/
    public static void createXLSX(String importFilePath, String exportFilePath, Map<String, Object> data) {
        FileOutputStream out = null;
        try {
            //1.读取excel模板
            File file = new File(importFilePath);
            InputStream in = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(in);
            //读取了模板内所有sheet内容
            XSSFSheet sheet0 = wb.getSheetAt(0);
            XSSFSheet sheet1 = wb.getSheetAt(1);
            XSSFSheet sheet2 = wb.getSheetAt(2);
            XSSFSheet sheet3 = wb.getSheetAt(3);
            //如果这行没有了，整个公式都不会有自动计算的效果的
            sheet0.setForceFormulaRecalculation(true);
            sheet1.setForceFormulaRecalculation(true);
            sheet2.setForceFormulaRecalculation(true);
            sheet3.setForceFormulaRecalculation(true);
            //单元格样式
            XSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            XSSFFont font = wb.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 10);
            cellStyle.setFont(font);
            cellStyle.setWrapText(true);
            //2.填充数据
            //组装数据
            McdCampProdDefBO bo = (McdCampProdDefBO) data.get("baseInfo");
            Integer campaignStatus = bo.getCampaignStatus();
            List<CellModel> baseInfo = initCellData("baseInfo", data.get("baseInfo"));
            List<CellModel> custGroupInfo = initCellData("custGroupInfo", data.get("custGroupInfo"));
            List<CellModel> approvalList = initCellData("approvalList", data.get("approvalList"));
            if (CampaignStatus.TO_SUBMIT.getCode().equals(campaignStatus)) {
                writeXlsxData(sheet0, cellStyle, baseInfo);
                writeXlsxData(sheet0, cellStyle, custGroupInfo);
            }else if (CampaignStatus.EXECUTING.getCode().equals(campaignStatus)) {
                writeXlsxData(sheet1, cellStyle, baseInfo);
                writeXlsxData(sheet1, cellStyle, custGroupInfo);
            }else if (CampaignStatus.FINISH.getCode().equals(campaignStatus)) {
                writeXlsxData(sheet2, cellStyle, baseInfo);
                writeXlsxData(sheet2, cellStyle, custGroupInfo);
            }
            //审批流转记录
            writeXlsxData(sheet3, cellStyle, approvalList);
            //3.修改模板内容导出新模板
            out = new FileOutputStream(exportFilePath);
            wb.write(out);
        } catch (IOException e) {
            logger.error("文件读取错误! " + e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("文件输出流关闭异常！");
                }
            }
        }
    }

    /**
     * @Name initCellData
     * @Description 组装数据
     * @Date 2020/1/9 10:35
     * @Param [type, object]
     * @return java.util.List<com.liu.bean.CellModel>
     **/
    private static List<CellModel> initCellData(String type, Object object){
        List<CellModel> cellList = new ArrayList<>();
        if ("baseInfo".equals(type)) {
            McdCampProdDefBO bo = (McdCampProdDefBO) object;
            String[] values = {bo.getCampaignName(), bo.getCampaignId(), bo.getCreateUser(), "测试部", bo.getCampaignTypeName(),
                    bo.getServiceTypeName(), bo.getMainTopicName(), bo.getBusinessTypeName(),
                    format.format(bo.getStartTime()), format.format(bo.getEndTime()), "活动级别2",
                    bo.getMarketingPlanCityName(), bo.getCampSceneName(), bo.getLaunchModeName(),
                    bo.getIsExcludeOrdered()==1?"剔除":"不剔除", "Y".equals(bo.getIsSendSms())?"是":"否",
                    bo.getHandlingSuccessTips(), StringUtils.isEmpty(bo.getDiscountType())?"无":String.valueOf(bo.getDiscountType()) + "\\" + bo.getExpectedDiscount(), bo.getHandlingSuccessTips()};
            for (int i = 0; i < values.length; i++) {
                cellList.add(new CellModel(i + 2, 1, values[i]));
            }
            //业务维度
            String dimension;
            if ("1".equals(bo.getFirstClass())){
                dimension = "存量";
            } else if ("2".equals(bo.getFirstClass())){
                dimension = "增量";
            } else {
                dimension = "存量,增量";
            }
            StringBuilder resourceInput = new StringBuilder();
            resourceInput.append("折扣折让：").append(StringUtils.isEmpty(bo.getResourceInputDesc1())?"无":bo.getResourceInputDesc1()).append("; ")
                    .append("实体卡：").append(StringUtils.isEmpty(bo.getResourceInputDesc2())?"无":bo.getResourceInputDesc2()).append("; ")
                    .append("酬金：").append(StringUtils.isEmpty(bo.getResourceInputDesc3())?"无":bo.getResourceInputDesc3()).append("; ")
                    .append("其他：").append(StringUtils.isEmpty(bo.getResourceInputDesc4())?"无":bo.getResourceInputDesc4());
            String[] dimValues = {dimension, bo.getSecondClassName(), bo.getCampaignBackground(), bo.getCampaignRule(),
                    bo.getExpectedTarget(), resourceInput.toString(), bo.getEconomicEstimation(), bo.getRiskManagement()};
            for (int i = 0; i < dimValues.length; i++) {
                cellList.add(new CellModel(i + 26, 1, dimValues[i]));
            }
            //营销策略描述
            String[] descValues = {bo.getAnalysisPlanProduct(), bo.getFavorablePrice(), bo.getChannelAndReward(), bo.getAdvertisingAndPromotion()};
            for (int i = 0; i < descValues.length; i++) {
                cellList.add(new CellModel(i + 39, 1, descValues[i]));
            }
            //上传附件列表
            List<Resource> resList = new LinkedList<>();
            resList.add(new Resource(bo.getCustService(), bo.getCustServiceTime(), bo.getCustServiceSize()));
            resList.add(new Resource(bo.getNeleVerification(), bo.getNeleVerificationTime(), bo.getNeleVerificationSize()));
            resList.add(new Resource(bo.getBenefitAnalysis(), bo.getBenefitAnalysisTime(), bo.getBenefitAnalysisSize()));
            resList.add(new Resource(bo.getAttachment(), bo.getAttachmentTime(), bo.getAttachmentSize()));
            for (int i = 0; i < resList.size(); i++) {
                cellList.add(new CellModel(i + 58, 1, resList.get(i).getResName()));
                cellList.add(new CellModel(i + 58, 2, resList.get(i).getUploadTime()));
                cellList.add(new CellModel(i + 58, 3, resList.get(i).getResSize()));
            }
        } else if ("custGroupInfo".equals(type)) {
            //客户群信息
            CustGroupDefBO bo = (CustGroupDefBO) object;
            String[] custValues = {bo.getCustomGroupName(), bo.getCustomGroupId(), bo.getUpdateCycleName(),
                    String.valueOf(bo.getActualCustomNum()), bo.getDataDate()};
            for (int i = 0; i < custValues.length; i++) {
                cellList.add(new CellModel(i + 48, 1, custValues[i]));
            }
        } else if ("approvalList".equals(type)) {
            //审批流转记录
            List<MarketingCaseApprovalDetailBO> approvalList = (List<MarketingCaseApprovalDetailBO>) object;
            int num = 2;
            List<McdApprovalDetailDO> detailDos;
            for (int i = 0; i < approvalList.size(); i++) {
                detailDos = approvalList.get(i).getDetailDO();
                for (int j = 0; j < detailDos.size() ; j++) {
                    cellList.add(new CellModel(num, 0, detailDos.get(j).getNode()));
                    cellList.add(new CellModel(num, 1, detailDos.get(j).getApproveUser()));
                    cellList.add(new CellModel(num, 2, format.format(detailDos.get(j).getCreateTime())));
                    cellList.add(new CellModel(num, 3, format.format(detailDos.get(j).getApproveTime())));
                    cellList.add(new CellModel(num, 4, detailDos.get(j).getAdvice()));
                    cellList.add(new CellModel(num, 5, detailDos.get(j).getNextNodes()));
                    num++;
                }
            }
        }
        return cellList;
    }

    /**
     * @Name writeXlsData
     * @Description 填充xls数据
     * @Date 2020/1/9 10:24
     * @Param [sheet, data]
     * @return void
     **/
    private static void writeXlsData(HSSFSheet sheet, List<CellModel> cellList){
        if (cellList != null && !cellList.isEmpty()) {
            for (CellModel cell : cellList) {
                sheet.getRow(cell.getRow()).getCell(cell.getColumn()).setCellValue(cell.getValue());
            }
        }
    }

    /**
     * @Name writeXlsxData
     * @Description 填充xlsx数据
     * @Date 2020/1/9 10:24
     * @Param [sheet, cellStyle, data]
     * @return void
     **/
    private static void writeXlsxData(XSSFSheet sheet, XSSFCellStyle cellStyle, List<CellModel> cellList){
        if (cellList != null && !cellList.isEmpty()) {
            XSSFCell cell1;
            for (CellModel cell : cellList) {
                cell1 = sheet.getRow(cell.getRow()).getCell(cell.getColumn());
                cell1.setCellStyle(cellStyle);
                cell1.setCellValue(cell.getValue());
            }
        }
    }

    public static void main(String[] args) {
        //excle 2007
        String importFilePath = "D://template.xlsx";
        String exportFilePath = "D://test.xlsx";
        Map<String, Object> data = new HashMap<>(100);
        McdCampProdDefBO bo = new McdCampProdDefBO();
        bo.setCreateUser("admin");
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
        bo.setDiscountType(1);
        bo.setExpectedDiscount(8.2);
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
        createXLSX(importFilePath, exportFilePath, data);

    }

}