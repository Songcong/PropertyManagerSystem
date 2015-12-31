package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.ITrackRecordService;
import Model.TrackRecord;
import Utilx.ViewStringSet;
import ViewModel.TrackRecordViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="trackRecordAssign",results={
		@Result(name="add",location="/TrackRecordaddoredit.jsp"),
		@Result(name="edit",location="/TrackRecordaddoredit.jsp"),
		@Result(name="list",location="/TrackRecordlist.jsp")})
@Controller
public class TrackRecordAssign extends ActionSupport{
	
	private TrackRecordViewModel cvm;
	
	 private String trackRecordId;
	 
	 private String propertyName;
	 
	 private String value;
	 
	 @Resource(name = "trackRecordService")
	private ITrackRecordService trackRecordService;

	private List list;

	public TrackRecordViewModel getCvm() {
		return cvm;
	}

	public void setCvm(TrackRecordViewModel cvm) {
		this.cvm = cvm;
	}

	public String getTrackRecordId() {
		return trackRecordId;
	}

	public void setTrackRecordId(String trackRecordId) {
		this.trackRecordId = trackRecordId;
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
		TrackRecordViewModel trackRecordViewModel=new TrackRecordViewModel();
		
		TrackRecord trackRecord = new TrackRecord();
		
		ViewClass vc=new ViewClass();
		 vc.action="trackRecordAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加车辆信息</h2></div>";
		 trackRecordViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(trackRecord);
		
		trackRecordViewModel.setInput(viewStringSet.Addset());
		
		cvm = trackRecordViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		TrackRecordViewModel trackRecordViewModel=new TrackRecordViewModel();
		
		TrackRecord trackRecord = trackRecordService.edit(Integer.parseInt(trackRecordId));
		
		ViewClass vc=new ViewClass();
		 vc.action="trackRecordAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑车辆信息</h2></div>";
		 trackRecordViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(trackRecord);
		
		trackRecordViewModel.setInput(viewStringSet.updateset());
		
		cvm = trackRecordViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 TrackRecordViewModel trackRecordViewModel=new TrackRecordViewModel();
		
		 list = trackRecordService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			trackRecordViewModel.setList(viewStringSet.listSet(list));
			trackRecordViewModel.viewClass.setAdd("<a class=\"glyphicon glyphicon-plus\" href=\"trackRecordAssign!add\">增加记录</a>");
			
			cvm = trackRecordViewModel;
			
			
			return "list";
	}
	
	public String likelist() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		 TrackRecordViewModel trackRecordViewModel=new TrackRecordViewModel();
		 list = trackRecordService.likeByProperty(propertyName, value);
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			trackRecordViewModel.setList(viewStringSet.likelistSet(list));
			
			cvm = trackRecordViewModel;
			
			
			return "list";
		 
	}
	 
	 
	 
	 
}
