package edu.bhcc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Web Comment Form.
 */
public class WebPasswordForm extends HttpServlet {

    /**
     * Process HTTP GET Request.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter writer = response.getWriter();

        //  Here we embed HTML Form within the servlet.
        //  This is not recommended, but enough to get us started.
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<FORM ACTION='post_password' method='POST'>");
        writer.println("<h2>Password</h2>");
        writer.println("<input type='text' name='password'>");
        writer.println("<p><input type='submit'>");
        writer.println("<FORM>");
        writer.println("</body>");
        writer.println("</html>");
    }
}