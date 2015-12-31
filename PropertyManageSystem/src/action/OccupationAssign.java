package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IOccupationService;
import Model.Occupation;
import Utilx.ViewStringSet;
import ViewModel.OccupationViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="occupationAssign",results={
		@Result(name="add",location="/Occupationaddoredit.jsp"),
		@Result(name="edit",location="/Occupationaddoredit.jsp"),
		@Result(name="list",location="/Occupationlist.jsp")})
@Controller
public class OccupationAssign extends ActionSupport{
	
	private OccupationViewModel cvm;
	
	 private String occupationId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "occupationService")
	private IOccupationService occupationService;

	private List list;

	public OccupationViewModel getCvm() {
		return cvm;
	}

	public void setCvm(OccupationViewModel cvm) {
		this.cvm = cvm;
	}

	public String getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(String occupationId) {
		this.occupationId = occupationId;
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
		OccupationViewModel occupationViewModel=new OccupationViewModel();
		
		Occupation occupation = new Occupation();
		
		ViewClass vc=new ViewClass();
		 vc.action="occupationAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 occupationViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(occupation);
		
		occupationViewModel.setInput(viewStringSet.Addset());
		
		cvm = occupationViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		OccupationViewModel occupationViewModel=new OccupationViewModel();
		
		Occupation occupation = occupationService.edit(Integer.parseInt(occupationId));
		
		ViewClass vc=new ViewClass();
		 vc.action="occupationAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 occupationViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(occupation);
		
		occupationViewModel.setInput(viewStringSet.updateset());
		
		cvm = occupationViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 OccupationViewModel occupationViewModel=new OccupationViewModel();
		
		 list = occupationService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			occupationViewModel.setList(viewStringSet.listSet(list));
			occupationViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"occupationAssign!add\">增加记录</a>");
			
			cvm = occupationViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 OccupationViewModel occupationViewModel=new OccupationViewModel();
		 list = occupationService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			occupationViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = occupationViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
