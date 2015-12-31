package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IStallService;
import Model.Stall;
import Utilx.ViewStringSet;
import ViewModel.StallViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="stallAssign",results={
		@Result(name="add",location="/Stalladdoredit.jsp"),
		@Result(name="edit",location="/Stalladdoredit.jsp"),
		@Result(name="list",location="/Stalllist.jsp")})
@Controller
public class StallAssign extends ActionSupport{
	
	private StallViewModel cvm;
	
	 private String stallId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "stallService")
	private IStallService stallService;

	private List list;

	public StallViewModel getCvm() {
		return cvm;
	}

	public void setCvm(StallViewModel cvm) {
		this.cvm = cvm;
	}

	public String getStallId() {
		return stallId;
	}

	public void setStallId(String stallId) {
		this.stallId = stallId;
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
		StallViewModel stallViewModel=new StallViewModel();
		
		Stall stall = new Stall();
		
		ViewClass vc=new ViewClass();
		 vc.action="stallAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 stallViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(stall);
		
		stallViewModel.setInput(viewStringSet.Addset());
		
		cvm = stallViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		StallViewModel stallViewModel=new StallViewModel();
		
		Stall stall = stallService.edit(Integer.parseInt(stallId));
		
		ViewClass vc=new ViewClass();
		 vc.action="stallAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 stallViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(stall);
		
		stallViewModel.setInput(viewStringSet.updateset());
		
		cvm = stallViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 StallViewModel stallViewModel=new StallViewModel();
		
		 list = stallService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			stallViewModel.setList(viewStringSet.listSet(list));
			stallViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"stallAssign!add\">增加记录</a>");
			
			cvm = stallViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 StallViewModel stallViewModel=new StallViewModel();
		 list = stallService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			stallViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = stallViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
