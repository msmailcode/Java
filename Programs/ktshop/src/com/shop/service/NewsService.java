package com.shop.service;

import com.shop.model.News;
import com.shop.page.PageBean;

public interface NewsService {
	void addnews(News news);
	News getNew(Integer id);
	PageBean query(String fieldname, String value, int pageSize, int page);

}
