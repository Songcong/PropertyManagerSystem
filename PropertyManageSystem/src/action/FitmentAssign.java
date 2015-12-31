package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IFitmentService;
import Model.Fitment;
import Utilx.ViewStringSet;
import ViewModel.FitmentViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="fitmentAssign",results={
		@Result(name="add",location="/Fitmentaddoredit.jsp"),
		@Result(name="edit",location="/Fitmentaddoredit.jsp"),
		@Result(name="list",location="/Fitmentlist.jsp")})
@Controller
public class FitmentAssign extends ActionSupport{
	
	private FitmentViewModel cvm;
	
	 private String fitmentId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "fitmentService")
	private IFitmentService fitmentService;

	private List list;

	public FitmentViewModel getCvm() {
		return cvm;
	}

	public void setCvm(FitmentViewModel cvm) {
		this.cvm = cvm;
	}

	public String getFitmentId() {
		return fitmentId;
	}

	public void setFitmentId(String fitmentId) {
		this.fitmentId = fitmentId;
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
		FitmentViewModel fitmentViewModel=new FitmentViewModel();
		
		Fitment fitment = new Fitment();
		
		ViewClass vc=new ViewClass();
		 vc.action="fitmentAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 fitmentViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(fitment);
		
		fitmentViewModel.setInput(viewStringSet.Addset());
		
		cvm = fitmentViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		FitmentViewModel fitmentViewModel=new FitmentViewModel();
		
		Fitment fitment = fitmentService.edit(Integer.parseInt(fitmentId));
		
		ViewClass vc=new ViewClass();
		 vc.action="fitmentAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 fitmentViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(fitment);
		
		fitmentViewModel.setInput(viewStringSet.updateset());
		
		cvm = fitmentViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 FitmentViewModel fitmentViewModel=new FitmentViewModel();
		
		 list = fitmentService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			fitmentViewModel.setList(viewStringSet.listSet(list));
			fitmentViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"fitmentAssign!add\">增加记录</a>");
			
			cvm = fitmentViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 FitmentViewModel fitmentViewModel=new FitmentViewModel();
		 list = fitmentService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			fitmentViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = fitmentViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
