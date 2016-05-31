package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//ʹ�ý�ͧ������ͧ��������
public class SessionNum implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		// TODO Auto-generated method stub
		HttpSession session = httpSessionEvent.getSession();
		ServletContext application = session.getServletContext();
		
		Object obj = application.getAttribute("num");
		
		if(obj == null){
			application.setAttribute("num", 1);
		} else {
			int n = (Integer)obj;
			application.setAttribute("num", n+1);
		}
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
