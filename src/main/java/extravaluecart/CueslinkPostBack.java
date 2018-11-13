package extravaluecart;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;

public class CueslinkPostBack extends HttpServlet {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	  {
	    try
		{
	    	
	    Datastore datastore;
	    KeyFactory keyFactory;
	    
	    datastore = DatastoreOptions.getDefaultInstance().getService(); // Authorized Datastore service
	    keyFactory = datastore.newKeyFactory().setKind("CuesLinkPostBack"); 
	    
	    	String IP = req.getParameter("IP");
	    	String TID = req.getParameter("TID");
	    	String Comm = req.getParameter("Comm");
	    	String RURL = req.getParameter("RURL");
	    	String AdvID = req.getParameter("AdvID");
	    	String Status = req.getParameter("Status");
	    	String AdvName = req.getParameter("AdvName");
	    	String SaleAmt = req.getParameter("SaleAmt");
	    	String TranRID = req.getParameter("TranRID");
	    	String TranDate = req.getParameter("TranDate");
	    	String TranTime = req.getParameter("TranTime");
	    	String Constant = req.getParameter("Constant");
	    	
	    	Key key = datastore.allocateId(keyFactory.newKey());
	    	 Entity incCueslinkPBEntity = Entity.newBuilder(key)  // Create the Entity
	    	      .set("IP", IP)          
	    	      .set("TID", TID)
	    	      .set("Comm",Comm)
	    	      .set("RURL",RURL)
	    	      .set("AdvID",AdvID)
	    	      .set("Status", Status)
	    	      .set("AdvName", AdvName)
	    	      .set("SaleAmt", SaleAmt)
	    	      .set("TranRID", TranRID)
	    	      .set("TranDate", TranDate)
	    	      .set("TranTime", TranTime)
	    	      .set("Constant", Constant)
	    	      .build();
	    	  datastore.put(incCueslinkPBEntity); // Save the Entity
	    	//  return bookEntity.getKey().getId();                     // The ID of the Key

		}
		catch(Exception e)
		{
		}
	  }
	  
	  @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	    doPost(req,resp);
	  }
	}
