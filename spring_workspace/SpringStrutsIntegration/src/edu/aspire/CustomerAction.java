package edu.aspire;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CustomerAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CustomerFormBean custForm = (CustomerFormBean)form;
		System.out.println("Customer First Name:"+custForm.getFirstName());
		System.out.println("Customer Last Name:"+custForm.getLastName());
		System.out.println("Customer Mobile Number:"+custForm.getMobile());
		System.out.println("Customer E-Mail:"+custForm.getEmail());
		
		return mapping.findForward("thankq");
	}

}
