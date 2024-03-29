package utils.simpSQL.config;



import utils.simpSQL.Helper.Marker;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author LessonWong
 * @date 2019/11/16 18:12
 * 通过该类统一解决硬解码问题
 */
public class Config {

    private Config() {
    }

    private static HashMap<String,String> dbConfig = null;
    private static HashMap<String,String> mappingConfig = null;
    private static HashMap<String,String> formatConfig = null;

    private static String dbConfigPath = "src/com/pleasekid/utils/simpSQL/config/DBConfig.properties";
    private static String mappingConfigPath = "src/com/pleasekid/utils/simpSQL/config/mapping.properties";
    private static String formatConfigPath = "src/com/pleasekid/utils/simpSQL/config/format.properties";

    /**
     * 获取配置信息
     */
    static {
        InputStream in = null;
        Properties properties = null;
        try {
            properties = new Properties();
            dbConfig = new HashMap<>();
            in = new BufferedInputStream(new FileInputStream(dbConfigPath));
            properties.load(in);

            for(Object iter : properties.keySet()){
                dbConfig.put((String)iter,(String) properties.get(iter));
            }
        } catch (IOException e) {
            System.err.println(Marker.getTimer() + "数据库配置信息获取失败");
        }

        try {
            properties = new Properties();
            mappingConfig = new HashMap<>();
            in = new BufferedInputStream(new FileInputStream(mappingConfigPath));
            properties.load(in);

            for(Object iter : properties.keySet()){
                mappingConfig.put((String)iter,(String) properties.get(iter));
            }
        } catch (IOException e) {
            System.err.println(Marker.getTimer() + "映射关系配置信息获取失败");
        }

        try{
            properties = new Properties();
            formatConfig = new HashMap<>();
            in = new BufferedInputStream(new FileInputStream(formatConfigPath));
            properties.load(in);
            for(Object iter : properties.keySet()){
                formatConfig.put((String)iter,(String) properties.get(iter));
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDBConfig(String property){
        return dbConfig.get(property);
    }

    public static String getMappingConfig(String property){
        return mappingConfig.get(property);
    }

    public static String getFormatConfigPath(String property){
        return formatConfig.get(property);
    }

    /**
     * 查看信息
     */
    public static void check(){
        for(String iter : dbConfig.keySet()){
            System.out.println("key : " + iter +"\t\t\t\t value : " + dbConfig.get(iter));
        }
        System.out.println("--------------------");
        for(String iter : mappingConfig.keySet()){
            System.out.println("key : " + iter +"\t\t\t\t value : " + mappingConfig.get(iter));
        }
        System.out.println("--------------------");
        for(String iter : formatConfig.keySet()){
            System.out.println("key : " + iter +"\t\t\t\t value : " + mappingConfig.get(iter));
        }
    }
}
