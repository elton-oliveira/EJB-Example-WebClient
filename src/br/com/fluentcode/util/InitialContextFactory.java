package br.com.fluentcode.util;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class InitialContextFactory {
	
	private Context ctx;
	
	public Context getContext() throws NamingException{
		
		if(ctx != null){
			return ctx;
		}
		
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		p.put(Context.PROVIDER_URL, "remote://localhost:4447");
		p.put(Context.SECURITY_PRINCIPAL, "elton");
		p.put(Context.SECURITY_CREDENTIALS, "123");
		
		ctx = new InitialContext(p);
		
		return ctx; 
	}

}
