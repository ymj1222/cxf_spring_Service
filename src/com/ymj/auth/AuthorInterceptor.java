package com.ymj.auth;
 
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
 
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.NodeList;
 
public  class AuthorInterceptor extends AbstractPhaseInterceptor<SoapMessage>{
 
	private SAAJInInterceptor saa = new SAAJInInterceptor();
	 public  AuthorInterceptor() {
		  super(Phase.PRE_PROTOCOL);
		  getAfter().add(SAAJInInterceptor.class.getName());
		 }
	 
	
	
	public void handleMessage(SoapMessage message) throws Fault {
		System.out.println("服务端验证1");
		  SOAPMessage mess = message.getContent(SOAPMessage.class);
		  if (mess == null) {			  
			   saa.handleMessage(message);
			   mess = message.getContent(SOAPMessage.class);
			  }
			  SOAPHeader head = null;
			  try {
			   head = mess.getSOAPHeader();
			  } catch (Exception e) {
			   e.printStackTrace();
			  }
			  if (head == null) {
			   return;
			  }
			  NodeList nodes = head.getElementsByTagName("a");
			  NodeList nodepass = head.getElementsByTagName("b");
 
			  if("ymj".equals(nodes.item(0).getTextContent())&&("223618".equals(nodepass.item(0).getTextContent()))){
				    System.out.println("验证成功");
			  }else {
					SOAPException soapExc = new SOAPException("认证错误");
					throw new Fault(soapExc);
				}
			  System.out.println("恭喜你验证成功，使用愉快");
			 }
	}
