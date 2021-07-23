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


@WebServlet(name = "querytotalfee", urlPatterns = "/statistics/community/totalfee")
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
        Boolean bl = false;
        String json = "";
        Date tdate = null;
        String date = req.getParameter("date");
        System.out.println(date);
        if(date.equals(""))
        {
            date=null;
            Totalfee totalfee = new Totalfee();
            json = JSONUtil.toJsonStr(totalfee.totalFee(date));
        }else {
            String pattern1 = "[0-9]{4}";
            String pattern2 = "[0-9]{4}-[0-9]{2}";
            String pattern3 = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
            Boolean m1 = Pattern.matches(pattern1, date);
            Boolean m2 = Pattern.matches(pattern2, date);
            Boolean m3 = Pattern.matches(pattern3, date);
            System.out.println(m1.toString() + m2.toString() + m3.toString());
            if (m3 == true) {
                try {
                    tdate = Date.valueOf(date);
                    Totalfee totalfee = new Totalfee();
                    json = JSONUtil.toJsonStr(totalfee.totalFee(date));
                } catch (Exception e) {
                    System.out.println("catch!1");
                    json = "date format error";
                }
            } else if (m2 == true) {
                try {
                    tdate = Date.valueOf(date + "-01");
                    Totalfee totalfee = new Totalfee();
                    json = JSONUtil.toJsonStr(totalfee.totalFee(date));
                } catch (Exception e) {
                    System.out.println("catch!2");
                    json = "date format error";
                }
            } else if (m1 == true) {
                try {
                    tdate = Date.valueOf(date + "-01-01");
                    Totalfee totalfee = new Totalfee();
                    json = JSONUtil.toJsonStr(totalfee.totalFee(date));
                } catch (Exception e) {
                    System.out.println("catch!3");
                    json = "date format error";
                }
            } else {
                json = "date format error";
            }
        }
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
