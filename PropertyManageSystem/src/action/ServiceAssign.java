package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IServiceService;
import Model.Service;
import Utilx.ViewStringSet;
import ViewModel.ServiceViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="serviceAssign",results={
		@Result(name="add",location="/Serviceaddoredit.jsp"),
		@Result(name="edit",location="/Serviceaddoredit.jsp"),
		@Result(name="list",location="/Servicelist.jsp")})
@Controller
public class ServiceAssign extends ActionSupport{
	
	private ServiceViewModel cvm;
	
	 private String serviceId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "serviceService")
	private IServiceService serviceService;

	private List list;

	public ServiceViewModel getCvm() {
		return cvm;
	}

	public void setCvm(ServiceViewModel cvm) {
		this.cvm = cvm;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	
	
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	public String add(){
		ServiceViewModel serviceViewModel=new ServiceViewModel();
		
		Service service = new Service();
		
		ViewClass vc=new ViewClass();
		 vc.action="serviceAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 serviceViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(service);
		
		serviceViewModel.setInput(viewStringSet.Addset());
		
		cvm = serviceViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		ServiceViewModel serviceViewModel=new ServiceViewModel();
		
		Service service = serviceService.edit(Integer.parseInt(serviceId));
		
		ViewClass vc=new ViewClass();
		 vc.action="serviceAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 serviceViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(service);
		
		serviceViewModel.setInput(viewStringSet.updateset());
		
		cvm = serviceViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 ServiceViewModel serviceViewModel=new ServiceViewModel();
		
		 list = serviceService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			serviceViewModel.setList(viewStringSet.listSet(list));
			serviceViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"serviceAssign!add\">增加记录</a>");
			
			cvm = serviceViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 ServiceViewModel serviceViewModel=new ServiceViewModel();
		 list = serviceService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			serviceViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = serviceViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
