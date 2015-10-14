package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.SelectCarIOImplement;

/**
 * Servlet implementation class SelectAut
 */
@WebServlet("/SelectAuto")
public class SelectAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//static final String HOST = "localhost";
	static final int PORT = 8888;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectAuto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();

		out.print("<html>" + "<head><title>Welcome to customize your car</title></head>"
				+ "<body>Please select your car model</body><br>" + "<form method=\"get\" action=\"ConfigureCar\">"
				+ "<select name=\"automobile\">");

		SelectCarIOImplement selectCarIO = new SelectCarIOImplement("localhost", PORT);
		ArrayList<String> list = selectCarIO.getModelList();
		for (int i = 0; i < list.size(); i++) {
			out.println("<option value=\"" + list.get(i) + "\">" + list.get(i) + "</option>");
		}

		out.print("</select>" + "<input type=\"submit\" value=\"Submit\">" + "</form>" + "</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
