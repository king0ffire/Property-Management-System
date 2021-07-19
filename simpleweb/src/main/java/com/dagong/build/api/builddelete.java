package com.dagong.build.api;

import cn.hutool.json.JSONUtil;
import com.dagong.build.Build;
import com.dagong.build.Jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "builddelete", urlPatterns = "/build/delete")
public class builddelete extends HttpServlet {

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
        String name = null;
        int floornum = -1;
        int housenum = -1;
        Date date = null;
        int accept = -1;
        String layout = null;
        name = req.getParameter("name");
        if(req.getParameter("floornum")!=null) {
            try{
                floornum = Integer.valueOf(req.getParameter("floornum"));
            }catch (Exception e)
            {
                System.out.println("something wrong with floornum");
                bl=false;
            }
        }
        if(req.getParameter("housenum")!=null) {
            try{
                housenum = Integer.valueOf(req.getParameter("housenum"));
            }catch (Exception e)
            {
                System.out.println("something wrong with housenum");
                bl=false;
            }
        }
        if(req.getParameter("data")!=null) {
            try {
                date = Date.valueOf(req.getParameter("date"));
            } catch (Exception e) {
                System.out.println("something wrong with date");
                bl = false;
            }
        }
        if(req.getParameter("accept")!=null) {
            try {
                accept = Integer.valueOf(req.getParameter("accept"));
            } catch (Exception e) {
                System.out.println("something wrong with accept");
                bl = false;
            }
        }
        layout = req.getParameter("layout");

        if(bl!=false) {
            Jdbc jdbc = new Jdbc();
            Build build = new Build(0, name, floornum,
                    housenum, date, accept, layout);
            res=jdbc.deleteBuild(build);
            json = JSONUtil.toJsonStr("delete suceess:"+res);
        }else {
            json = JSONUtil.toJsonStr("something wrong with your input");
        }
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
