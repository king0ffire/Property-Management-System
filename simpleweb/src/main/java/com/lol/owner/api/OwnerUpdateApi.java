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

@WebServlet(name = "OwnerUpdateApi", urlPatterns = "/owner/update")
public class OwnerUpdateApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String owner_phone = req.getParameter("owner_phone");
        String owner_id = req.getParameter("owner_id");
        int res = 0;
        if(owner_phone.length() == 11) {
            OwnerDao ownerDao = new OwnerDao();
            Owner owner = new Owner();
            owner.setOwner_phone(owner_phone);
            owner.setOwner_id(owner_id);
            res = ownerDao.update(owner);
        }
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
