package sfd;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by zhuxinquan on 16-9-1.
 */
@WebServlet("/lottery.do")
public class lottery extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Student student = new Student();

        PrintWriter out = resp.getWriter();
        Map<String, String> info = new HashMap<String, String>();

        Connection conn = DBUtils.getConnection();
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stat.executeQuery("select * from userinfo where lottery_flag = 0 order by rand() limit 1");
            if(rs.next()){
                student.setSno(rs.getString(2));
                student.setName(rs.getString(3));

                String sql = "update userinfo set lottery_flag = 1 where sno = '" +  student.getSno() + "';";
                System.out.println(sql);
                stat.executeUpdate(sql);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, stat, conn);
        }
        info.put("sid", student.getSno());
        info.put("name", student.getName());
        JSONObject jsonObject = new JSONObject(info);
        out.print(jsonObject.toString());
        out.close();

    }
}
