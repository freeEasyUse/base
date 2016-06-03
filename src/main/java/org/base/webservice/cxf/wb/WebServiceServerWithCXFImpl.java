package org.base.webservice.cxf.wb;

import javax.jws.WebService;

@WebService(endpointInterface="org.base.webservice.cxf.wb.WebServiceServerWithCXF",serviceName="webServiceServerWithCXF")
public class WebServiceServerWithCXFImpl implements WebServiceServerWithCXF {

	@Override
	public String sayHello(String name) {
		return "hello:"+name+" with cxf";
	}

}
