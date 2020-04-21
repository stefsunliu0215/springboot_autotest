package com.liu.util;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName: FileUtils
 * @Description: 文件操作工具类
 * @Author: 52945
 * @Date: 2020/1/6 15:18
 * @Version: 1.0
 */
public class FileUtils {

    private static Logger log = LoggerFactory.getLogger(FileUtils.class);

    /**
     * @return java.lang.String
     * @Name exportZip
     * @Description 导出zip(将多个文件打包成zip导出)
     * @Date 2020/1/6 17:16
     * @Param [response, serverPath, fileName, srcFiles]
     **/
    public boolean exportZip(HttpServletResponse response, String serverPath, String fileName, List<File> srcFiles) {
        //将多个文件打成zip包
        File zipFile = new File(serverPath + fileName + ".zip");
        log.info("正在将文件打包压缩成zip文件......");
        this.zipFiles(srcFiles, zipFile);
        log.info("文件打包压缩完成！");
        //弹出下载框供用户下载
        log.info("正在导出zip文件......");
        this.downFile(response, serverPath, fileName + ".zip");
        log.info("导出zip文件完成！");
        //导出之后清理本地生成的zip文件和文件夹
        deleleTempFile(new File(serverPath, fileName));
        deleleTempFile(zipFile);
        return true;
    }

