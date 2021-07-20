package com.lol.statistics.community.api;


import cn.hutool.json.JSONUtil;
import com.lol.statistics.community.Totalfee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.regex.Pattern;


@WebServlet(name="querytotalfee",urlPatterns = "/statistics/community/totalfee")
public class querytotalfee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Boolean bl=false;
        String json=null;
        Date tdate=null;
        String date=req.getParameter("date");
        System.out.println(date);

        String pattern1 = ".{4}.*";
        String pattern2 = ".{4}-.{2}.*";
        String pattern3 = ".{4}-.{2}-.{2}.*";
        Boolean m1=Pattern.matches(pattern1,date);
        Boolean m2=Pattern.matches(pattern2,date);
        Boolean m3=Pattern.matches(pattern3,date);
        System.out.println(m1.toString()+m2.toString()+m3.toString());
        if(m3==true)
        {
            try{
                tdate= Date.valueOf(date);
                System.out.println("5"+tdate);
            }catch (Exception e)
            {
                System.out.println("catch!1");
                json="你不会输入日期还是从小到大没人教过你年月日怎么写？";
            }
        }else if(m2==true)
        {
            try{
                tdate=Date.valueOf(date+"-01");
            }catch (Exception e){
                System.out.println("catch!2");
                json="你不会输入日期还是从小到大没人教过你年月日怎么写？";
            }
        }else if(m1==true)
        {
            try{
                tdate=Date.valueOf(date+"-01-01");
            }catch (Exception e){
                System.out.println("catch!3");
                json="你不会输入日期还是从小到大没人教过你年月日怎么写？";
            }
        }

        Totalfee totalfee=new Totalfee();
        System.out.println("3"+totalfee.totalFee(date));

        json= JSONUtil.toJsonStr(totalfee.totalFee(date));

        System.out.println("4"+json);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
