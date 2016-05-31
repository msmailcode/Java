package com.shop.service;

import com.shop.model.Ad;
import com.shop.page.PageBean;

public interface AdService {
	void addAd(Ad ad);
	Ad getAd(Integer id);
	PageBean query(String fieldname, String value, int pageSize, int page);
	void modifyAd(Ad ad);
	void delteteAd(Integer id);

}
