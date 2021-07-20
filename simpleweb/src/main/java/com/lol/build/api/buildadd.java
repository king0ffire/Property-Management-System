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

@WebServlet(name="buildadd",urlPatterns = "/build/add")
public class buildadd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doHttp(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doHttp(req, resp);
    }

    private  void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int res=0;
        boolean bl = true;
        String json = null;
        try{
            String name= req.getParameter("name");
            int floornum=Integer.valueOf(req.getParameter("floornum"));
            int housenum=Integer.valueOf(req.getParameter("housenum"));
            Date date=Date.valueOf(req.getParameter("date"));
            int accept=Integer.valueOf(req.getParameter("accept"));
            String layout=req.getParameter("layout");

            Jdbc jdbc=new Jdbc();
            Build build=new Build(0,name,floornum,
                    housenum,date,accept,layout);
            res= jdbc.addBuild(build);
        }catch (Exception e)
        {
            System.out.println("catch error!");
            bl=false;
        }
        if(bl)
        {
            json= JSONUtil.toJsonStr("add suceess");
        }else
        {
            json= JSONUtil.toJsonStr("something wrong with your input");
        }

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
