package com.max.slw.api;

import cn.hutool.json.JSONUtil;
import com.max.slw.dao.DemoDao;
import com.max.slw.dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserAddApi", urlPatterns = "/useradd")
public class UserAddApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }
    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1. 接受传入的http 参数 key: name
        String name = req.getParameter("name");

        // 执行中间逻辑
        DemoDao dao = new DemoDao();
        User user = new User();
        user.setName(name);
        int res = dao.insert(user);
        boolean blres = (res==0?false:true);

        // 生成需要输出的json字符
        DemoBean bean = new DemoBean();
        bean.setRes(blres);
        String json = JSONUtil.toJsonStr(bean);
        System.out.println(json);
        System.out.println("===");
        //2. 传出一个boolean值
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
