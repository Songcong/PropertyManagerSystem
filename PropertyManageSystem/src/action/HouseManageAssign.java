package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IHouseManageService;
import Model.HouseManage;
import Utilx.ViewStringSet;
import ViewModel.HouseManageViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="houseManageAssign",results={
		@Result(name="add",location="/HouseManageaddoredit.jsp"),
		@Result(name="edit",location="/HouseManageaddoredit.jsp"),
		@Result(name="list",location="/HouseManagelist.jsp")})
@Controller
public class HouseManageAssign extends ActionSupport{
	
	private HouseManageViewModel cvm;
	
	 private String houseManageId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "houseManageService")
	private IHouseManageService houseManageService;

	private List list;

	public HouseManageViewModel getCvm() {
		return cvm;
	}

	public void setCvm(HouseManageViewModel cvm) {
		this.cvm = cvm;
	}

	public String getHouseManageId() {
		return houseManageId;
	}

	public void setHouseManageId(String houseManageId) {
		this.houseManageId = houseManageId;
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
		HouseManageViewModel houseManageViewModel=new HouseManageViewModel();
		
		HouseManage houseManage = new HouseManage();
		
		ViewClass vc=new ViewClass();
		 vc.action="houseManageAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 houseManageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(houseManage);
		
		houseManageViewModel.setInput(viewStringSet.Addset());
		
		cvm = houseManageViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		HouseManageViewModel houseManageViewModel=new HouseManageViewModel();
		
		HouseManage houseManage = houseManageService.edit(Integer.parseInt(houseManageId));
		
		ViewClass vc=new ViewClass();
		 vc.action="houseManageAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 houseManageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(houseManage);
		
		houseManageViewModel.setInput(viewStringSet.updateset());
		
		cvm = houseManageViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 HouseManageViewModel houseManageViewModel=new HouseManageViewModel();
		
		 list = houseManageService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			houseManageViewModel.setList(viewStringSet.listSet(list));
			houseManageViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"houseManageAssign!add\">增加记录</a>");
			
			cvm = houseManageViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 HouseManageViewModel houseManageViewModel=new HouseManageViewModel();
		 list = houseManageService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			houseManageViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = houseManageViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
