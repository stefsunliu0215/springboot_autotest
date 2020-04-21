//package com.liu.util;
//
//import com.liu.bean.ApproveRecord;
//import com.liu.bean.Resource;
//import org.apache.poi.hssf.usermodel.*;
//import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @ClassName: ExportExcelUtil
// * @Description: 导出Excel工具类
// * @Author: 52945
// * @Date: 2020/1/8 14:05
// * @Version: 1.0
// */
//public class ExportExcelUtil {
//
//    private static Logger log = LoggerFactory.getLogger(ExportExcelUtil.class);
//
//    /**
//     * 创建表格标题
//     *
//     * @param wb         Excel文档对象
//     * @param sheet      工作表对象
//     * @param rowNum     列序号
//     * @param headString 标题名称
//     * @param col        标题占用列数
//     */
//    public static void createHeadTittle(HSSFWorkbook wb, HSSFSheet sheet, int rowNum, String headString, int col) {
//        // 创建Excel工作表的行
//        HSSFRow row = sheet.createRow(rowNum);
//        row.setHeight((short) 800);
//
//        // 创建Excel工作表指定行的单元格
//        HSSFCell cell = row.createCell(0);
//        // 定义单元格为字符串类型
//        cell.setCellType(CellType.STRING);
//        cell.setCellValue(new HSSFRichTextString(headString));
//
//        // 指定标题合并区域
//        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, col));
//
//        // 定义单元格格式，添加单元格表样式，并添加到工作簿
//        HSSFCellStyle cellStyle = wb.createCellStyle();
//        // 指定单元格水平居中对齐
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);
//        // 指定单元格垂直居中对齐
//        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//        // 指定单元格自动换行
//        cellStyle.setWrapText(true);
//
//        // 设置单元格字体
//        HSSFFont font = wb.createFont();
//        font.setBold(true);
//        font.setFontName("微软雅黑");
//        font.setFontHeightInPoints((short) 16);
//        font.setColor(HSSFColorPredefined.BLACK.getIndex());
//
//        cellStyle.setFont(font);
//        cell.setCellStyle(cellStyle);
//    }
//
//    /**
//     * 创建表头
//     *
//     * @param wb         Excel文档对象
//     * @param sheet      工作表对象
//     * @param rowNum     列序号
//     * @param thead      表头内容
//     * @param sheetWidth 每一列宽度
//     */
//    public static void createThead(HSSFWorkbook wb, HSSFSheet sheet, int rowNum, String[] thead, int[] sheetWidth) {
//        // 创建Excel工作表的行
//        HSSFRow row = sheet.createRow(rowNum);
//        row.setHeight((short) 600);
//
//        // 定义单元格格式，添加单元格表样式，并添加到工作簿
//        HSSFCellStyle cellStyle = wb.createCellStyle();
//        //水平居中对齐
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);
//        //垂直居中对齐
//        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//        cellStyle.setWrapText(true);
//        //设置背景色 灰色25%
//        cellStyle.setFillForegroundColor(HSSFColorPredefined.PALE_BLUE.getIndex());
//        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        // 设置右边框类型, 颜色
//        cellStyle.setBorderRight(BorderStyle.THIN);
//        cellStyle.setRightBorderColor(HSSFColorPredefined.BLACK.getIndex());
//
//        // 设置单元格字体
//        HSSFFont font = wb.createFont();
//        font.setBold(true);
//        font.setFontName("微软雅黑");
//        font.setFontHeightInPoints((short) 10);
//        cellStyle.setFont(font);
//
//        // 设置表头内容
//        for (int i = 0; i < thead.length; i++) {
//            HSSFCell cell1 = row.createCell(i);
//            //定义单元格为字符串类型
//            cell1.setCellType(CellType.STRING);
//            cell1.setCellValue(new HSSFRichTextString(thead[i]));
//            cell1.setCellStyle(cellStyle);
//        }
//
//        // 设置每一列宽度
//        for (int i = 0; i < sheetWidth.length; i++) {
//            sheet.setColumnWidth(i, sheetWidth[i]);
//        }
//    }
//
//    /**
//     * 填充数据
//     *
//     * @param wb          Excel文档对象
//     * @param sheet       工作表对象
//     * @param startRowNum 开始的列序号
//     * @param result      表数据
//     */
//    public static void createTable(HSSFWorkbook wb, HSSFSheet sheet, int startRowNum, List<LinkedHashMap<String, String>> result) {
//        // 定义单元格格式，添加单元格表样式，并添加到工作薄
//        HSSFCellStyle cellStyle = wb.createCellStyle();
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);
//        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//        cellStyle.setWrapText(true);
//
//        // 单元格字体
//        HSSFFont font = wb.createFont();
//        font.setFontName("微软雅黑");
//        font.setFontHeightInPoints((short) 10);
//        cellStyle.setFont(font);
//
//        // 循环插入数据
//        for (int i = 0; i < result.size(); i++) {
//            HSSFRow row = sheet.createRow(i + startRowNum);
//            row.setHeight((short) 400);
//            HSSFCell cell;
//            int j = 0;
//            for (String key : result.get(i).keySet()) {
//                cell = row.createCell(j);
//                cell.setCellStyle(cellStyle);
//                cell.setCellValue(new HSSFRichTextString(result.get(i).get(key)));
//                j++;
//            }
//        }
//    }
//
//    /**
//     * @return void
//     * @Name write
//     * @Description 输出到excel文件
//     * @Date 2020/1/8 14:23
//     * @Param [filePath, fileName]
//     **/
//    public static void writeFile(HSSFWorkbook wb, String filePath, String fileName) {
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(new File(filePath + fileName));
//            wb.write(fos);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        } finally {
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    log.error(e.getMessage());
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        // 1.封装数据
//        List<Resource> list = new LinkedList<>();
//        Resource r1 = new Resource();
//        r1.setDimensionName("客户服务与解答口径");
//        r1.setUploadTime("2019-08-12 06:51:39");
//        r1.setResName("application_38925.yml");
//        r1.setResSize("0.0081");
//        list.add(r1);
//
//        Resource r2 = new Resource();
//        r2.setDimensionName("2+1+N服务要素核查");
//        r2.setUploadTime("2019-08-12 06:51:50");
//        r2.setResName("10_50130.png");
//        r2.setResSize("0.0027");
//        list.add(r2);
//
//        Resource r3 = new Resource();
//        r3.setDimensionName("效益分析");
//        r3.setUploadTime("2019-08-12 06:51:52");
//        r3.setResName("application_52089.yml");
//        r3.setResSize("0.0081");
//        list.add(r3);
//
//        List<ApproveRecord> list2 = new LinkedList<>();
//        ApproveRecord a = new ApproveRecord();
//        a.setLinkName("测试12");
//        a.setApprover("李玲");
//        a.setArriveTime("2019-10-09 12:02:30");
//        a.setApproveTime("2019-10-09 14:12:30");
//        a.setApproveOpinion("同意");
//        a.setCommitPath("测试路径");
//        list2.add(a);
//
//        // 实体类转换为map
//        List<LinkedHashMap<String, String>> result1 = new ArrayList<>();
//        LinkedHashMap<String, String> map;
//        for (Resource r : list) {
//            map = new LinkedHashMap<>(4);
//            map.put("dimensionName", r.getDimensionName());
//            map.put("uploadTime", r.getUploadTime());
//            map.put("resName", r.getResName());
//            map.put("resSize", r.getResSize());
//            result1.add(map);
//        }
//        List<LinkedHashMap<String, String>> result2 = new ArrayList<>();
//        LinkedHashMap<String, String> map2;
//        for (ApproveRecord ar : list2) {
//            map2 = new LinkedHashMap<>(6);
//            map2.put("linkName", ar.getLinkName());
//            map2.put("approver", ar.getApprover());
//            map2.put("arriveTime", ar.getApproveTime());
//            map2.put("approveTime", ar.getApproveTime());
//            map2.put("approveOpinion", ar.getApproveOpinion());
//            map2.put("commitPath", ar.getCommitPath());
//            result2.add(map2);
//        }
//
//        // 2.定义变量值 创建Excel文件
//        // 定义文件名
//        String fileName = "营销案详情.xlsx";
//        // 定义表格标题
//        String headString1 = "营销案详情";
//        String headString2 = "营销案审批流转记录";
//        // 定义工作表表名
//        String sheetName1 = "基本信息";
//        String sheetName2 = "审批流程记录";
//        // 文件本地保存路径
//        String filePath = "D:\\";
//        String[] thead1 = {"维度名称", "上传日期", "附件名称", "文件大小(M)"};
//        String[] thead2 = {"环节名称", "处理人", "到达时间", "处理时间", "审批意见", "提交路径"};
//        // 定义每一列宽度
//        int[] sheetWidth1 = {6000, 6000, 9000, 3000};
//        int[] sheetWidth2 = {5000, 3000, 6000, 6000, 5000, 5000};
//
//        // 创建Excel文档对象
//        HSSFWorkbook wb = new HSSFWorkbook();
//        // 创建工作表
//        HSSFSheet sheet1 = wb.createSheet(sheetName1);
//        HSSFSheet sheet2 = wb.createSheet(sheetName2);
//        // 3.生成表格
//        // sheet1
//        // 创建表格标题
//        createHeadTittle(wb, sheet1, 0, headString1, 3);
//        // 创建表头
//        createThead(wb, sheet1, 1, thead1, sheetWidth1);
//        // 填入数据
//        createTable(wb, sheet1, 2, result1);
//
//        //sheet2
//        // 创建表格标题
//        createHeadTittle(wb, sheet2, 0, headString2, 5);
//        // 创建表头
//        createThead(wb, sheet2, 1, thead2, sheetWidth2);
//        // 填入数据
//        createTable(wb, sheet2, 2, result2);
//
//        // 输出到文件
//        writeFile(wb, filePath, fileName);
//        log.info("导出Excel成功！");
//    }
//
//}