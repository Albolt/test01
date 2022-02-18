package com.personal.test01.utils.phoneUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneAreaCodeTool {
    private static Set<String> areaCodes ;
    private static Map<String, String> countryArea = new HashMap<>();
    static{
        countryArea.put("AU","61");
        countryArea.put("BH","973");
        countryArea.put("BD","880");
        countryArea.put("BR","55");
        countryArea.put("CA","1");
        countryArea.put("CN","86");
        countryArea.put("EG","20");
        countryArea.put("FR","33");
        countryArea.put("IN","91");
        countryArea.put("ID","62");
        countryArea.put("IL","972");
        countryArea.put("IT","39");
        countryArea.put("KW","965");
        countryArea.put("LB","961");
        countryArea.put("MY","60");
        countryArea.put("MX","52");
        countryArea.put("OM","968");
        countryArea.put("PH","63");
        countryArea.put("QA","974");
        countryArea.put("SA","966");
        countryArea.put("SG","65");
        countryArea.put("ES","34");
        countryArea.put("LK","94");
        countryArea.put("TH","66");
        countryArea.put("AE","971");
        countryArea.put("GB","44");
        countryArea.put("US","1");
        countryArea.put("VN","84");
        countryArea.put("DE","49");
        areaCodes = new HashSet<>(countryArea.values());
    }


    public static String getAreaCode(String fullPhoneNo){
        if(StringUtils.isEmpty(fullPhoneNo)){
            return null;
        }
        for(int len = 1; len<4; len++){
            String preLen = StringUtils.substring(fullPhoneNo, 0 ,len);
            if(areaCodes.contains(preLen)){
                return preLen;
            }
        }
        return null;
    }


    public static String getThinCellPhoneNum(String fullPhoneNo,String countryCode){
        /** 头部去0 **/
        String phoneWithOutHeadZero=fullPhoneNo.replaceFirst("^0*", "");
        /** 获取手机号的国家区号 **/
        String mobilePre=getAreaCode(phoneWithOutHeadZero);
        if(!mobilePre.equalsIgnoreCase(CountryPhoneEnums.findEnumsByCountryCode(countryCode).getMobilePre())){
            throw new RuntimeException("国家码与国家不匹配");
        }
        /** 得到短号 **/
        return StringUtils.removeStart(phoneWithOutHeadZero,mobilePre);
    }

    public static String getAreaCodeByCountryCode(String countryCode) {
        return countryArea.get(countryCode.toUpperCase());
    }
}
