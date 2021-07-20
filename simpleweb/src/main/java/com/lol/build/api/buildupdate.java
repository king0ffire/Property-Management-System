package com.lol.build.api;

import cn.hutool.json.JSONUtil;
import com.lol.build.Build;
import com.lol.build.Jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "buildupdate", urlPatterns = "/build/update")
public class buildupdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int res = 0;
        boolean bl = true;
        String json = null;
        String sname = null;
        int sfloornum = -1;
        int shousenum = -1;
        Date sdate = null;
        int saccept = -1;
        String slayout = null;
        String dname = null;
        int dfloornum = -1;
        int dhousenum = -1;
        Date ddate = null;
        int daccept = -1;
        String dlayout = null;
        sname = req.getParameter("sname");
        if(req.getParameter("sfloornum")!=null) {
            try{
                sfloornum = Integer.valueOf(req.getParameter("sfloornum"));
                dfloornum = Integer.valueOf(req.getParameter("dfloornum"));
            }catch (Exception e)
            {
                System.out.println("something wrong with floornum");
                bl=false;
            }
        }
        if(req.getParameter("shousenum")!=null) {
            try{
                shousenum = Integer.valueOf(req.getParameter("shousenum"));
                dhousenum = Integer.valueOf(req.getParameter("dhousenum"));
            }catch (Exception e)
            {
                System.out.println("something wrong with housenum");
                bl=false;
            }
        }
        if(req.getParameter("sdate")!=null) {
            try {
                sdate = Date.valueOf(req.getParameter("sdate"));
                ddate = Date.valueOf(req.getParameter("ddate"));
            } catch (Exception e) {
                System.out.println("something wrong with date");
                bl = false;
            }
        }
        if(req.getParameter("saccept")!=null) {
            try {
                saccept = Integer.valueOf(req.getParameter("saccept"));
                daccept = Integer.valueOf(req.getParameter("daccept"));
            } catch (Exception e) {
                System.out.println("something wrong with accept");
                bl = false;
            }
        }
        slayout = req.getParameter("slayout");
        dlayout = req.getParameter("dlayout");

        if(bl!=false) {
            Jdbc jdbc = new Jdbc();
            Build build1 = new Build(0, sname, sfloornum,
                    shousenum, sdate, saccept, slayout);
            Build build2 = new Build(0, dname, dfloornum,
                    dhousenum, ddate, daccept, dlayout);
            res=jdbc.updateBuild(build1,build2);
            json = JSONUtil.toJsonStr("update suceess:"+res);
        }else {
            json = JSONUtil.toJsonStr("something wrong with your input");
        }
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
