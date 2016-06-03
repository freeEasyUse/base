package org.base.webservice.cxf.wb;

import javax.jws.WebService;

@WebService
public interface WebServiceServerWithCXF {

	public String sayHello(String name);
	
}
