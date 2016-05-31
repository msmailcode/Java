
Function FGetDay(dt,w)
   basew=weekday(dt)
   if w=basew then
      FGetDay=dt
      exit function
   else
      FGetDay=dt+w-baseW
   end if
end function


Function GetDate(d,t)
   m=cint(month(d))
   if m<=3 then
     if t=0 then GetDate=cdate(year(d) & "-1-1") else GetDate=Cdate(year(d) & "-3-31")
   elseif m<=6 then
     if t=0 then GetDate=cdate(year(d) & "-4-1") else GetDate=Cdate(year(d) & "-6-30")
   elseif m<=9 then
     if t=0 then GetDate=cdate(year(d) & "-7-1") else GetDate=cdate(year(d) & "-9-30")
   else
     if t=0 then GetDate=cdate(year(d) & "-10-1") else GetDate=cdate(year(d) & "-12-31")
   end if
end function

Function GetMonth(d)
   m=cint(month(d))
   y=cint(year(d))
   select case m
      case 1,3,5,7,8,10,12 GetMonth=year(date())&"-"&month(date())&"-31"
	  case 2
	     if ((y mod 4=0 )and (y mod 100<>0)) or(y mod 400=0) then GetMonth=year(date())&"-"&month(date())&"-29" else GetMonth=year(date())&"-"&month(date())&"-28"
	  case 4,6,9,11 GetMonth=year(date())&"-"&month(date())&"-30"
	end select
end function

Sub SetDate(d)
   if d="本日" then
     document.all("s_date").value=date()
     document.all("e_date").value=date()
  
   end if
   if d="本周" then
     document.all("s_date").value=FGetDay(date(),2)
     document.all("e_date").value=FGetDay(date(),8)
     
   end if
   if d="本月" then
     document.all("s_date").value=year(date())&"-"&month(date())&"-1"
     document.all("e_date").value=GetMonth(date())
   
   end if
   if d="本季" then
     document.all("s_date").value=getdate(date(),0)
     document.all("e_date").value=getdate(date(),1)
     
   end if
   if d="本年" then
     document.all("s_date").value=cdate(year(date())&"-1-1")
     document.all("e_date").value=cdate(year(date())&"-12-31")
     
   end if
end sub

