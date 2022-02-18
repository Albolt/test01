package com.personal.test01.utils.phoneUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CountryPhoneEnums {
    AE("ae",2,   "United Arab Emirates" ,"971"     ,9      ),
    CA("ca",39,   "Canada"              ,"1"     ,9     ),
    VN("vn",243,  "Vietnam"             ,"84"     ,10      ),
    AU("au",14,   "Australia"           ,"61"     ,8      ),
    GB("gb",233,  "United Kingdom"      ,"44"     ,9     ),
    IN("in",105,  "India"               ,"91"     ,10    ),
    ID("id",101,  "Indonesia"           ,"62"     ,11     ),
    ES("es",69,   "Spain"               ,"34"     ,9     ),
    LB("lb",127, "Lebanon"              ,"961"     ,10     ),
    LK("lk",130,  "Sri Lanka"           ,"94"     ,11     ),
    TH("th",219, "Thailand"             ,"66"     ,9      ),
    PH("ph",178,  "Philippines"         ,"63"      ,10     ),
    EG("eg",66,   "Egypt"               ,"20"      ,8      ),
    BD("bd",20,   "Bangladesh"          ,"880"      ,8      ),
    FR("fr",76,   "France"              ,"33"      ,9     ),
    BH("bh",24,   "Bahrain"             ,"973"      ,10     ),
    BR("br",32,   "Brazil"              ,"55"      ,10     ),
    OM("om",173,  "Oman"                ,"968"      ,8      ),
    SG("sg",199,  "Singapore"           ,"65"      ,10     ),
    US("us",235,  "United States"       ,"1"      ,8      ),
    QA("qa",188,  "Qatar"               ,"974"      ,9      ),
    KW("kw",123,  "Kuwait"              ,"965"      ,8     ),
    SA("sa",194,  "Saudi Arabia"        ,"966"      ,9     ),
    MY("my",158,  "Malaysia"            ,"60"      ,10     ),
    MX("mx",157,  "Mexico"              ,"52"      ,10    ),
    IL("il",103,  "Israel"              ,"972"      ,10     ),
    IT("it",110,  "Italy"               ,"39"      ,10     ),
    CN("cn",49,   "China"               ,"86"    ,11     ),
    ;
    private String countryCode;
    private Integer countryId;
    private String countryName;
    private String mobilePre;
    private Integer mobileLength;


    public static CountryPhoneEnums findEnumsByCountryCode(String countryCode){
        for (CountryPhoneEnums value : values()) {
            if (Objects.equals(value.getCountryCode(),countryCode.toLowerCase())){
                return value;
            }
        }
        return null;
    }

    public static Boolean checkCountryCodeExist(String countryCode){
        if(findEnumsByCountryCode(countryCode)!=null){
            return true;
        }
        return false;
    }
}
