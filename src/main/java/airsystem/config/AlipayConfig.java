package airsystem.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101600702029";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCFglmh1Bbza6nXHXLTyDb6QL6bQXdq0R1dRORAue2MKpHT2J+y0U39mGXI6FAm5Z9jUODKylwDdOpfb9w/0InHRX5Y5ZdJU53VQf79ByXiUdV9+FuEK+stzlhJQhk8ZD/qEOswkNu5SI4hCulhKNV6APPOQJ7JrM1ZlhXDBNI9TWZaNMhZFqW5HnOweIwTsWtIb7uoW0XNEzn3rXwlze9xVOFCw23xj+BJe9N2zjikZxdD6tfYrp2OmFd1TxHYZikf8ojOY3Sja1R1BdXz2lOwvS/nofN9b+ZxDOZ68xhPCFiyHP6oe/lKuN8nR+/OKVzsDBgWKJGSFQmKi8pH5kj9AgMBAAECggEAYa+Ohan5YQJVsuAJNIw6LcFRtaehCLcZFTVjDTj9ZqF/MdI+h0g+GF95mhbhDpTUmoaC8948lQrmsg3WyZp8NSHT4JecqjpUMcWoHNsuDPpzi0g9Leg0m79vOarzbAyt90WJ0G8tVdSQqfyh5kVKbYpk2XTOuiGF3xbBtX/BlLgFb1LY/aQI7+JUws4/nmOazT03ZifSsZNdOjLWjEjjgDS3JtyFUVQf2nanKSQzfA6NYVJO7aGxlRK8XvgER4Llrl4Wj/pXW1NRSqdY8hZDUyidps0S8cf56855ZhF/ZcIEkAm/LHFJbY0D/RuX7N9tF6EzbR/L1ts+lUNtdzaCAQKBgQDv+p4lU3dX9TxsLrbRsHpZptzdUoVLBKynmp/jjgoSXMBKec3Mg8sCm4KKYxtq88Y6wU054cudPc1/kAkyUPrNfF2c93exnR5SWfgcph0eIiYKMsWm1T/5i2EW7yY8bzd19OfFv/Xx2em6A1cPBWVgsvqNGH1zwXFLdhEGjeqCyQKBgQCObBnLrb4E96wFFnRpQfhSi34sIj9A8mT0hcwpTABtN/w/grnFvkS7Q2v+genUx0DivxgFUkgOScPUz7lXi3ss6H6Zwy80FrrKFPFYeU6QItBJwZ24jAaw6bn2YysL7SI8E31nxShg9zlP93CjPM92rP2qsLBdVL6e0GPblkHalQKBgCD7MabxnLJS+vXnSarx9S7DFxG32KfhwZTbVGQizlGNu8PAj78u0cTO+JbqXgdJ75F9pY5x8NjweICynAD1TjLVh8wd2q5naJZq1QWi8teEW/QE3FM8dalnNXXAcmHV6ypj+UKdSkDt8Qhmkx12YWNz1al0lzFEgbycQmTDNlq5AoGAD2fQDoEXqc/kkpRQOUaChuNB3aJCt1LA6tZCNEFdVnMU3QXV9HbVVnA/kUMaOQLomN5UydaRpsIB5dYmVTroMv5fG2DKjVbcE5naVVihz+OEJkZEOj8jRiWyEN2/PUYESv1MtlnUOVDkqSq5y157jnm94qXEHgRZrjIaaxlAvFUCgYEA5pEwtVOiERof2bstzx1swwXIpCWrIQwefMgYrJYtFUNqKyrZ28k6KMPFcPqfj4qgbnYECI6PjqQRK5tYeJGRqJQVciJVecfgP2HIfZgjjjBvSQJHaPCCFWs+P8os7sF71wQO4BrcMTReFkmt1AV81sc7OC33s1wDDalIq13/bQE=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "复制公钥\r\n" + 
    		"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp2hKOwIsQnmmvGz9YavtrvWpkbGyP3aDVjA9oTfCqLzMVyGizJ/A6+++60os0j2NjcHlQYRrMgUHK3aLyykCK98UalU8lESB3ofxOy3iubtmnDCK8xpEFZEkmRLNRJKX7DqSaLboecNRF1/BPllilnykvV+99xBFcLCHOPa6iNbskwHjNxCn1so0hE/X9IAeiRQB4pvK28wUCDg7+jpRVCaiPWkQOvI8xQv4MR/yZpaHhXE8sBxdzggGNCvTfUaPKiqkbQkFx1dsaxv0C0OHt4O81LkOj/cyrsE02h9W49h67AtRTmS00BcgXw749OpImYVL4eqw6ULnILHrX0RszQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8888/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://sunnyjanbear.free.idcfengye.com/airline/success";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


