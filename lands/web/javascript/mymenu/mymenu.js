;
(function($){
	$.extend($.fn, {
		mymenu: function(settings){
			settings = $.extend({
	            collapsed: false,
				speed: "fast",
				markCurrent: true,
				oneMenuOnly : false
	        }, settings);
			
			menus = $(this).children("div");
			links = $(menus).find("a");
	
			if(settings.oneMenuOnly){
				settings.collapsed = true;
			}
			if(settings.collapsed){
				menus.attr("class", "collapsed");
			}else if(settings.expanded){
				menus.removeClass();
			}
			if (settings.target) {
				links.each(function(i){
					if (!$(this).attr("target")) {
						$(this).attr("target", settings.target);
					}
				});
			}
			
			menus.each(function(i){
				$(this).children("span").click(function(e){
					toggleMenus(menus, i, settings);
					e.stopPropagation();
				});
			});
			$(links).click(function(){
				$(links).removeClass();
				$(this).addClass("current");
			});
		}
	});
	
	function toggleMenus(menus, idx, settings){
		menus.children("div").stop(true, true);
		
		var menu = menus.eq(idx);
		menu.children("div").slideToggle(settings.speed, function(){
		//	menu.toggleClass("collapsed");
		});
		menu.toggleClass("collapsed");
		
		if (settings.oneMenuOnly) {
			for (var k = 0; k < menus.length; k++) {
				menu = menus.eq(k);
				if (k != idx && !menu.hasClass("collapsed")) {
					menu.children("div").slideUp(settings.speed, function(){
					//	menu.attr("class", "collapsed");
					});
					menu.attr("class", "collapsed");
				}
			}
		}
	}
	
	// provide backwards compability
	$.fn.MyMenu = $.fn.mymenu;
})(jQuery);
