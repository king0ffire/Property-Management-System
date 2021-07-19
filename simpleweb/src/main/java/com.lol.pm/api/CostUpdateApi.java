package com.lol.pm.api;

import com.lol.pm.dao.Cost;
import com.lol.pm.dao.CostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CostUpdateApi", urlPatterns = "/cost/update")
public class CostUpdateApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) {
        String cost_total_str = req.getParameter("cost_total");
        String cost_id = req.getParameter("cost_id");

        CostDao costDao = new CostDao();
        Cost cost = new Cost();
    }
}
