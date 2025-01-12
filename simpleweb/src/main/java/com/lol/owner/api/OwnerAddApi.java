package com.lol.owner.api;

import cn.hutool.json.JSONUtil;
import com.lol.owner.dao.Owner;
import com.lol.owner.dao.OwnerBean;
import com.lol.owner.dao.OwnerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OwnerAddApi", urlPatterns = "/owner/add")
public class OwnerAddApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String owner_name = req.getParameter("owner_name");
        String owner_gender = req.getParameter("owner_gender");
        String owner_hometown = req.getParameter("owner_hometown");
        String owner_phone = req.getParameter("owner_phone");

        int gender = Integer.parseInt(owner_gender);
        OwnerDao ownerDao = new OwnerDao();
        Owner owner = new Owner();
        owner.setOwner_name(owner_name);
        if(gender == 1) {
            owner.setOwner_gender("男");
        } else {
            owner.setOwner_gender("女");
        }
        owner.setOwner_hometown(owner_hometown);
        owner.setOwner_phone(owner_phone);
        int res = ownerDao.insert(owner);
        boolean blres = (res==0?false:true);

        OwnerBean ownerBean = new OwnerBean();
        ownerBean.setRes(blres);
        String json = JSONUtil.toJsonStr(ownerBean);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();

    }
}
