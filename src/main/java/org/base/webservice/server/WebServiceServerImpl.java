package org.base.webservice.server;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service("webServiceServer")
@WebService(endpointInterface = "org.base.webservice.server.WebServiceServer")
public class WebServiceServerImpl implements WebServiceServer {

	@Override
	public String sayHello(String name) {
		return "hello:"+ name;
	}

}
