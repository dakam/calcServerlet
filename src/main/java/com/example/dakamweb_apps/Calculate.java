package com.example.dakamweb_apps;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONException;
import org.json.JSONObject;


@WebServlet(name = "Calculate", value = "/calculate")
public class Calculate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ftop = request.getParameter("topfnum");
        String stop = request.getParameter("topsnum");
        String fbot = request.getParameter("botfnum");
        String sbot = request.getParameter("botsnum");

        String topstr="";
        String botstr="";
        String result="";
        int bres=0;
        int tres=0;

        if(!ftop.equals("") && !stop.equals("")) {
            int ft = Integer.valueOf(ftop);
            int st = Integer.valueOf(stop);
            tres = ft+st;
            topstr = ftop +" + "+ stop+" = "+tres;

        }

        if(!fbot.equals("") && !sbot.equals("")) {
            int fb = Integer.valueOf(fbot);
            int sb = Integer.valueOf(sbot);
            bres = fb*sb;
            botstr = fbot +" * "+ sbot+" = "+bres;

        }



        JSONObject json = new JSONObject();
        try {
            json.put("add", tres);
            json.put("mul", bres);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String output = json.toString();
        System.out.println(output);
        response.setContentType("application/json");
        response.getWriter().print(output);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




/*            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
               out.println("<head>");
                out.println("<head>");
        out.println( "<link href=\"css/styles.css\" type=\"text/css\" rel=\"stylesheet\" />");
        out.println("</head>");
        out.println("<div class =\"res\" >");
            out.println("<h5>" +topstr+"</h5>");
            out.println("<h5>" +botstr+"</h5>");
            out.println("</div >");

            out.println("</body></html>");*/



    }
}
