package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IOfforestService;
import Model.Offorest;
import Utilx.ViewStringSet;
import ViewModel.OfforestViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="offorestAssign",results={
		@Result(name="add",location="/Offorestaddoredit.jsp"),
		@Result(name="edit",location="/Offorestaddoredit.jsp"),
		@Result(name="list",location="/Offorestlist.jsp")})
@Controller
public class OfforestAssign extends ActionSupport{
	
	private OfforestViewModel cvm;
	
	 private String offorestId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "offorestService")
	private IOfforestService offorestService;

	private List list;

	public OfforestViewModel getCvm() {
		return cvm;
	}

	public void setCvm(OfforestViewModel cvm) {
		this.cvm = cvm;
	}

	public String getOfforestId() {
		return offorestId;
	}

	public void setOfforestId(String offorestId) {
		this.offorestId = offorestId;
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
		OfforestViewModel offorestViewModel=new OfforestViewModel();
		
		Offorest offorest = new Offorest();
		
		ViewClass vc=new ViewClass();
		 vc.action="offorestAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 offorestViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(offorest);
		
		offorestViewModel.setInput(viewStringSet.Addset());
		
		cvm = offorestViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		OfforestViewModel offorestViewModel=new OfforestViewModel();
		
		Offorest offorest = offorestService.edit(Integer.parseInt(offorestId));
		
		ViewClass vc=new ViewClass();
		 vc.action="offorestAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 offorestViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(offorest);
		
		offorestViewModel.setInput(viewStringSet.updateset());
		
		cvm = offorestViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 OfforestViewModel offorestViewModel=new OfforestViewModel();
		
		 list = offorestService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			offorestViewModel.setList(viewStringSet.listSet(list));
			offorestViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"offorestAssign!add\">增加记录</a>");
			
			cvm = offorestViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 OfforestViewModel offorestViewModel=new OfforestViewModel();
		 list = offorestService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			offorestViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = offorestViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
