/*
 * 文件名：UpdateEmpServlet.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：JuliusRandle
 * 修改时间：2017年11月28日
 */

package com.cheer.empmgrsystem.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.empmgrsystem.domain.Emp;
import com.cheer.empmgrsystem.service.EmpService;

@WebServlet(name = "updateEmp", urlPatterns = {"/servlet/updateEmp"})
public class UpdateEmpServlet extends HttpServlet
{
    private static final Logger LOGGER = LogManager.getLogger(UpdateEmpServlet.class);

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet method is invoked...");

        EmpService empService = (EmpService)this.getServletContext().getAttribute("empService");

        Emp emp = new Emp();
        emp.setEname(request.getParameter("ename"));
        emp.setJob(request.getParameter("job"));
        emp.setSal(Double.valueOf(request.getParameter("sal")));

        empService.update(emp);
        
        response.sendRedirect("../index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        this.doGet(request, response);
    }
}
