package com.bodytags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class BodyTag extends SimpleTagSupport {
   StringWriter sw = new StringWriter();
   public void doTag()
   
   throws JspException, IOException {
      getJspBody().invoke(sw);
      getJspContext().getOut().println(sw.toString());
   }
}