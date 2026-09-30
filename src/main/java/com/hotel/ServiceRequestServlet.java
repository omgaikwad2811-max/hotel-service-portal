
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
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String service = request.getParameter("service");
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Request Confirmation</title>");

        out.println("<style>");
        out.println("body {");
        out.println("font-family: Arial, sans-serif;");
        out.println("background: #f3f4f6;");
        out.println("display: flex;");
        out.println("justify-content: center;");
        out.println("align-items: center;");
        out.println("min-height: 100vh;");
        out.println("margin: 0;");
        out.println("}");

        out.println(".confirmation {");
        out.println("background: white;");
        out.println("padding: 40px;");
        out.println("border-radius: 14px;");
        out.println("box-shadow: 0 8px 25px rgba(0,0,0,0.10);");
        out.println("text-align: center;");
        out.println("width: 90%;");
        out.println("max-width: 550px;");
        out.println("}");

        out.println("h1 {");
        out.println("color: #16a34a;");
        out.println("}");

        out.println(".details {");
        out.println("text-align: left;");
        out.println("margin-top: 25px;");
        out.println("line-height: 1.9;");
        out.println("}");

        out.println(".button {");
        out.println("display: inline-block;");
        out.println("margin-top: 25px;");
        out.println("padding: 12px 25px;");
        out.println("background: #2563eb;");
        out.println("color: white;");
        out.println("text-decoration: none;");
        out.println("border-radius: 7px;");
        out.println("}");

        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='confirmation'>");

        out.println("<h1>Request Submitted Successfully!</h1>");

        out.println("<p>Thank you for using our Hotel Service Portal.</p>");

        out.println("<div class='details'>");

        out.println("<strong>Customer Name:</strong> "
                + escapeHtml(name) + "<br>");

        out.println("<strong>Contact Number:</strong> "
                + escapeHtml(contact) + "<br>");

        out.println("<strong>Selected Service:</strong> "
                + escapeHtml(service));

        out.println("</div>");

        out.println("<a class='button' href='index.jsp'>");
        out.println("Submit Another Request");
        out.println("</a>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    private String escapeHtml(String value) {

        if (value == null) {
            return "";
        }

        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
