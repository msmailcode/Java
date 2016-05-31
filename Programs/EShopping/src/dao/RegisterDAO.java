package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javabean.Admin;
import javabean.Book;
import javabean.Comment;
import javabean.LeaveWord;
import javabean.Member;
import javabean.OrderBean;
import javabean.OrderByCate;
import javabean.OrderByXL;
import javabean.OrderDetail;
import javabean.OrderInfo;
import javabean.Orders;
import javabean.TypeInfo;


public class RegisterDAO {
	
	String url = "jdbc:microsoft:sqlserver://127.0.0.1:1433;DatabaseName=bookstore";
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Statement st = null;
	
	public RegisterDAO(){
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} 
	
	/*
	 * �û�ע��
	 */
	public int AddRegister(String sql,String userName,String Name,String sex,String passWord,String card,String Email,String address,String regtime){
		int n = 0;
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			//RegisterBean register = new RegisterBean();
			pst.setString(1,userName);
			pst.setString(2,Name);
			pst.setString(3,sex);
			pst.setString(4,passWord);
			pst.setString(5,card);
			pst.setString(6,Email);
			pst.setString(7,address);
			pst.setString(8,regtime);
			n = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
				try {
					if(pst != null){
						pst.close();
					}
					if(conn != null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return n;
	}
	/*
	 * ������Ʒ����
	 */
	public int AddInfo(String sql,String typeName,String typeInfo){
		int n = 0;
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setString(1, typeName);
			pst.setString(2, typeInfo);
			n = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(pst != null){
					pst.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return n;
	}
	
	/*
	 * ��½����û������������֤
	 */
	public int CheckPesson(String sql,String userName,String passWord){
		int n = 0;
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, passWord);
			rs = pst.executeQuery();
			
			if(rs.next()){
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(pst != null){
					pst.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return n;
	}
	
	/*
	 * ����û�����Ψһ��
	 */
	public int CheckName(String sql,String userName){
		int n = 0;
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst =  conn.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			if(rs.next()){
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(pst != null){
					pst.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		return n;
	}
	/*
	 * �������Ա��½
	 */
	public int CheckAdmin(String sql,String adminuserName,String adminpassWord){
		int n = 0;
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst =  conn.prepareStatement(sql);
			pst.setString(1, adminuserName);
			pst.setString(2, adminpassWord);
			rs = pst.executeQuery();
			if(rs.next()){
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(pst != null){
					pst.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		return n;
	}
	
	/*
	 * ��ʾ���е���Ʒ����
	 */
	public ArrayList<TypeInfo> ListAllInformation(String sql) {
		ArrayList<TypeInfo> arrayList = new ArrayList<TypeInfo>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TypeInfo info = new TypeInfo();
				info.setId(rs.getInt("id"));
				info.setTypeName(rs.getString("typeName"));
				info.setTypeInfo(rs.getString("typeInfo"));
				arrayList.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	
	//ɾ�����е�ȫ������,���±��е�����ȫ������
	public int del(String sql){
		int n = 0;
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			n = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n;
	}
	
	/*
	 * ͨ��ID���ҳ�������
	 */
	public TypeInfo Modinfo(int userID) {
		TypeInfo type = new TypeInfo();
		String sql = "select * from booktype where id=?";
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userID);
			rs = pst.executeQuery();
			while(rs.next()){
				type.setId(rs.getInt("id"));
				type.setTypeName(rs.getString("typeName"));
				type.setTypeInfo(rs.getString("typeInfo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return type;
	}
	/*
	 * ������Ʒ
	 */
	public int AddBook(String sql,int typeid,String name,float price,float saleprice,String descript,String contents,String fileName,String leavetime,int storage,String provider,String marque,String unit){
		int n = 0;
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setInt(1, typeid);
			pst.setString(2, name);
			pst.setFloat(3, price);
			pst.setFloat(4, saleprice);
			pst.setString(5, descript);
			pst.setString(6, contents);
			pst.setString(7, "up/" + fileName);
			pst.setString(8, leavetime);
			pst.setInt(9, storage);
			pst.setString(10, provider);
			pst.setString(11, marque);
			pst.setString(12, unit);
			n = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(pst != null){
					pst.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return n;
	}
	
	/*
	 * ��ʾ���е���
	 */
	public ArrayList<Book> ListAllBookInformation(String sql) {
		ArrayList<Book> arrayList = new ArrayList<Book>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTypeid(rs.getInt("typeid"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getFloat("price"));
				book.setSaleprice(rs.getFloat("saleprice"));
				book.setDescript(rs.getString("descript"));
				book.setContents(rs.getString("contents"));
				book.setFileName(rs.getString("fileName"));
				book.setLeavetime(rs.getString("leavetime"));
				book.setStorage(rs.getInt("storage"));
				book.setProvider(rs.getString("provider"));
				book.setMarque(rs.getString("marque"));
				book.setUnit(rs.getString("unit"));
				arrayList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	
	/*
	 * ͨ��id����Ȿ�����ϸ��Ϣ
	 */
	public Book ModInfoBook(int userID) {
		Book book = new Book();
		String sql = "select * from book where id=?";
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userID);
			rs = pst.executeQuery();
			while(rs.next()){
				book.setId(rs.getInt("id"));
				book.setTypeid(rs.getInt("typeid"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getFloat("price"));
				book.setSaleprice(rs.getFloat("saleprice"));
				book.setDescript(rs.getString("descript"));
				book.setContents(rs.getString("contents"));
				book.setFileName(rs.getString("fileName"));
				book.setLeavetime(rs.getString("leavetime"));
				book.setStorage(rs.getInt("storage"));
				book.setProvider(rs.getString("provider"));
				book.setMarque(rs.getString("marque"));
				book.setUnit(rs.getString("unit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;
	}
	
	/*
	 * ͨ��ID���ҳ�ĳ����Ա����ϸ��Ϣ
	 */
	public Member QueryMember(int userID) {
		Member member = new Member();
		String sql = "select * from register where id=?";
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userID);
			rs = pst.executeQuery();
			while(rs.next()){
				member.setId(rs.getInt("id"));
				member.setUserName(rs.getString("userName"));
				member.setName(rs.getString("name"));
				member.setSex(rs.getString("sex"));
				member.setPassWord(rs.getString("passWord"));
				member.setCard(rs.getString("card"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setRegtime(rs.getString("regtime"));
				member.setState(rs.getInt("state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	/*
	 * ��ʾ���еĻ�Ա��Ϣ
	 */
	public ArrayList<Member> ListAllMemberInformation(String sql) {
		ArrayList<Member> arrayList = new ArrayList<Member>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setUserName(rs.getString("userName"));
				member.setName(rs.getString("Name"));
				member.setSex(rs.getString("sex"));
				member.setPassWord(rs.getString("passWord"));
				member.setCard(rs.getString("card"));
				member.setEmail(rs.getString("Email"));
				member.setAddress(rs.getString("address"));
				member.setRegtime(rs.getString("regtime"));
				member.setState(rs.getInt("state"));
				arrayList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	/*
	 * ɾ��ĳ����֮ǰ���ж��Ƿ��ж�������
	 */
	public int CheckID(String sql){
		int n = 0;
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst =  conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(pst != null){
					pst.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		}
		return n;
	}
	
	/*
	 * ��ʾ���ж�������Ϣ
	 */
	public ArrayList<Orders> ListAllOrdersInformation(String sql) {
		ArrayList<Orders> arrayList = new ArrayList<Orders>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Orders orders = new Orders();
				orders.setId(rs.getInt("id"));
				orders.setUserID(rs.getInt("userID"));
				orders.setDatatime(rs.getString("datatime"));
				orders.setSaveName(rs.getString("saveName"));
				orders.setSavePhone(rs.getString("savePhone"));
				orders.setSaveAddress(rs.getString("saveAddress"));
				orders.setZip(rs.getString("zip"));
				orders.setDeliverymode(rs.getInt("deliverymode"));
				orders.setMoneymode(rs.getInt("moneymode"));
				orders.setState(rs.getInt("state"));
				arrayList.add(orders);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	
	/*
	 * ͨ�����ֲ��ҳ��˵�ȫ����Ϣ
	 */
	public Member ToModRegister(String userName) {
		Member member = new Member();
		String sql = "select * from register where userName=?";
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			while(rs.next()){
				member.setId(rs.getInt("id"));
				member.setUserName(rs.getString("userName"));
				member.setName(rs.getString("name"));
				member.setSex(rs.getString("sex"));
				member.setPassWord(rs.getString("passWord"));
				member.setCard(rs.getString("card"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setRegtime(rs.getString("regtime"));
				member.setState(rs.getInt("state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	
	/*
	 * ��ʾ���жԱ��������
	 */
	public ArrayList<Comment> ListAllCommentInformation(String sql) {
		ArrayList<Comment> arrayList = new ArrayList<Comment>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setUserName(rs.getString("userName"));
				comment.setBookid(rs.getInt("bookid"));
				comment.setDatatime(rs.getString("datatime"));
				comment.setContents(rs.getString("contents"));
				arrayList.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	
	/*
	 * ͨ���Լ�������ֶβ��ҳ���ƥ��ĸ���
	 */
	public int CheckOrder(String sql) {
		int n = 0;
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				n = rs.getInt("temp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n;
	}
	/*
	 * ��ȡ���Ķ���������ݷŵ���������
	 */
	public int insetorder(OrderDetail orderDetail) {
		int n = 0;
		String sql="insert into orderdetail values(?,?,?,?)";
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setInt(1, orderDetail.getBookid());
			pst.setInt(2, orderDetail.getOrderid());
			pst.setInt(3, orderDetail.getNumber());
			pst.setFloat(4, orderDetail.getTotalprice());
			n  = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n;
	}
	
	/*
	 * ���ؼ۸�
	 */
	public float CheckPrice(String sql) {
		float n = 0;
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				n = rs.getInt("temp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n;
	}
	
	public ArrayList<OrderBean> ListAllOrderInformation(String sql) {
		ArrayList<OrderBean> arrayList = new ArrayList<OrderBean>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				OrderBean book = new OrderBean();
				book.setId(rs.getInt("id"));
				book.setDatatime(rs.getString("datatime"));
				book.setState(rs.getInt("state"));
				book.setTotalprice(rs.getFloat("totalprice"));
				arrayList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	
	/*
	 * ���ҳ�ĳ���˵Ķ�������
	 */
	public ArrayList<OrderInfo> ListOneOrdersInformation(String sql) {
		ArrayList<OrderInfo> arrayList = new ArrayList<OrderInfo>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				OrderInfo orders = new OrderInfo();
				orders.setId(rs.getInt("id"));
				orders.setName(rs.getString("name"));
				orders.setNumber(rs.getInt("number"));
				orders.setPrice(rs.getFloat("price"));
				orders.setSaleprice(rs.getFloat("saleprice"));
				orders.setTotalprice(rs.getFloat("totalprice"));
				arrayList.add(orders);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	
	/*
	 * ���Ҷ����ߵ�����
	 */
	public Orders QueryOrder(int userID) {
		Orders member = new Orders();
		String sql = "select * from orders where id=?";
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userID);
			rs = pst.executeQuery();
			while(rs.next()){
				member.setId(rs.getInt("id"));
				member.setDatatime(rs.getString("datatime"));
				member.setDeliverymode(rs.getInt("deliverymode"));
				member.setMoneymode(rs.getInt("moneymode"));
				member.setSaveAddress(rs.getString("saveAddress"));
				member.setSaveName(rs.getString("saveName"));
				member.setSavePhone(rs.getString("savePhone"));
				member.setState(rs.getInt("state"));
				member.setUserID(rs.getInt("userID"));
				member.setZip(rs.getString("zip"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	
	//��������������ѯ
	public ArrayList<OrderByXL> ListOrderByXL(String sql) {
		ArrayList<OrderByXL> arrayList = new ArrayList<OrderByXL>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				OrderByXL member = new OrderByXL();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("Name"));
				member.setPrice(rs.getFloat("price"));
				member.setSaleprice(rs.getFloat("saleprice"));
				member.setNumber(rs.getInt("number"));
				arrayList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	
	//��������Ʒ���ͳ������������
	public ArrayList<javabean.OrderByCate> ListOrderByCate(String sql) {
		ArrayList<OrderByCate> arrayList = new ArrayList<OrderByCate>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				javabean.OrderByCate member = new OrderByCate();
				member.setId(rs.getInt("id"));
				member.setNumber(rs.getInt("number"));
				member.setTypeName(rs.getString("typeName"));
				arrayList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	
//	��ʱ���ͳ�Ƹ�������ƷС��
	public ArrayList<javabean.OrderByDate> ListOrderByDate(String sql) {
		ArrayList<javabean.OrderByDate> arrayList = new ArrayList<javabean.OrderByDate>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				javabean.OrderByDate member = new javabean.OrderByDate();
				member.setTypeid(rs.getInt("typeid"));
				member.setNumber(rs.getInt("number"));
				arrayList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	
	//���Թ���,��ʾ ���д��˵�����
	public ArrayList<LeaveWord> ListLeaveWord(String sql) {
		ArrayList<LeaveWord> arrayList = new ArrayList<LeaveWord>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				LeaveWord leaveWord = new LeaveWord();
				leaveWord.setId(rs.getInt("id"));
				leaveWord.setAdminid(rs.getInt("adminid"));
				leaveWord.setAnswercontent(rs.getString("answercontent"));
				leaveWord.setAnswerdate(rs.getString("answerdate"));
				leaveWord.setContent(rs.getString("content"));
				leaveWord.setLeavrdate(rs.getString("leavrdate"));
				leaveWord.setMemberid(rs.getInt("memberid"));
				leaveWord.setTitle(rs.getString("title"));
				leaveWord.setState(rs.getInt("state"));
				arrayList.add(leaveWord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	
	//��ʾһ���˵�������Ϣ
	public LeaveWord LeaveWordInfo(int userID) {
		LeaveWord leaveWord = new LeaveWord();
		String sql = "select * from leaveword where id=?";
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userID);
			rs = pst.executeQuery();
			while(rs.next()){
				leaveWord.setAdminid(rs.getInt("adminid"));
				leaveWord.setAnswercontent(rs.getString("answercontent"));
				leaveWord.setAnswerdate(rs.getString("answerdate"));
				leaveWord.setContent(rs.getString("content"));
				leaveWord.setId(rs.getInt("id"));
				leaveWord.setLeavrdate(rs.getString("leavrdate"));
				leaveWord.setMemberid(rs.getInt("memberid"));
				leaveWord.setState(rs.getInt("state"));
				leaveWord.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return leaveWord;
	}
	//ϵͳ�û�����
	public ArrayList<Admin> ListAllAdminInformation(String sql) {
		ArrayList<Admin> arrayList = new ArrayList<Admin>();
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Admin book = new Admin();
				book.setId(rs.getInt("id"));
				book.setAdminName(rs.getString("adminName"));
				book.setAdminpassWord(rs.getString("adminpassWord"));
				book.setAdminType(rs.getInt("adminType"));
				book.setAdminuserName(rs.getString("adminuserName"));
				arrayList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return arrayList;
	}
	
	//����ƥ��Ȩ�ޣ�ͨ���û����õ�����
	public Admin QueryAdmin(String userName) {
		Admin member = new Admin();
		String sql = "select * from admin where adminuserName=?";
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			while(rs.next()){
				member.setId(rs.getInt("id"));
				member.setAdminName(rs.getString("adminName"));
				member.setAdminpassWord(rs.getString("adminpassWord"));
				member.setAdminType(rs.getInt("adminType"));
				member.setAdminuserName(rs.getString("adminuserName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	
	/*
	 * ͨ��ID������ĸ�����Ա�ò鿴��ϸ��Ϣ
	 */
	public Admin QueryAdminByID(int id) {
		Admin member = new Admin();
		String sql = "select * from admin where id=?";
		try {
			conn = DriverManager.getConnection(url, "sa", "sa");
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				member.setId(rs.getInt("id"));
				member.setAdminName(rs.getString("adminName"));
				member.setAdminpassWord(rs.getString("adminpassWord"));
				member.setAdminType(rs.getInt("adminType"));
				member.setAdminuserName(rs.getString("adminuserName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
}
