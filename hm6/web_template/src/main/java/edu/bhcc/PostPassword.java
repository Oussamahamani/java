package edu.bhcc;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Post/Process Web Comments.
 */
public class PostPassword extends HttpServlet {

    /**
     * Process HTTP POST Request.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter writer = response.getWriter();

        String password = request.getParameter("password");
        String strength = "very weak";
        double pswdStr= 0;

        boolean specialChar = false;
        boolean containsNum = false;
        boolean containsUppercase = false;
        boolean longEnough = false;
        if(password.contains("@")|| password.contains("-")){
            pswdStr+=2.5;
            specialChar = true;
        }
        if(password.matches(".*\\d.*")){
            pswdStr+=2.5;
            containsNum= true;
        }
        if(!password.equals(password.toLowerCase())){
            pswdStr+=2.5;
            containsUppercase= true;
        }
        if(password.length()>=4){
            pswdStr+=2.5;
            longEnough = true;
        }
        if (pswdStr == 10.00) {
            strength = "perfect";
        } else if (pswdStr == 7.5) {
            strength = "strong";
        } else if (pswdStr == 5.00) {
            strength = "okay";
        } else if (pswdStr == 2.5) {
            strength = "weak";
        }
        //  Here we embed HTML Form within the servlet.
        //  This is not recommended, but enough to get us started.
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Your password is " + strength +"</h1>");
        if(pswdStr<10){
            writer.println("<h2>Tips to improve your password:</h2>");
        }
        if (!specialChar){
        writer.println("<h3>add special characters such as @ or - to make your password stronger</h3>");
        } if (!containsNum){
        writer.println("<h3>add numbers to your password</h3>");
        } if (!containsUppercase){
        writer.println("<h3>add uppercase letters</h3>");
        } if (!longEnough){
        writer.println("<h3>make your password longer than 4 letters</h3>");
        }
        writer.println("</body>");
        writer.println("</html>");
    }
}