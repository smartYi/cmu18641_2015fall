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
import model.Automobile;
import model.Optionset;

@WebServlet("/ConfigureCar")
public class ConfigureCar extends HttpServlet {
	static final long serialVersionUID = 1L;
	static final String HOST = "localhost";
	static final int PORT = 8888;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();

		String modelName = request.getParameter("automobile");
		if (modelName == null) {
			System.out.println("Nothing can be congigured");
			return;
		}

		SelectCarIOImplement selectCarIO = new SelectCarIOImplement("localhost", PORT);
		Automobile automobile = selectCarIO.getAutomobile(modelName);

		// Print a table UI
		out.print("<html>" + "<head><title>Customize your car</title></head>" + "<body>"
				+ "<form method=\"post\" action=\"ConfigureCar\">" + "<table border=\"1px\" style=\"width:200px\">"
				+ "<tr><td>Make/Model</td>" + "<td>" + automobile.getMake() + " " + automobile.getModel()
				+ "</td></tr>");

		ArrayList<Optionset> list = automobile.getOptionSets();
		for (int i = 0; i < list.size(); i++) {
			out.println("<tr>" + "<td>" + list.get(i).getName() + "</td><td>" + "<select name=\""
					+ list.get(i).getName() + "\">");
			for(int j=0;j<list.get(i).getOpt().size();j++) {
				out.println("<option value=\"" + list.get(i).getOpt().get(j).getName() + "\">"
						+list.get(i).getOpt().get(j).getName()
						+" ($" + list.get(i).getOpt().get(j).getPrice() + ")"
						+"</option>");
			}
			out.println("</select></td>");
		}
		
		out.print("</table>"
                + "<input type=\"hidden\" name=\"automobile\" value=\""+ automobile.getModel() +"\">"
                + "<input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "</body></html>");    
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelName = request.getParameter("automobile");
		
		SelectCarIOImplement selectCarIO = new SelectCarIOImplement(HOST, PORT);
		Automobile automobile = selectCarIO.getAutomobile(modelName);
		
		ArrayList<Optionset> optionsets = automobile.getOptionSets();
		for(int i=0;i<optionsets.size();i++) {
			Optionset optionset = optionsets.get(i);
			String optionName = request.getParameter(optionset.getName());
			automobile.setOptionChoice(optionset.getName(), optionName);
		}
		request.setAttribute("automobile",automobile);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

}
