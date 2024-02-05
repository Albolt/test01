package com.personal.test01.everyOther;

import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.io.IOException;

public class ClashSql {

    /*
        "+split+"
     */

//    BEGIN
//    FOR i IN 0 .. 999
//    LOOP
//    EXECUTE IMMEDIATE 'insert into tmp_daily_20240131 as select * from ANT_TRUST_LOAN_DAILY_' || LPAD(i, 3, '0') || ' where status in (''NORMAL'',''OVD'',''NORMA'')';
//    END LOOP;
//    END;

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("test.sql");
        for (int i = 0; i < 1000; i++) {
            String split = StringUtils.leftPad("" + i, 3, "0");
            writer.write("insert into tmp_daily_fund_20240131(sub_table,source,fund_type,prin_amt) select '"+split+"',source,fund_type,sum(total_prin_bal) from ANT_TRUST_LOAN_DAILY_"+split+" where status in ('NORMAL','OVD','NORMA') group by source,fund_type;\n\n\n");
        }
        writer.flush();
        writer.close();
    }
}
