package com.shop.service;

import com.shop.model.Notice;
import com.shop.page.PageBean;

public interface NoticeService {
	void addnotice(Notice notice);
	Notice getNotice(Integer id);
	PageBean query(String fieldname, String value, int pageSize, int page);

}
