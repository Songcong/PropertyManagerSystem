package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IJobtypeService;
import Model.Jobtype;
import Utilx.ViewStringSet;
import ViewModel.JobtypeViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="jobtypeAssign",results={
		@Result(name="add",location="/Jobtypeaddoredit.jsp"),
		@Result(name="edit",location="/Jobtypeaddoredit.jsp"),
		@Result(name="list",location="/Jobtypelist.jsp")})
@Controller
public class JobtypeAssign extends ActionSupport{
	
	private JobtypeViewModel cvm;
	
	 private String jobtypeId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "jobtypeService")
	private IJobtypeService jobtypeService;

	private List list;

	public JobtypeViewModel getCvm() {
		return cvm;
	}

	public void setCvm(JobtypeViewModel cvm) {
		this.cvm = cvm;
	}

	public String getJobtypeId() {
		return jobtypeId;
	}

	public void setJobtypeId(String jobtypeId) {
		this.jobtypeId = jobtypeId;
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
		JobtypeViewModel jobtypeViewModel=new JobtypeViewModel();
		
		Jobtype jobtype = new Jobtype();
		
		ViewClass vc=new ViewClass();
		 vc.action="jobtypeAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 jobtypeViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(jobtype);
		
		jobtypeViewModel.setInput(viewStringSet.Addset());
		
		cvm = jobtypeViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		JobtypeViewModel jobtypeViewModel=new JobtypeViewModel();
		
		Jobtype jobtype = jobtypeService.edit(Integer.parseInt(jobtypeId));
		
		ViewClass vc=new ViewClass();
		 vc.action="jobtypeAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 jobtypeViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(jobtype);
		
		jobtypeViewModel.setInput(viewStringSet.updateset());
		
		cvm = jobtypeViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 JobtypeViewModel jobtypeViewModel=new JobtypeViewModel();
		
		 list = jobtypeService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			jobtypeViewModel.setList(viewStringSet.listSet(list));
			jobtypeViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"jobtypeAssign!add\">增加记录</a>");
			
			cvm = jobtypeViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 JobtypeViewModel jobtypeViewModel=new JobtypeViewModel();
		 list = jobtypeService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			jobtypeViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = jobtypeViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
