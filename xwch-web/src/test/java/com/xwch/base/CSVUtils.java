package com.xwch.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * CSV文件导出工具类
 *
 * Created on 2014-08-07
 * @author
 * @reviewer
 */
public class CSVUtils {

    public static void main(String[] args) {
/*
        批次类型,BATCH_AGENT,,,,,,,,,,,,
        批次号,F2018060600003,,,,,,,,,,,,
        申请日期,20180602,,,,,,,,,,,,
        总笔数,2,,,,,,,,,,,,
        总金额(元),1888,,,,,,,,,,,,
        是否再付,是/否,,,,,,,,,,,,
        描述,测试模板,,,,,,,,,,,,
        明细,,,,,,,,,,,,,
        商户代码,银行名称,银行账户名,银行卡掩码,结算账号,交易金额,银行编码,卡类型,银行类型标识,,,,,
        1.12E+14,中国邮政储蓄银行有限责任公司平昌县新平街支行,龙春燕,,6.22E+18,123.33,POST,借记卡,对私,,,,,
        3.18E+15,中国工商银行股份有限公司无锡梁溪支行,中国共产党中国电信股份有限公司无锡分公司委员会,,1.10E+18,11.11,ICBC,对公账号,对公,,,,,
*/
        String filePath= "/data/dataTemp";
        String fileName = "agent_pay_oms";
        List<List<Object>> rows = new ArrayList<>();
        List<Object> row1 = new ArrayList<>();
        row1.add("批次类型");
        row1.add("BATCH_AGENT");

        List<Object> row2 = new ArrayList<>();
        row2.add("批次号");
        row2.add("F2018060600003");

        List<Object> row3 = new ArrayList<>();
        row3.add("申请日期");
        row3.add("20180602");

        List<Object> row4 = new ArrayList<>();
        row4.add("总笔数");
        row4.add("2");

        List<Object> row5 = new ArrayList<>();
        row5.add("总金额(元)");
        row5.add("1888");
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        rows.add(row5);
        createCSVFile(null,rows,filePath,fileName);
    }

    /**
     * CSV文件生成方法
     * @param head
     * @param dataList
     * @param outPutPath
     * @param filename
     * @return
     */
    public static File createCSVFile(List<Object> head, List<List<Object>> dataList,
                                     String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvWtriter = null;
        try {
            csvFile = new File(outPutPath + File.separator + filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            // GB2312使正确读取分隔符","
            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    csvFile), "GB2312"), 1024);
            // 写入文件头部
            writeRow(head, csvWtriter);

            // 写入文件内容
            for (List<Object> row : dataList) {
                writeRow(row, csvWtriter);
            }
            csvWtriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWtriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }

    /**
     * 写一行数据方法
     * @param row
     * @param csvWriter
     * @throws IOException
     */
    private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
        if (row != null){
            // 写入文件头部
            StringBuilder sb = new StringBuilder();
            for (Object data : row) {
                 sb.append("\"").append(data).append("\",");
            }
            String rowStr = sb.append("\r\n").toString();
            System.out.println(rowStr);
            csvWriter.write(rowStr);
            //csvWriter.newLine();
        }
    }
}