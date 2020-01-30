package base;

import java.util.ArrayList;
import java.util.List;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class Requesthdrs extends BaseClass{
	
	public static Headers webheaders()
	{
		Header h1 = new Header("ReqId", "Mobile");
		Header h2 = new Header("HDR-OSId", "Andro");
		Header h3 = new Header("HDR-AppId", "App");
		Header h4 = new Header("HDRId", "Test");
		Header h5 = new Header("TransactionId", BaseClass.transactionid());
		Header h6 = new Header("ContentType", "application/json");
		Header h7 = new Header("Accept", "application/json");
	
	    List<Header> list = new ArrayList<Header>();
	    list.add(h1);
	    list.add(h2);
	    list.add(h3);
	    list.add(h4);
	    list.add(h5);
	    list.add(h6);
	    list.add(h7);
	    Headers webhdrs = new Headers(list);
	    return webhdrs;
	}
	
}

