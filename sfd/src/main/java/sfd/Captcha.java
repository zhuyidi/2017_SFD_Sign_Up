package sfd;

/**
 * Created by zhuxinquan on 16-8-29.
 */

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Captcha extends HttpServlet{

    Color getRandColor(int fc, int bc)
    {
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        //创建图像
        int width = 60, height = 20;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //获取图形
        Graphics g = image.getGraphics();

        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman",Font.PLAIN,18));

        for(int i=0;i<155;i++)
        {g.setColor(getRandColor(160, 200));
            int x=random.nextInt(width);
            int y=random.nextInt(height);
            int x1=random.nextInt(12);
            int y1=random.nextInt(12);
            g.drawLine(x, y, x+x1, y+y1);
        }
        String sRand="";
        for(int i=0; i<4; i++)
        {
            String rand=String.valueOf(random.nextInt(10));
            sRand+=rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 16);
        }
        HttpSession session = req.getSession();
        session.setAttribute("captcha", sRand);
//        req.setAttribute("rand", sRand);
        g.dispose();//释放图片资源
        ImageIO.write(image, "JPEG",resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        //创建图像
        int width = 60, height = 20;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //获取图形
        Graphics g = image.getGraphics();

        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman",Font.PLAIN,18));

        for(int i=0;i<155;i++)
        {g.setColor(getRandColor(160, 200));
            int x=random.nextInt(width);
            int y=random.nextInt(height);
            int x1=random.nextInt(12);
            int y1=random.nextInt(12);
            g.drawLine(x, y, x+x1, y+y1);
        }
        String sRand="";
        for(int i=0; i<4; i++)
        {
            String rand=String.valueOf(random.nextInt(10));
            sRand+=rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 16);
        }
        HttpSession session = req.getSession();
        session.setAttribute("captcha", sRand);
//        req.setAttribute("rand", sRand);
        g.dispose();//释放图片资源
        ImageIO.write(image, "JPEG",resp.getOutputStream());
    }
}
