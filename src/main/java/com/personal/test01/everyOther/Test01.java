package com.personal.test01.everyOther;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.LineHandler;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.extra.ssh.Sftp;
import cn.hutool.core.io.file.FileReader;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jcraft.jsch.SftpProgressMonitor;
import com.personal.test01.utils.LocalDateUtils;
import com.personal.test01.utils.MonthLastDayUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
public class Test01 {

    private static Configuration cfg;

    private static final Map<String, String> dataFormatMap = new HashMap<String, String>();

    static {
        dataFormatMap.put("REPORT_DECREASE_VALUE_PROVIDER_INFO", "yyyyMMdd");
        dataFormatMap.put("REPORT_EAST_BORROWER_DETAIL", "yyyyMMdd");
        dataFormatMap.put("REPORT_EAST_TRUST_MANAGE", "yyyyMMdd");
        dataFormatMap.put("REPORT_LOAN_DETAIL", "yyyy/MM/dd");
        dataFormatMap.put("REPORT_RATE_LOAN_BALANCE", "yyyy-MM-dd");
        dataFormatMap.put("REPORT_RATE_LOAN_BASE", "yyyy-MM-dd");
        dataFormatMap.put("REPORT_RATE_LOAN_PAY_INFO", "yyyy-MM-dd");
        dataFormatMap.put("REPORT_RATE_OVERDRAFT_BALANCE", "yyyy-MM-dd");
        dataFormatMap.put("REPORT_RATE_OVERDRAFT_DETAIL", "yyyy-MM-dd");
        dataFormatMap.put("REPORT_RATE_PERSON_CUSTOMER", "yyyy-MM-dd");

        cfg = new Configuration(Configuration.VERSION_2_3_31);
        try {
            cfg.setDirectoryForTemplateLoading(new File("/"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final List<String> reportTableList =
            Lists.newArrayList("REPORT_EAST_BORROWER_DETAIL", "REPORT_EAST_TRUST_MANAGE");


    public static void main(String[] args) {

        String a = "/download/20240115/test.csv";
        String b = "/download/${acctDate.format('yyyyMMdd')}/";
        String c = StringUtils.replace(a, b, "");
        System.out.println(c);
//        Template template;
//        try {
//            template = cfg.getTemplate("Users/zhangchi/forInteresting/ANT_FUND_BANK_FUND.ctl");
//            String path = "/Users/zhangchi/forInteresting/ANT_FUND_BANK_FUND_"+System.currentTimeMillis()+".ctl";
//            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
//            Map<String, Object> paramsJob    = Maps.newHashMap();
//            paramsJob.put("acctDate", "20240115");
//            template.process(paramsJob, out);
//            out.flush();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (TemplateException e) {
//            throw new RuntimeException(e);
//        }


//        try (Sftp sftp = new Sftp("8.130.166.72", 9217, "sftpuser", "rBb.aDKp3fWXNEu")){
//            String localPath = "/Users/zhangchi/data/";
////            String remotePath = "/home/sftpuser/report/HB/20231026/asd__*";
////            List<String> x = sftp.lsFiles(remotePath);
////            System.out.println(x);
////            for (String a :
////                    x) {
////                System.out.println(a);
////            }
//            File[] result = FileUtil.ls(localPath);
//            for (int i = 0; i < result.length; i++) {
//                System.out.println(result[i].getName());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }




    }

//    String fileName = "/Users/zhangchi/idea/testworkspace/test01/src/main/resources/credit_loan_stat.sql";
//    String fileNew = "/Users/zhangchi/idea/testworkspace/test01/src/main/resources/credit_loan_stat_new.sql";
//    String CHARSET_NAME = "UTF-8";
//
//
//    FileReader fileReader = new FileReader(fileName, Charset.forName("UTF-8"));
//    StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 1000; i++) {
//        String split = StringUtils.leftPad("" + i, 3, "0");
//        fileReader.readLines((LineHandler) line -> {
//            sb.append(line.toString().replace("000", split)).append(System.lineSeparator());
//        });
//        sb.append(System.lineSeparator()).append(System.lineSeparator());
//    }
//    FileWriter fw = null;
//        try {
//        fw = new FileWriter(fileNew);
//        fw.write(sb.toString());
//        fw.close();
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }

////        CollectionUtils.isEmpty();
//        String a = "1234567890123456";
//
//        String b = StringUtils.substring(a, 13);
//
//        System.out.println(b);

        //SELECT sum(cnt)cnt from(
        //SELECT COUNT(*) cnt  FROM CREDIT_LOAN_STAT_000
        //UNION ALL
        //SELECT COUNT(*) cnt  FROM CREDIT_LOAN_STAT_001
        //UNION ALL
        //SELECT COUNT(*) cnt  FROM CREDIT_LOAN_STAT_002
        //)
//        System.out.println("1"+1);


//
//            System.out.println(ddl);
//            List<String> a = Lists.newArrayList();
//
//            List<String> b = a.stream().filter(x->x.equals("123123")).collect(Collectors.toList());

//        }
//
//    }
// jdbc:mysql://10.1.0.0:1001/unittests?user=**u**@sys&password=******&sessionVariables = ob_query_timeout = 60000000000,ob_trx_timeout = 60000000000&xxxx
}
