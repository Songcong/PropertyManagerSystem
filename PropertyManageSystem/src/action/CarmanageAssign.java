package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.ICarmanageService;
import Model.Carmanage;
import Utilx.ViewStringSet;
import ViewModel.CarmanageViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="carmanageAssign",results={
		@Result(name="add",location="/Carmanageaddoredit.jsp"),
		@Result(name="edit",location="/Carmanageaddoredit.jsp"),
		@Result(name="list",location="/Carmanagelist.jsp")})
@Controller
public class CarmanageAssign extends ActionSupport{
	
	private CarmanageViewModel cvm;
	
	 private String carmanageid;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "carmanageService")
	private ICarmanageService carmanageService;

	private List list;

	public CarmanageViewModel getCvm() {
		return cvm;
	}

	public void setCvm(CarmanageViewModel cvm) {
		this.cvm = cvm;
	}

	public String getCarmanageId() {
		return carmanageid;
	}

	public void setCarmanageId(String carmanageid) {
		this.carmanageid = carmanageid;
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
		CarmanageViewModel carmanageViewModel=new CarmanageViewModel();
		
		Carmanage carmanage = new Carmanage();
		
		ViewClass vc=new ViewClass();
		 vc.action="carmanageAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 carmanageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(carmanage);
		
		carmanageViewModel.setInput(viewStringSet.Addset());
		
		cvm = carmanageViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		CarmanageViewModel carmanageViewModel=new CarmanageViewModel();
		
		Carmanage carmanage = carmanageService.edit(Integer.parseInt(carmanageid));
		
		ViewClass vc=new ViewClass();
		 vc.action="carmanageAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 carmanageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(carmanage);
		
		carmanageViewModel.setInput(viewStringSet.updateset());
		
		cvm = carmanageViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 CarmanageViewModel carmanageViewModel=new CarmanageViewModel();
		
		 list = carmanageService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			carmanageViewModel.setList(viewStringSet.listSet(list));
			carmanageViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"carmanageAssign!add\">增加记录</a>");
			
			cvm = carmanageViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 CarmanageViewModel carmanageViewModel=new CarmanageViewModel();
		 list = carmanageService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			carmanageViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = carmanageViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
