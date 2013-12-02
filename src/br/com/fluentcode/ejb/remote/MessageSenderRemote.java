package br.com.fluentcode.ejb.remote;

import javax.jms.JMSException;

public interface MessageSenderRemote {
	
	void sendMessage(String msg) throws JMSException;

}
