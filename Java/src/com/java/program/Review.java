package com.java.program;

import java.util.List;

public class Review {
	public static class RateDetail{
		public Paginator paginator;
		public RateCount rateCount;
		public RateDanceInfo rateDanceInfo;
		public List<RateList> rateList;
		public String searchinfo;
		public String tags;
	}
	
	public static class Paginator{
		public int items;
		public int lastPage;
		public int page;
	}
	
	public static class RateCount{
		public int picNum;
		public int shop;
		public int total;
		public int used;
	}
	
	public static class RateDanceInfo{
		public int currentMiles;
		public int intervalMiles;
		public boolean showChooseTopic;
		public int storeType;
	}
	
	public static class RateList{
		public boolean aliMallSeller;
		public boolean anony;
        public Object appendComment;
        public String attributes;
        public AttributesMap attributesMap;        
        public String aucNumId;
        public String auctionPicUrl;
        public String auctionPrice;
        public String auctionSku;
        public String auctionTitle;
        public String buyCount;
        public String carServiceLocation;
        public String cmsSource;
        public String displayRatePic;
        public String displayRateSum;
        public String displayUserLink;
        public String displayUserNick;
        public String displayUserNumId;
        public String displayUserRateLink;
        public String dsr;
        public String fromMall;
        public String fromMemory;
        public String gmtCreateTime;
        public String id;
        public List<String> pics;
        public String picsSmall;
        public String position;
        public String rateContent;
        public String rateDate;
        public String reply;
        public String sellerId;
        public String serviceRateContent;
        public List<String> structuredRateList;
        public String tamllSweetLevel;
        public String tmallSweetPic;
        public String tradeEndTime;
        public String tradeId;
        public String useful;
        public String userIdEncryption;
        public String userInfo;
        public String userVipLevel;
        public String userVipPic;
	}
	
	public static class AttributesMap{
		public String pic_height;
		public String leafCatId;
		public String explainTime;
		public String pic_width;
		public String service_128_0;
		public String tmall_vip_level;
		public String spuId;
		public String importFrom;
		public String enableTime;
		public String worth_order_score;
		public String worth_score;
	}        

	public RateDetail rateDetail;
	
}
