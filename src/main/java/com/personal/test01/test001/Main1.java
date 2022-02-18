package com.personal.test01.test001;

import com.facebook.presto.jdbc.PrestoConnection;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Creater albolt
 * @12/11/20 10:30 AM
 */

@Slf4j
public class Main1 {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:presto://ec2-34-219-181-28.us-west-2.compute.amazonaws.com:8889/hive/dw_dws", "hive", null);
            Statement stmt = connection.createStatement();
            String sql = "select email from dw_opendata.sale_order_shopify_user_df where msite in ('Fairprices GB','Fairprices US','Wholee M') and date_diff('day', cast(last_shopify_create_ch_date as date),now()) > 2 and date_diff('day', cast(last_shopify_create_ch_date as date),now()) < 5 and date_diff('day', cast(last_so_pay_ch_date as date),now()) > 3 and date_diff('day', cast(last_so_pay_ch_date as date),now()) < 6";
            ResultSet a = stmt.executeQuery(sql);
            List<String> strings = new ArrayList<>();
            while (a.next()) {
                System.out.println(a.getString("email"));
                strings.add(a.getString("email"));
            }
            log.info("emails.size:{}", strings.size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
