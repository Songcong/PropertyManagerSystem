package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IChartService;
import Model.Chart;
import Utilx.ViewStringSet;
import ViewModel.ChartViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="chartAssign",results={
		@Result(name="add",location="/Chartaddoredit.jsp"),
		@Result(name="edit",location="/Chartaddoredit.jsp"),
		@Result(name="list",location="/Chartlist.jsp")})
@Controller
public class ChartAssign extends ActionSupport{
	
	private ChartViewModel cvm;
	
	 private String chartId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "chartService")
	private IChartService chartService;

	private List list;

	public ChartViewModel getCvm() {
		return cvm;
	}

	public void setCvm(ChartViewModel cvm) {
		this.cvm = cvm;
	}

	public String getChartId() {
		return chartId;
	}

	public void setChartId(String chartId) {
		this.chartId = chartId;
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
		ChartViewModel chartViewModel=new ChartViewModel();
		
		Chart chart = new Chart();
		
		ViewClass vc=new ViewClass();
		 vc.action="chartAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 chartViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(chart);
		
		chartViewModel.setInput(viewStringSet.Addset());
		
		cvm = chartViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		ChartViewModel chartViewModel=new ChartViewModel();
		
		Chart chart = chartService.edit(Integer.parseInt(chartId));
		
		ViewClass vc=new ViewClass();
		 vc.action="chartAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 chartViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(chart);
		
		chartViewModel.setInput(viewStringSet.updateset());
		
		cvm = chartViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 ChartViewModel chartViewModel=new ChartViewModel();
		
		 list = chartService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			chartViewModel.setList(viewStringSet.listSet(list));
			chartViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"chartAssign!add\">增加记录</a>");
			
			cvm = chartViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 ChartViewModel chartViewModel=new ChartViewModel();
		 list = chartService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			chartViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = chartViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
