<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML><HEAD><TITLE>Dynamic Form</TITLE></HEAD>
<BODY>
<B>Form</B>
<FORM ACTION=pedidoDinamico.jsp METHOD=POST>

<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0>
<%  String[] textFields = {"FirstName","LastName","Address","City","Zip"};
    for(int j=0; j<textFields.length; j++){     %>
    <TR>    <TD> <%=textFields[j]%>:                       </TD>
            <TD> <INPUT TYPE=TEXT NAME=<%=textFields[j]%>> </TD>
   </TR>
<%  }   %>
    <TR>    <TD> State  </TD>
            <TD> <SELECT NAME=State>
<%  String[] states = {"AZ", "CA", "NM", "MA", "ME", "MD", "..."};
    for(int s=0; s<states.length; s++) {    %>
                    <OPTION><%=states[s]%></OPTION>
<%  }   %>
                 </SELECT></TD>
    </TR>
    <TR>    <TD> Card Number  </TD>
            <TD> <INPUT TYPE=TEXT NAME=cNumber></TD>
    </TR>
    <TR>    <TD> Card Type  </TD>
            <TD> <SELECT NAME=CardType>
<%  String[] cTypes = {"Amex", "Visa", "Master Card", "Discovery", "..."};
    for(int t=0; t<cTypes.length; t++) {    %>
                    <OPTION><%=cTypes[t]%></OPTION>
<%  }   %>
                 </SELECT></TD>
    </TR>
    <TR>    <TD> Expiration Date (MM/DD/YYYY) </TD>
<TD> <INPUT TYPE=TEXT NAME=cMonth SIZE=2><INPUT TYPE=TEXT NAME=cDay SIZE=2>
            <SELECT NAME=cYear>
            <%  int startYear = 2000;
                int endYear = 2010;
                for(int y=startYear; y<endYear; y++) {    %>
                    <OPTION><%=y%></OPTION>
            <%  }   %>
            </SELECT></TD>
    </TR>
</TABLE>
    <INPUT TYPE=SUBMIT VALUE=Submit>
</FORM>
<HR>
<B>Form Content</B><BR>
<TABLE>
<%  Enumeration parameters = request.getParameterNames();
    while(parameters.hasMoreElements()){
        String parameterName = (String)parameters.nextElement();
        String parameterValue = request.getParameter(parameterName); %>
        <TR>
            <TD><%=parameterName%></TD>
            <TD><%=parameterValue%></TD>
        </TR>
<%  }   %>
</BODY></HTML>
