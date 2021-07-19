package com.lol.house.api;

import cn.hutool.json.JSONUtil;
import com.lol.house.dao.Property;
import com.lol.house.dao.PropertyRun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "PropertyAddApi", urlPatterns = "/house/add")
public class PropertyAddApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) {
        int block_id = Integer.parseInt(req.getParameter("build_id"));
        int room_no = Integer.parseInt(req.getParameter("house_id"));
        Date check_in_date = Date.valueOf(req.getParameter("check_in_date"));
        String unit_type = req.getParameter("house_type");
        int area = Integer.parseInt(req.getParameter("house_area"));
        String landlord_id = req.getParameter("house_id");


        PropertyRun dao = new PropertyRun();
        Property property = new Property();
        property.setBlock_id(block_id);
        property.setRoom_no(room_no);
        property.setCheck_in_date(check_in_date);
        property.setUnit_type(unit_type);
        property.setArea(area);
        property.setLandlord_id(landlord_id);
        int res = dao.insertProperty(property);
        String json = JSONUtil.toJsonStr("Inserted Successfully: " + res);


        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = null;
        try {
            pw = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.write(json);
        pw.flush();
    }
}
