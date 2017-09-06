package sfd;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by zhuxinquan on 16-8-28.
 */

//报名
@WebServlet("/sign-up.do")
public class Apply extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errorList = new ArrayList<String>();
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String sno = req.getParameter("sid");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String captcha = req.getParameter("captcha");
        String academy = req.getParameter("academy");
        String classAndGrade = req.getParameter("classAndGrade");

        System.out.println(sno);
        System.out.println(name);
        System.out.println(email);
        System.out.println(captcha);
        System.out.println(academy);
        System.out.println(classAndGrade);

        if(Pattern.matches("^\\d{8}$", sno) == false){
            errorList.add("学号格式不正确");
        }
        if(Pattern.matches("^(\\w-*\\.*)+@(\\w-?)+(\\.\\w{2,})+$", email) == false){
            errorList.add("邮箱格式不正确");
        }
        HttpSession session = req.getSession();
        String verifyCaptcha = (String) session.getAttribute("captcha");
        if(captcha == null || verifyCaptcha == null || captcha.equals(verifyCaptcha) == false) {
            errorList.add("验证码错误");
        }

        if(errorList.size() == 0){
            String sql = "insert into userinfo(sno, name, email, academy, classAndGrade) values(?, ?, ?, ?, ?)";
            Connection conn = DBUtils.getConnection();
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, sno);
                ps.setString(2, name);
                ps.setString(3, email);
                ps.setString(4, academy);
                ps.setString(5, classAndGrade);

                ps.executeUpdate();
            } catch (MySQLIntegrityConstraintViolationException e){
                errorList.add("该学号已经报名");
                e.printStackTrace();
            }
            catch (SQLException e) {
                errorList.add("数据库操作异常");
                e.printStackTrace();
            }
        }

        if(errorList.size() != 0){
            req.setAttribute("sno", sno);
            req.setAttribute("name", name);
            req.setAttribute("email", email);
            req.setAttribute("error", errorList);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        }
    }
}
