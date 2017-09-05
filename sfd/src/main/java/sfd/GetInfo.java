package sfd;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuxinquan on 16-8-28.
 */
public class GetInfo {
    public static void main(String[] args) {
        System.out.println(GetInfo("04142051", "zhu2737353904"));
    }

    public static Student GetInfo(String sno, String passwd){
        String result = "";
        BufferedReader in = null;
        Student stu = null;

//        String url = "http://115.159.152.176/httpost.php?sid=" + sno + "&passwd=" + passwd;
        String url = "http://222.24.19.201/httpost.php?sid=" + sno + "&passwd=" + passwd;
//        System.out.println(url);
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result.trim().length() != 0){
            JSONObject jsonObject = new JSONObject(result);
            stu = new Student();
            stu.setSno(jsonObject.getString("xh"));
            stu.setAcademy("xy");
            stu.setClassAndGrade("xzb");
            stu.setDepartment("zy");
            stu.setName("xm");
        }
        return stu;
    }
}
