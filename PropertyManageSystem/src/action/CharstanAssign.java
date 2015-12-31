package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.ICharstanService;
import Model.Charstan;
import Utilx.ViewStringSet;
import ViewModel.CharstanViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="charstanAssign",results={
		@Result(name="add",location="/Charstanaddoredit.jsp"),
		@Result(name="edit",location="/Charstanaddoredit.jsp"),
		@Result(name="list",location="/Charstanlist.jsp")})
@Controller
public class CharstanAssign extends ActionSupport{
	
	private CharstanViewModel cvm;
	
	 private String charstanId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "charstanService")
	private ICharstanService charstanService;

	private List list;

	public CharstanViewModel getCvm() {
		return cvm;
	}

	public void setCvm(CharstanViewModel cvm) {
		this.cvm = cvm;
	}

	public String getCharstanId() {
		return charstanId;
	}

	public void setCharstanId(String charstanId) {
		this.charstanId = charstanId;
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
		CharstanViewModel charstanViewModel=new CharstanViewModel();
		
		Charstan charstan = new Charstan();
		
		ViewClass vc=new ViewClass();
		 vc.action="charstanAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 charstanViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(charstan);
		
		charstanViewModel.setInput(viewStringSet.Addset());
		
		cvm = charstanViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		CharstanViewModel charstanViewModel=new CharstanViewModel();
		
		Charstan charstan = charstanService.edit(Integer.parseInt(charstanId));
		
		ViewClass vc=new ViewClass();
		 vc.action="charstanAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 charstanViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(charstan);
		
		charstanViewModel.setInput(viewStringSet.updateset());
		
		cvm = charstanViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 CharstanViewModel charstanViewModel=new CharstanViewModel();
		
		 list = charstanService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			charstanViewModel.setList(viewStringSet.listSet(list));
			charstanViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"charstanAssign!add\">增加记录</a>");
			
			cvm = charstanViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 CharstanViewModel charstanViewModel=new CharstanViewModel();
		 list = charstanService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			charstanViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = charstanViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
