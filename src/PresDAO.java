import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.servlet.ServletContext;

public class PresDAO {
	private static final String filename = "WEB-INF/presidents_csv.txt";
	private static final String filenameTrivia = "WEB-INF/presidentstrivia.txt";
	private static final String filephoto = "WEB-INF/presidentsphotos.csv";
	private static final String filenameSignature = "WEB-INF/presidents_signature.csv";


	private ServletContext servletContext;
	public ArrayList<President> oldArray = new ArrayList<President>();
	public ArrayList<President> triviaArray = new ArrayList<President>();
	public ArrayList<President> photoArray = new ArrayList<President>();
	public ArrayList<President> signatureArray = new ArrayList<President>();

	
	public PresDAO(){
	}
	
	public PresDAO(ServletContext context) {
		servletContext = context;
		loadPresFromFile();
		loadPresTrivia();
		loadPresPhotos();
		loadPresSignature();
	}
	
	public President getPresident(int term){
		return oldArray.get(term-1);
	}
	public President getTrivia(int term){
		return triviaArray.get(term-1);
	}
	public President getPresidentPhoto(int term) { 
        return photoArray.get(term-1); 
    }
	public President getPresidentSignature(int term) { 
		return signatureArray.get(term-1); 
	}
	

	public void loadPresFromFile() {
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		InputStream is = servletContext.getResourceAsStream(filename);
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = buf.readLine()) != null) {
                String[] presList = line.split(", ");
                President president = new President();
                president.setTermNumber(Integer.parseInt(presList[0]));
                president.setFirstName(presList[1]);
                president.setMiddleName(presList[2]);
                president.setLastName(presList[3]);
                String[] presYears = presList[4].split("-");
                president.setStartYear(Integer.parseInt(presYears[0]));
                president.setEndYear(Integer.parseInt(presYears[1]));
                president.setParty(presList[5]);
                president.setvp(presList[6]);
                oldArray.add(president);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	public void loadPresTrivia(){
		InputStream is = servletContext.getResourceAsStream(filenameTrivia);
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = buf.readLine()) != null) {
                String[] presList = line.split("- ");
                President presidentTriv = new President();
                presidentTriv.setTrivia(presList[1]);
                triviaArray.add(presidentTriv);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	public void loadPresPhotos(){
		InputStream is = servletContext.getResourceAsStream(filephoto);
        try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = buf.readLine()) != null) {
                String[] presPhoto = line.split(",");
                President presidentPhoto = new President();
                presidentPhoto.setPhoto(presPhoto[1]);
                photoArray.add(presidentPhoto); 
            }
        } catch (Exception e) {
            System.err.println(e);
        }
	}
	public void loadPresSignature(){
		InputStream is = servletContext.getResourceAsStream(filenameSignature);
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] presSignature = line.split(", ");
				President presidentSignature = new President();
				presidentSignature.setSignature(presSignature[1]);
				signatureArray.add(presidentSignature); 
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