    /**
     * @Name zipFiles
     * @Description 将多个文件打包成zip文件
     * @Date 2020/1/6 17:54
     * @Param [srcFiles, zipFile]
     * @return void
     **/
    private void zipFiles(List<File> srcFiles, File zipFile) {
        ZipOutputStream out = null;
        try {
            // Create the ZIP file
            out = new ZipOutputStream(new FileOutputStream(zipFile));
            // Compress the files
            for (File file : srcFiles) {
                FileInputStream in = new FileInputStream(file);
                // Add ZIP entry to output stream.
                out.putNextEntry(new ZipEntry(file.getName()));
                // Transfer bytes from the file to the ZIP file
                int len;
                byte[] buf = new byte[1024];
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                // Complete the entry
                out.closeEntry();
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                // Complete the ZIP file
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @return void
     * @Name downFile
     * @Description 下载文件
     * @Date 2020/1/6 17:50
     * @Param [response, serverPath, fileName]
     **/
    private void downFile(HttpServletResponse response, String serverPath, String fileName) {
        try {
            String path = serverPath + File.separator + fileName;
            File file = new File(path);
            if (file.exists()) {
                InputStream ins = new FileInputStream(path);
                // 放到缓冲流里面
                BufferedInputStream bins = new BufferedInputStream(ins);
                // 获取文件输出IO流
                OutputStream outs = response.getOutputStream();
                BufferedOutputStream bouts = new BufferedOutputStream(outs);
                // 设置response内容的类型
                response.setContentType("application/x-download");
                // 设置头部信息
                response.setHeader(
                        "Content-disposition",
                        "attachment;filename="
                                + URLEncoder.encode(fileName, "GBK"));
                int bytesRead;
                int len = 8192;
                byte[] buffer = new byte[len];
                //开始向网络传输文件流
                while ((bytesRead = bins.read(buffer, 0, len)) != -1) {
                    bouts.write(buffer, 0, bytesRead);
                }
                // 这里一定要调用flush()方法
                bouts.flush();
                bouts.close();
                outs.close();
                bins.close();
                ins.close();
            } else {
                log.error("文件不存在！");
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * @Name getInternetRes
     * @Description 获取网络文件到本地
     * @Date 2020/1/8 11:17
     * @Param [urlStr, localPath, fileName]
     * @return void
     **/
    public void getInternetRes(String urlStr, String localPath, String fileName) {
        URL url;
        HttpURLConnection con;
        InputStream in = null;
        FileOutputStream out = null;
        try {
            url = new URL(urlStr);
            //建立http连接，得到连接对象
            con = (HttpURLConnection) url.openConnection();
            //输入流读取文件
            in = con.getInputStream();
            //转化为byte数组
            byte[] data = this.getByteData(in);
            //建立存储的目录、保存的文件名 
            File file = new File(localPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            //修改文件名 用id重命名
            File res = new File(file + File.separator + fileName);
            //写入输出流
            out = new FileOutputStream(res);
            out.write(data);
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            //关闭流
            try {
                if (null != out) {
                    out.close();
                }
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("下载出错！" + e.toString());
            }
        }
    }

    /**
     * @Name getByteData
     * @Description 从输入流中获取字节数组
     * @Date 2020/1/8 11:27
     * @Param [in]
     * @return byte[]
     **/
    private byte[] getByteData(InputStream in) {
        ByteArrayOutputStream bos = null;
        try {
            byte[] b = new byte[4096];
            bos = new ByteArrayOutputStream();
            int len;
            while ((len = in.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return null;
    }

//    /**
//     * @return void
//     * @Name createWord
//     * @Description 生成word文档---固定下载地址
//     * @Date 2020/1/6 17:37
//     * @Param [fileName, data]
//     **/
//    public void createWord(String fileName, String title, Map<String, Object> data) {
//        FileOutputStream fos = null;
//        try {
//            // 保存文件的路径
//            fos = new FileOutputStream(fileName);
//            //创建word文件
//            XWPFDocument doc = new XWPFDocument();
//            //创建段落1
//            XWPFParagraph header = doc.createParagraph();
//            header.setAlignment(ParagraphAlignment.CENTER);
//            setParagraphFontStyle(header, "宋体", 14, title, true);
//            //创建段落2
//            XWPFParagraph creator = doc.createParagraph();
//            creator.setAlignment(ParagraphAlignment.LEFT);
//            setParagraphFontStyle(creator, "宋体", 12, "创建人：admin", false);
//            //创建表格
//            XWPFTable table = doc.createTable();
//            table.setWidth("100%");
//            table.setTableAlignment(TableRowAlign.CENTER);
//            //创建第一行
//            XWPFTableRow row1 = table.getRow(0);
//            setTrHeight(row1, 500);
//            setParagraphFontStyle(row1.getCell(0).getParagraphs().get(0), "宋体", 11, "姓名:", true);
//            setParagraphFontStyle(row1.addNewTableCell().getParagraphs().get(0), "宋体", 11, "李琳", false);
//            setParagraphFontStyle(row1.addNewTableCell().getParagraphs().get(0), "宋体", 11, "年龄:", true);
//            setParagraphFontStyle(row1.addNewTableCell().getParagraphs().get(0), "宋体", 11, "28", false);
//            //创建第二行
//            XWPFTableRow row2 = table.createRow();
//            setTrHeight(row2, 500);
//            setParagraphFontStyle(row2.getCell(0).getParagraphs().get(0), "宋体", 11, "宣传方案：", true);
//            setParagraphFontStyle(row2.getCell(1).getParagraphs().get(0), "宋体", 11, "测试", false);
//            setParagraphFontStyle(row2.getCell(2).getParagraphs().get(0), "宋体", 11, "预期目标：", true);
//            setParagraphFontStyle(row2.getCell(3).getParagraphs().get(0), "宋体", 11, "成功", false);
//            //创建第三行
//            XWPFTableRow row3 = table.createRow();
//            setTrHeight(row3, 500);
//            setParagraphFontStyle(row3.getCell(0).getParagraphs().get(0), "宋体", 11, "活动背景/促销方案：", true);
//            setParagraphFontStyle(row3.getCell(1).getParagraphs().get(0), "宋体", 11, "运筹", false);
//            setParagraphFontStyle(row3.getCell(2).getParagraphs().get(0), "宋体", 11, "价格及优惠与促销内容：", true);
//            setParagraphFontStyle(row3.getCell(3).getParagraphs().get(0), "宋体", 11, "存储", false);
//            //表格单元格内容水平垂直居中
//            setCellLocation(table,"CENTER","center");
//            // 保存Excel文件
//            doc.write(fos);
//        } catch (IOException e) {
//            log.error(e.getMessage());
//        } finally {
//            // 关闭文件流
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
//    /**
//     * @return void
//     * @Name createWord
//     * @Description 生成word文档---页面自定义下载地址和名称
//     * @Date 2020/1/6 17:34
//     * @Param [response, fileName, data]
//     **/
//    public void createWord(HttpServletResponse response, String fileName, Map<String, Object> data) {
//        XWPFDocument doc = null;
//        try {
//            response.setContentType("application/msexcel");
//            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
//            response.setCharacterEncoding("utf-8");
//            ServletOutputStream out = response.getOutputStream();
//            //创建word文件
//            doc = new XWPFDocument();
//            //创建段落
//            XWPFParagraph p1 = doc.createParagraph();
//            //创建段落文本
//            XWPFRun r1 = p1.createRun();
//            //设置文本
//            r1.setText("Helloworld");
//            r1.addBreak(); // 换行
//            r1.setText("世界你好!gagagagagagagag");
//            // 保存word文件
//            doc.write(out);
//        } catch (IOException e) {
//            log.error(e.getMessage());
//        } finally {
//            // 关闭文件流
//            if (doc != null) {
//                try {
//                    doc.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    /**
//     * @return void
//     * @Name createPDF
//     * @Description 生成PDF---固定下载地址
//     * @Date 2020/1/6 17:47
//     * @Param [fileName, data]
//     **/
//    public void createPDF(String fileName, String title, Map<String, Object> data) {
//        Document document = null;
//        try {
//            // 第一步，实例化一个document对象
//            document = new Document();
//            // 第二步，设置要到出的路径
//            FileOutputStream out = new FileOutputStream(fileName);
//            // 第三步,设置字符
//            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
//            Font fontHeader = new Font(bfChinese, 12F, Font.BOLD);
//            Font fontCellKey = new Font(bfChinese, 8F, Font.BOLD);
//            Font fontCellValue = new Font(bfChinese, 8F, Font.NORMAL);
//            // 第四步，将pdf文件输出到磁盘
//            PdfWriter writer = PdfWriter.getInstance(document, out);
//            // 第五步，打开生成的pdf文件
//            document.open();
//            // 第六步,设置内容
//            Paragraph header = new Paragraph(title, fontHeader);
//            header.setAlignment(Paragraph.ALIGN_CENTER);
//            document.add(header);
//            document.add(new Paragraph("\n"));
//            // 创建table,注意这里的2是两列的意思,下面通过table.addCell添加的时候必须添加整行内容的所有列
//            PdfPTable table = new PdfPTable(2);
//            //表格水平居中显示
//            table.setHorizontalAlignment(Element.ALIGN_CENTER);
//            //表格宽度占比
//            table.setWidthPercentage(100.0F);
//            float[] widths = new float[] {40f, 60f};
//            table.setWidths(widths);
//            //设置单元格水平对齐方式
//            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
//            //设置单元格垂直对齐方式
//            table.getDefaultCell().setUseAscender(true);
//            table.getDefaultCell().setUseDescender(true);
//            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
//            //设置行高
//            table.getDefaultCell().setMinimumHeight(20F);
//            //设置单元格内容
//            if (data != null) {
//                Set<Map.Entry<String, Object>> entries = data.entrySet();
//                for (Map.Entry<String, Object> entry : entries) {
//                    table.addCell(new Paragraph(entry.getKey() + ":", fontCellKey));
//                    table.addCell(new Paragraph(entry.getValue().toString(), fontCellValue));
//                }
//            }
//            document.add(table);
//            document.add(new Paragraph("\n"));
//        } catch (DocumentException | IOException e) {
//            log.error(e.getMessage());
//        } finally {
//            if (document != null) {
//                // 第七步，关闭document
//                document.close();
//            }
//        }
//    }
//
//    /**
//     * @return void
//     * @Name createPDF
//     * @Description 生成PDF---前端自定义下载地址
//     * @Date 2020/1/6 17:50
//     * @Param [response, fileName, data]
//     **/
//    public static void createPDF(HttpServletResponse response, String fileName, Map<String, Object> data) {
//        Document document = null;
//        try {
//            // 第一步，实例化一个document对象
//            document = new Document();
//            // 第二步，设置要到出的路径
//            response.setContentType("application/msexcel");
//            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
//            response.setCharacterEncoding("utf-8");
//            ServletOutputStream out = response.getOutputStream();
//            // 第三步,设置字符
//            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
//            Font fontZH = new Font(bfChinese, 12.0F, 0);
//            // 第四步，将pdf文件输出到磁盘
//            PdfWriter writer = PdfWriter.getInstance(document, out);
//            // 第五步，打开生成的pdf文件
//            document.open();
//            // 第六步,设置内容
//            String title = "标题";
//            document.add(new Paragraph(new Chunk(title, fontZH).setLocalDestination(title)));
//            document.add(new Paragraph("\n"));
//            // 创建table,注意这里的2是两列的意思,下面通过table.addCell添加的时候必须添加整行内容的所有列
//            PdfPTable table = new PdfPTable(2);
//            table.setWidthPercentage(100.0F);
//            table.setHeaderRows(1);
//            table.getDefaultCell().setHorizontalAlignment(1);
//            table.addCell(new Paragraph("序号", fontZH));
//            table.addCell(new Paragraph("结果", fontZH));
//            table.addCell(new Paragraph("1", fontZH));
//            table.addCell(new Paragraph("出来了", fontZH));
//
//            document.add(table);
//            document.add(new Paragraph("\n"));
//        } catch (IOException | DocumentException e) {
//            e.printStackTrace();
//        } finally {
//            if (document != null) {
//                // 第七步，关闭document
//                document.close();
//            }
//        }
//    }

    /**
     * 设置单元格水平位置和垂直位置
     *
     * @param xwpfTable
     * @param verticalLoction    单元格中内容垂直上TOP，下BOTTOM，居中CENTER，BOTH两端对齐
     * @param horizontalLocation 单元格中内容水平居中center,left居左，right居右，both两端对齐
     */
    public static void setCellLocation(XWPFTable xwpfTable, String verticalLoction, String horizontalLocation) {
        List<XWPFTableRow> rows = xwpfTable.getRows();
        for (XWPFTableRow row : rows) {
            List<XWPFTableCell> cells = row.getTableCells();
            for (XWPFTableCell cell : cells) {
                CTTc cttc = cell.getCTTc();
                CTP ctp = cttc.getPList().get(0);
                CTPPr ctppr = ctp.getPPr();
                if (ctppr == null) {
                    ctppr = ctp.addNewPPr();
                }
                CTJc ctjc = ctppr.getJc();
                if (ctjc == null) {
                    ctjc = ctppr.addNewJc();
                }
                //水平居中
                ctjc.setVal(STJc.Enum.forString(horizontalLocation));
                //垂直居中
                cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.valueOf(verticalLoction));
            }
        }
    }

    /**
     * 设置表格位置
     *
     * @param xwpfTable
     * @param location  整个表格居中center,left居左，right居右，both两端对齐
     */
    public static void setTableLocation(XWPFTable xwpfTable, String location) {
        CTTbl cttbl = xwpfTable.getCTTbl();
        CTTblPr tblpr = cttbl.getTblPr() == null ? cttbl.addNewTblPr() : cttbl.getTblPr();
        CTJc cTJc = tblpr.addNewJc();
        cTJc.setVal(STJc.Enum.forString(location));
    }

    /**
     * @Name setTrHeight
     * @Description 设置行高
     * @Date 2020/1/6 20:13
     * @Param [tableRow, height]
     * @return void
     **/
    public static void setTrHeight(XWPFTableRow tableRow, long height){
        tableRow.getCtRow().addNewTrPr().addNewTrHeight().setVal(BigInteger.valueOf(height));
    }

    /**
     * @Name setParagraphFontStyle
     * @Description 设置内容样式
     * @Date 2020/1/7 11:11
     * @Param [paragraph, fontFamily, fontSize, text, bold]
     * @return void
     **/
    public static void setParagraphFontStyle(XWPFParagraph paragraph, String fontFamily, int fontSize, String text, boolean bold){
        XWPFRun run = paragraph.createRun();
        if (!StringUtils.isEmpty(fontFamily)) {
            run.setFontFamily(fontFamily);
        }
        if (fontSize != 0) {
            run.setFontSize(fontSize);
        }
        if (!StringUtils.isEmpty(text)) {
            run.setText(text);
        }
        if (!StringUtils.isEmpty(bold)) {
            run.setBold(bold);
        }
    }

    /**
     * @Name deleleTempFile
     * @Description 删除文件
     * @Date 2020/1/7 14:24
     * @Param [file]
     * @return void
     **/
    public void deleleTempFile(File file) {
        if (file.isDirectory()) {
            //获取文件夹下所有子文件夹
            String[] children = file.list();
            //递归删除目录中的子目录下
            if (children != null) {
                for (String child : children) {
                    deleleTempFile(new File(file, child));
                }
            }
        }
        // 目录空了，进行删除
        file.delete();
    }

    public static void main(String[] args) {
        FileUtils utils = new FileUtils();
        String urlStr = "http://10.1.235.142:5051/mcd-web-hlj/action/hlj/marketingCaseFileCommonController/doDownload.do?fileUrl=1_13177.png";
        utils.getInternetRes(urlStr, "D://", "1_13177.png");
    }

}
