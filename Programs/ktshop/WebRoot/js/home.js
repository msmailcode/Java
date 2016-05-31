jQuery(function(){
	jQuery("#playNum_1 li").mouseover(function(){
		n_1 = jQuery(this).attr("data-num");
		show(n_1);
	});
	tt_1 = setInterval("showAuto_1()", 2000);//控制自动播放时间
	jQuery("#rotateAdv_1").hover(function(){
		clearInterval(tt_1);
		jQuery("#scroller-prev").animate({left: 0}, {queue: false,duration:200}).unbind().click(function(){//控制左边按钮滑入时间
				n_1 = n_1 < 2 ? count_1 : --n_1;
				show(n_1);
			  }).bind("mouseover",function(){jQuery(this).addClass("prev-on");})
				.bind("mouseout",function(){jQuery(this).removeClass("prev-on");});
		jQuery("#scroller-next").animate({right: 0}, {queue: false,duration:200}).unbind().click(function(){//控制右边按钮滑出时间
				n_1 = n_1 > (count_1 - 1) ? 1 : ++n_1;
				show(n_1);
			  }).bind("mouseover",function(){jQuery(this).addClass("next-on");})
				.bind("mouseout",function(){jQuery(this).removeClass("next-on");});
	}, function(){

			jQuery("#scroller-prev").animate({left: -50}, {queue: false,duration:200});//控制右边按钮滑出时间
			jQuery("#scroller-next").animate({right: -50}, {queue: false,duration:200});//控制左边按钮滑出时间
		});
})
function showAuto_1(){
	n_1 = n_1 > (count_1 - 1) ? 1 : ++n_1;
	show(n_1);
}
function show(n_1){
	jQuery("#playShow_1 li").eq(n_1-1).siblings().hide();
	jQuery("#playNum_1").find("span").html("");
	jQuery("#playNum_1 li").eq(n_1-1).addClass("curr").siblings().removeClass("curr");
   	var title = jQuery("#playShow_1 li").eq(n_1-1).find("img").attr('alt');
   	jQuery("#playShow_1 li").eq(n_1-1).fadeIn(300).children("a").attr("title",title);
   	jQuery("#playNum_1 .curr").find("span").html(title).show();
}