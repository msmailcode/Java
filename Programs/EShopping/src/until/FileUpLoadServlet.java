package until;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javabean.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import dao.RegisterDAO;

//核心之商品的增加和图片的上传
public class FileUpLoadServlet extends HttpServlet {

	public FileUpLoadServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		String path = request.getRealPath("/");
		System.out.println(path);
		//临时文件
		File file = new File(path + "temp");
    	DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024,file);
    	ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
    	try {
			List<FileItem> list = servletFileUpload.parseRequest(request);
			Hashtable<String,String> hashTable = new Hashtable<String, String>();
			for (FileItem fileItem : list) {
				if(fileItem.isFormField()) {	//一般的文本 type="text" 
					String name = fileItem.getFieldName();
					String value = fileItem.getString("GBK");
					hashTable.put(name, value);
					request.setAttribute(name, value);
				} else {	//文件 type="file"
					String name = fileItem.getFieldName();
					String value = fileItem.getName();		//文件的名字
					int startIndex = value.lastIndexOf("\\");
					String fileName = value.substring(startIndex + 1);
					request.setAttribute(name, fileName);
					hashTable.put(name, fileName);
					fileItem.write(new File(path + "up",fileName));	//可以代替下面的代码
					
				}
			}
			String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?,?)";
			RegisterDAO dao = new RegisterDAO();
			int n = dao.AddBook(sql, Integer.parseInt(hashTable.get("typeid")), hashTable.get("name"), Float.parseFloat(hashTable.get("price")), Float.parseFloat(hashTable.get("saleprice")), hashTable.get("descript"), hashTable.get("contents"), hashTable.get("fileName"), hashTable.get("leavetime"), Integer.parseInt(hashTable.get("storage")), hashTable.get("provider"), hashTable.get("marque"), hashTable.get("unit"));
			if(n > 0){
				out.print("<script type='text/javascript'>alert('增加商品成功！')</script>");
			}
			String sql1 = "select * from book";
			ArrayList<Book> arrayList = dao.ListAllBookInformation(sql1);
			request.setAttribute("arrayList", arrayList);
			request.getRequestDispatcher("/Admin/adminMerSpe.jsp").include(request, response);
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
