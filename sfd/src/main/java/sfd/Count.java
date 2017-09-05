package sfd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zhuxinquan on 16-9-5.
 */

//获取报名人数
public class Count{
    public static int getCount(){
        int num = 0;
        Connection conn = DBUtils.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("select count(*) from userinfo");
            if(rs.next()){
                num = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, statement, conn);
        }
        return num;
    }
}
