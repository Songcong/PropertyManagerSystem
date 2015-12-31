package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IUtilityDamageService;
import Model.UtilityDamage;
import Utilx.ViewStringSet;
import ViewModel.UtilityDamageViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="utilityDamageAssign",results={
		@Result(name="add",location="/UtilityDamageaddoredit.jsp"),
		@Result(name="edit",location="/UtilityDamageaddoredit.jsp"),
		@Result(name="list",location="/UtilityDamagelist.jsp")})
@Controller
public class UtilityDamageAssign extends ActionSupport{
	
	private UtilityDamageViewModel cvm;
	
	 private String utilityDamageId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "utilityDamageService")
	private IUtilityDamageService utilityDamageService;

	private List list;

	public UtilityDamageViewModel getCvm() {
		return cvm;
	}

	public void setCvm(UtilityDamageViewModel cvm) {
		this.cvm = cvm;
	}

	public String getUtilityDamageId() {
		return utilityDamageId;
	}

	public void setUtilityDamageId(String utilityDamageId) {
		this.utilityDamageId = utilityDamageId;
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
		UtilityDamageViewModel utilityDamageViewModel=new UtilityDamageViewModel();
		
		UtilityDamage utilityDamage = new UtilityDamage();
		
		ViewClass vc=new ViewClass();
		 vc.action="utilityDamageAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 utilityDamageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(utilityDamage);
		
		utilityDamageViewModel.setInput(viewStringSet.Addset());
		
		cvm = utilityDamageViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		UtilityDamageViewModel utilityDamageViewModel=new UtilityDamageViewModel();
		
		UtilityDamage utilityDamage = utilityDamageService.edit(Integer.parseInt(utilityDamageId));
		
		ViewClass vc=new ViewClass();
		 vc.action="utilityDamageAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 utilityDamageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(utilityDamage);
		
		utilityDamageViewModel.setInput(viewStringSet.updateset());
		
		cvm = utilityDamageViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 UtilityDamageViewModel utilityDamageViewModel=new UtilityDamageViewModel();
		
		 list = utilityDamageService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			utilityDamageViewModel.setList(viewStringSet.listSet(list));
			utilityDamageViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"utilityDamageAssign!add\">增加记录</a>");
			
			cvm = utilityDamageViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 UtilityDamageViewModel utilityDamageViewModel=new UtilityDamageViewModel();
		 list = utilityDamageService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			utilityDamageViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = utilityDamageViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
