
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/PresServlet")
public class PresServlet extends HttpServlet {
	private PresDAO presDAO;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		presDAO = new PresDAO(context);
	}

	// private ServletContext servletContext;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String term1 = req.getParameter("term");
		if (term1.equals("")) {
            term1="1";
		}
		int term = Integer.parseInt(term1);


		if (term < 1) {
			term = 44;
		}
		if (term > 44) {
			term = 1;
		}
		President president;
		President president1;
		President president2;
		President president3;

		president = presDAO.getPresident(term);
		president1 = presDAO.getTrivia(term);
		president2 = presDAO.getPresidentPhoto(term);
		president3 = presDAO.getPresidentSignature(term);

		req.setAttribute("selected", president);
		req.setAttribute("selectedTri", president1);
		req.setAttribute("selectPhoto", president2);
		req.setAttribute("selectSignature", president3);

		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/pres.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}
}

// for (String string : presList) {
// System.out.print(string + " ");
// }
// System.out.println();
//
// public ArrayList<President> filterPresParty(ArrayList<President> presArray) {
// ArrayList<President> presPartyFilter = new ArrayList<>();
// System.out.println("FILTERING PRESIDENTS...");
// for (President i : presArray) {
// if (i.getParty().equals("Whig")) {
// presPartyFilter.add(i);
// }
// }
//
// return presPartyFilter;
// }
//
// public ArrayList<President> filterMiddleName(ArrayList<President> presArray)
// {
// ArrayList<President> presMiddleNameFilter = new ArrayList<>();
// System.out.println("FILTERING PRESIDENTS...");
// for (President i : presArray) {
// if (!(i.getMiddleName().equals(""))) {
// presMiddleNameFilter.add(i);
// }
// }
//
// return presMiddleNameFilter;
// }
//
// public ArrayList<President> filterTerm(ArrayList<President> presArray) {
// ArrayList<President> presTermFilter = new ArrayList<>();
// System.out.println("FILTERING TERMS...");
// for (President i : presArray) {
// if ((i.getEndYear() - i.getStartYear()) < 4) {
// presTermFilter.add(i);
// }
// }
//
// return presTermFilter;
// }
// public ArrayList<President> filterLastName(ArrayList<President> presArray) {
// ArrayList<President> presLastNameFilter = new ArrayList<>();
// System.out.println("FILTER LAST NAMES");
// for (President i : presArray) {
// if (i.getLastName().charAt(0) == 'R') {
// presLastNameFilter.add(i);
// }
// }
// return presLastNameFilter;
// }
// public ArrayList<President> textReader() { // this is for text file to read
// ArrayList<President> textArray = new ArrayList<President>();
// BufferedReader bufIn = null;
// try {
// bufIn = new BufferedReader ( new FileReader("presidentscsv.txt"));
//
// String banana;
// while ((banana = bufIn.readLine()) != null) {
// String[] presList = banana.split(" ");
// }
// }
// catch (IOException e) {
// System.err.println(e);
// }
// return textArray;
//
// }