package com.hotel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/service-request")
public class ServiceRequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String service = request.getParameter("service");
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'><head><meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Request Confirmation</title>");
        out.println("<style>");
        out.println("body{font-family:Arial,sans-serif;background:#f3f4f6;display:flex;justify-content:center;align-items:center;min-height:100vh;margin:0}");
        out.println(".confirmation{background:white;padding:40px;border-radius:14px;box-shadow:0 8px 25px rgba(0,0,0,.10);text-align:center;width:90%;max-width:550px}");
        out.println("h1{color:#16a34a}.details{text-align:left;margin-top:25px;line-height:1.9}");
        out.println(".button{display:inline-block;margin-top:25px;padding:12px 25px;background:#2563eb;color:white;text-decoration:none;border-radius:7px}");
        out.println("</style></head><body>");
        out.println("<div class='confirmation'>");
        out.println("<h1>Request Submitted Successfully!</h1>");
        out.println("<p>Thank you for using our Hotel Service Portal.</p>");
        out.println("<div class='details'>");
        out.println("<strong>Customer Name:</strong> " + escapeHtml(name) + "<br>");
        out.println("<strong>Contact Number:</strong> " + escapeHtml(contact) + "<br>");
        out.println("<strong>Selected Service:</strong> " + escapeHtml(service));
        out.println("</div>");
        out.println("<a class='button' href='index.jsp'>Submit Another Request</a>");
        out.println("</div></body></html>");
    }

    private String escapeHtml(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace(""", "&quot;")
                .replace("'", "&#39;");
    }
}
