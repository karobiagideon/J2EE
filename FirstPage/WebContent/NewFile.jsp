<%@ page import = "java.io.*,java.util.*" %>
<%
  HttpSession sessions=request.getSession(true);
   // Get session creation time.
   Date createTime = new Date(sessions.getCreationTime());
   
   // Get last access time of this Webpage.
   Date lastAccessTime = new Date(sessions.getLastAccessedTime());

   String title = "Welcome Back to my website";
   Integer visitCount = new Integer(0);
   String visitCountKey = new String("visitCount");
   String userIDKey = new String("userID");
   String userID = new String("ABCD");

   // Check if this is new comer on your Webpage.
   if (sessions.isNew() ){
      title = "Welcome to my website";
      sessions.setAttribute(userIDKey, userID);
      sessions.setAttribute(visitCountKey,  visitCount);
   } 
   visitCount = (Integer)sessions.getAttribute(visitCountKey);
   visitCount = visitCount + 1;
   userID = (String)sessions.getAttribute(userIDKey);
   session.setAttribute(visitCountKey,  visitCount);
%>

<html>
   <head>
      <title>Session Tracking</title>
   </head>
   
   <body>
      <center>
         <h1>Session Tracking</h1>
      </center>
      
      <table border = "1" align = "center"> 
         <tr bgcolor = "#949494">
            <th>Session info</th>
            <th>Value</th>
         </tr> 
         <tr>
            <td>id</td>
            <td><% out.print( sessions.getId()); %></td>
         </tr> 
         <tr>
            <td>Creation Time</td>
            <td><% out.print(createTime); %></td>
         </tr> 
         <tr>
            <td>Time of Last Access</td>
            <td><% out.print(lastAccessTime); %></td>
         </tr> 
         <tr>
            <td>User ID</td>
            <td><% out.print(userID); %></td>
         </tr> 
         <tr>
            <td>Number of visits</td>
            <td><% out.print(visitCount); %></td>
         </tr> 
      </table> 
   
   </body>
</html>