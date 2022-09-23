package main.java.org.lykj;

public class ReplacePhoneNumber {
    /**
     * 替换手机号方法
     * 使用String.substring()方法实现
     * @param phoneNumber: String
     * @return 替换完成的手机号码
     */
    public static String replacePhone(String phoneNumber){
        try {
            final String prv = phoneNumber.substring(0, 3);
            final String suffix = phoneNumber.substring(7, 11);
            return prv + "****" + suffix;
        }catch (StringIndexOutOfBoundsException e){
            return "请输入正确手机号!";
        }
    }

    /**将手机号码第4位到第7位替换成* 使用正则表达式实现
     * @param phoneNumber
     *        需要替换的手机号
     * @return 替换完成的手机号码
     */
    public static String replacePhoneWithRegular(String phoneNumber){
        if (phoneNumber.length() == 11){
            return phoneNumber.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        }else {
            return "请输入正确的手机号！";
        }
    }
}
