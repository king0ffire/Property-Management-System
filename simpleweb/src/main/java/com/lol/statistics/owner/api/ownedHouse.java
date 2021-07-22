package com.lol.statistics.owner.api;

import cn.hutool.json.JSONUtil;
import com.lol.statistics.owner.OH;
import com.lol.statistics.owner.Ownedhouse;
import com.lol.statistics.owner.Property;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ownedHouse", urlPatterns = "/statistics/owner/ownedhouse")
public class ownedHouse extends HttpServlet {
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
        List<OH> oh = null;
        String owner_id = null;
        List<Ownedhouse> ownedhouseList = new ArrayList<>();
        try {
            owner_id = req.getParameter("id");
            Property property = new Property();
            oh = property.ownerHouse();
        } catch (Exception e) {
            System.out.println("catch error!");
            bl = false;
        }
        System.out.println("1! " + oh);
        if (bl) {
            for (int i = 0; i < oh.size(); i++) {
                Ownedhouse ownedhouse = null;
                if (owner_id != null) {
                    if (owner_id.equals(oh.get(i).getOwner_id())) {
                        ownedhouse = new Ownedhouse(oh.get(i).getOwner_name(), oh.get(i).getBlock_id(),
                                oh.get(i).getRoom_no(), oh.get(i).getCheck_in_date(), oh.get(i).getUnit_type(),
                                oh.get(i).getArea());
                        ownedhouseList.add(ownedhouse);
                    }
                } else {
                    ownedhouse = new Ownedhouse(oh.get(i).getOwner_name(), oh.get(i).getBlock_id(),
                            oh.get(i).getRoom_no(), oh.get(i).getCheck_in_date(), oh.get(i).getUnit_type(),
                            oh.get(i).getArea());
                    ownedhouseList.add(ownedhouse);
                }

            }
            json = JSONUtil.toJsonStr(ownedhouseList);
        } else {
            json = JSONUtil.toJsonStr("something wrong with your input");
        }

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
