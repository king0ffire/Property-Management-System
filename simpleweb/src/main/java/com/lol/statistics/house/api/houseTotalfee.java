package com.lol.statistics.house.api;

import cn.hutool.json.JSONUtil;
import com.lol.statistics.house.HOCP;
import com.lol.statistics.house.Housefeeinfo;
import com.lol.statistics.house.Housetotalfee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "houseTotalfee", urlPatterns = "/statistics/housetotalfee")
public class houseTotalfee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int res = 0;
        boolean bl = true;
        String json = null;
        List<HOCP> HOCP = null;
        String property_id = null;
        List<Housefeeinfo> housefeeinfoList = new ArrayList<>();
        try {
            property_id = req.getParameter("id");
            Housetotalfee housetotalfee = new Housetotalfee();
            HOCP = housetotalfee.houseTotalfee();
        } catch (Exception e) {
            System.out.println("catch error!");
            bl = false;
        }
        System.out.println("1! " + HOCP);
        if (bl) {
            for (int i = 0; i < HOCP.size(); i++) {
                Housefeeinfo housefeeinfo = null;
                if (property_id != null) {
                    System.out.println("property_id:                 "+property_id);
                    System.out.println("HOCP.get(i).getProperty_id():"+HOCP.get(i).getProperty_id());
                    if (property_id.equals(HOCP.get(i).getProperty_id())) {
                        housefeeinfo = new Housefeeinfo(HOCP.get(i).getBlock_id(), HOCP.get(i).getRoom_no(),
                                HOCP.get(i).getCheck_in_date(), HOCP.get(i).getUnit_type(), HOCP.get(i).getArea(),
                                HOCP.get(i).getOwner_name(), HOCP.get(i).getCost_reason(), HOCP.get(i).getCost_time()
                                , HOCP.get(i).getCost_total(), HOCP.get(i).getPay_money(), HOCP.get(i).getPay_time(),
                                HOCP.get(i).getPay_remark());
                        housefeeinfoList.add(housefeeinfo);
                        System.out.println("add!2");
                    }
                } else {
                    housefeeinfo = new Housefeeinfo(HOCP.get(i).getBlock_id(), HOCP.get(i).getRoom_no(),
                            HOCP.get(i).getCheck_in_date(), HOCP.get(i).getUnit_type(), HOCP.get(i).getArea(),
                            HOCP.get(i).getOwner_name(), HOCP.get(i).getCost_reason(), HOCP.get(i).getCost_time(),
                            HOCP.get(i).getCost_total(), HOCP.get(i).getPay_money(), HOCP.get(i).getPay_time(),
                            HOCP.get(i).getPay_remark());
                    housefeeinfoList.add(housefeeinfo);
                    System.out.println("add!1");
                    System.out.println(housefeeinfo);
                }
            }
            json = JSONUtil.toJsonStr(housefeeinfoList);
            System.out.println("housefeeinfoList:"+housefeeinfoList);
            System.out.println("json:"+json);
        } else {
            json = JSONUtil.toJsonStr("something wrong with your input");
        }

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
