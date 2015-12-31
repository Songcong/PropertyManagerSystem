package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IPublicUtilityManageService;
import Model.PublicUtilityManage;
import Utilx.ViewStringSet;
import ViewModel.PublicUtilityManageViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="publicUtilityManageAssign",results={
		@Result(name="add",location="/PublicUtilityManageaddoredit.jsp"),
		@Result(name="edit",location="/PublicUtilityManageaddoredit.jsp"),
		@Result(name="list",location="/PublicUtilityManagelist.jsp")})
@Controller
public class PublicUtilityManageAssign extends ActionSupport{
	
	private PublicUtilityManageViewModel cvm;
	
	 private String publicUtilityManageId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "publicUtilityManageService")
	private IPublicUtilityManageService publicUtilityManageService;

	private List list;

	public PublicUtilityManageViewModel getCvm() {
		return cvm;
	}

	public void setCvm(PublicUtilityManageViewModel cvm) {
		this.cvm = cvm;
	}

	public String getPublicUtilityManageId() {
		return publicUtilityManageId;
	}

	public void setPublicUtilityManageId(String publicUtilityManageId) {
		this.publicUtilityManageId = publicUtilityManageId;
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
		PublicUtilityManageViewModel publicUtilityManageViewModel=new PublicUtilityManageViewModel();
		
		PublicUtilityManage publicUtilityManage = new PublicUtilityManage();
		
		ViewClass vc=new ViewClass();
		 vc.action="publicUtilityManageAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 publicUtilityManageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(publicUtilityManage);
		
		publicUtilityManageViewModel.setInput(viewStringSet.Addset());
		
		cvm = publicUtilityManageViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		PublicUtilityManageViewModel publicUtilityManageViewModel=new PublicUtilityManageViewModel();
		
		PublicUtilityManage publicUtilityManage = publicUtilityManageService.edit(Integer.parseInt(publicUtilityManageId));
		
		ViewClass vc=new ViewClass();
		 vc.action="publicUtilityManageAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 publicUtilityManageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(publicUtilityManage);
		
		publicUtilityManageViewModel.setInput(viewStringSet.updateset());
		
		cvm = publicUtilityManageViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 PublicUtilityManageViewModel publicUtilityManageViewModel=new PublicUtilityManageViewModel();
		
		 list = publicUtilityManageService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			publicUtilityManageViewModel.setList(viewStringSet.listSet(list));
			publicUtilityManageViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"publicUtilityManageAssign!add\">增加记录</a>");
			
			cvm = publicUtilityManageViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 PublicUtilityManageViewModel publicUtilityManageViewModel=new PublicUtilityManageViewModel();
		 list = publicUtilityManageService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			publicUtilityManageViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = publicUtilityManageViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
