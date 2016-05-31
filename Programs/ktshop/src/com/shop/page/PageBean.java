package com.shop.page;

import java.util.List;

import com.shop.model.Ad;
import com.shop.model.News;
import com.shop.model.Notice;
import com.shop.model.Order;
import com.shop.model.Products;
import com.shop.model.Smalltype;
import com.shop.model.User;

public class PageBean {
	private int totalRows; 
	private static int pageSize=10;
	private Integer totalPages;
	private Integer currentPage;
	private static Integer startRow;
	private List<User> list;
	private List<Products> list2;
	private List<Smalltype> list3;
	private List<News> list4;
	private List<Products> list5;
	private List<Order> list6;
	private List<Products> list7;
	private List<Products> list8;
	private List<Products> list9;
	private List<Notice> list10;
	private List<Ad> list11;

	private static int m=0;

	@SuppressWarnings("unused")
	private boolean isFirstPage;

	@SuppressWarnings("unused")
	private boolean isLastPage;

	@SuppressWarnings("unused")
	private boolean hasPreviousPage;

	@SuppressWarnings("unused")
	private boolean hasNextPage;
	
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public void setPageSize(Integer pageSize) {
		PageBean.pageSize = pageSize;
	}
	public static Integer getPageSize() {
		return pageSize;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setStartRow(Integer startRow) {
		PageBean.startRow= startRow;
	}
	public static Integer getStartRow() {
		return startRow;
	}
	public static int countTotalPages(final int pageSize,final int totalRows){
        int totalPages = totalRows % pageSize == 0 ? totalRows/pageSize : totalRows/pageSize+1;
        return totalPages;
    }

	public static int startRowSet(final int pageSize,final int currentPage){
        final int startRow = (currentPage-1)*pageSize;
        return startRow;
    }
	 public static int countCurrentPage(int page){
	        final int currentPage = (page==0?1:page);
	        return currentPage;
	    }

		public void setList(List<User> list) {
			this.list = list;
		}

		public List<User> getList() {
			return list;
		}

		 public boolean isFirstPage() {
		        return currentPage == 1;            // 如是当前页是第1页
		    }
		    public boolean isLastPage() {
		        return currentPage == totalPages;    //如果当前页是最后一页
		    }
		    public boolean isHasPreviousPage() {
		        return currentPage != 1;            //只要当前页不是第1页
		    }
		    public boolean isHasNextPage() {
		        return currentPage != totalPages;    //只要当前页不是最后1页
		    }
		    
		    /**
		     * 初始化分页信息
		     */
		    public void init()
		    {
		        this.setFirstPage(isFirstPage());
		        this.setLastPage(isLastPage());
		        this.setHasPreviousPage(isHasPreviousPage());
		        this.setHasNextPage(isHasNextPage());
		    }
		public void setList2(List<Products> list2) {
			this.list2 = list2;
		}
		public List<Products> getList2() {
			return list2;
		}
		public List<Smalltype> getList3() {
			return list3;
		}
		public void setList3(List<Smalltype> list3) {
			this.list3 = list3;
		}
		public void setList4(List<News> list4) {
			this.list4 = list4;
		}
		public List<News> getList4() {
			return list4;
		}
		public void setFirstPage(boolean isFirstPage) {
			this.isFirstPage = isFirstPage;
		}
	
		public void setLastPage(boolean isLastPage) {
			this.isLastPage = isLastPage;
		}
		public void setHasPreviousPage(boolean hasPreviousPage) {
			this.hasPreviousPage = hasPreviousPage;
		}
		public void setHasNextPage(boolean hasNextPage) {
			this.hasNextPage = hasNextPage;
		}
		public List<Products> getList5() {
			return list5;
		}
		public void setList5(List<Products> list5) {
			this.list5 = list5;
		}
		public List<Order> getList6() {
			return list6;
		}
		public void setList6(List<Order> list6) {
			this.list6 = list6;
		}
		public static int getM() {
			return m;
		}
		public static void setM(int m) {
			PageBean.m = m;
		}
		public List<Products> getList7() {
			return list7;
		}
		
		public void setList7(List<Products> list7) {
			this.list7 = list7;
		}
		
		public List<Products> getList8() {
			return list8;
		}
		public void setList8(List<Products> list8) {
			this.list8 = list8;
			
		}
			public List<Products> getList9() {
			return list9;
		}
		public void setList9(List<Products> list9) {
			this.list9 = list9;
			
		}
		
		public List<Notice> getList10() {
			return list10;
		}
		public void setList10(List<Notice> list10) {
			this.list10 = list10;			
		}
		
		public List<Ad> getList11() {
			return list11;
		}
		public void setList11(List<Ad> list11) {
			this.list11 = list11;			
		}


}
