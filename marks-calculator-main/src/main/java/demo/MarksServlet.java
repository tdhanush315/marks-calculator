package demo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MarksServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private final GradeCalculator calculator = new GradeCalculator();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int m1 = Integer.parseInt(request.getParameter("m1"));
            int m2 = Integer.parseInt(request.getParameter("m2"));
            int m3 = Integer.parseInt(request.getParameter("m3"));

            int total = calculator.total(m1, m2, m3);
            double average = calculator.average(m1, m2, m3);
            String grade = calculator.grade(m1, m2, m3);

            String result = (m1 >= 40 && m2 >= 40 && m3 >= 40)
                    ? "Pass" : "Fail";

            request.setAttribute("m1", m1);
            request.setAttribute("m2", m2);
            request.setAttribute("m3", m3);
            request.setAttribute("total", total);
            request.setAttribute("average", average);
            request.setAttribute("grade", grade);
            request.setAttribute("result", result);

            request.getRequestDispatcher("/marks-result.jsp")
                   .forward(request, response);

        } catch (IllegalArgumentException e) {
            response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Enter valid marks between 0 and 100."
            );
        }
    }
}
