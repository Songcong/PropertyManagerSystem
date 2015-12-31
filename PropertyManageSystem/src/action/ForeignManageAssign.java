package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IForeignManageService;
import Model.ForeignManage;
import Utilx.ViewStringSet;
import ViewModel.ForeignManageViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="foreignManageAssign",results={
		@Result(name="add",location="/ForeignManageaddoredit.jsp"),
		@Result(name="edit",location="/ForeignManageaddoredit.jsp"),
		@Result(name="list",location="/ForeignManagelist.jsp")})
@Controller
public class ForeignManageAssign extends ActionSupport{
	
	private ForeignManageViewModel cvm;
	
	 private String foreignManageId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "foreignManageService")
	private IForeignManageService foreignManageService;

	private List list;

	public ForeignManageViewModel getCvm() {
		return cvm;
	}

	public void setCvm(ForeignManageViewModel cvm) {
		this.cvm = cvm;
	}

	public String getForeignManageId() {
		return foreignManageId;
	}

	public void setForeignManageId(String foreignManageId) {
		this.foreignManageId = foreignManageId;
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
		ForeignManageViewModel foreignManageViewModel=new ForeignManageViewModel();
		
		ForeignManage foreignManage = new ForeignManage();
		
		ViewClass vc=new ViewClass();
		 vc.action="foreignManageAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 foreignManageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(foreignManage);
		
		foreignManageViewModel.setInput(viewStringSet.Addset());
		
		cvm = foreignManageViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		ForeignManageViewModel foreignManageViewModel=new ForeignManageViewModel();
		
		ForeignManage foreignManage = foreignManageService.edit(Integer.parseInt(foreignManageId));
		
		ViewClass vc=new ViewClass();
		 vc.action="foreignManageAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 foreignManageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(foreignManage);
		
		foreignManageViewModel.setInput(viewStringSet.updateset());
		
		cvm = foreignManageViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 ForeignManageViewModel foreignManageViewModel=new ForeignManageViewModel();
		
		 list = foreignManageService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			foreignManageViewModel.setList(viewStringSet.listSet(list));
			foreignManageViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"foreignManageAssign!add\">增加记录</a>");
			
			cvm = foreignManageViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 ForeignManageViewModel foreignManageViewModel=new ForeignManageViewModel();
		 list = foreignManageService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			foreignManageViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = foreignManageViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
