package action;

import java.io.ByteArrayInputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Utilx.Code;


@ParentPackage("json-default")
@Action(value="codeAction",results={@Result(name="suc",type="stream",params={"contentType=image/jpeg","inputName=inputStream"}),
									@Result(name="ok",type="json")
									})
public class CodeAction extends ActionSupport {

	private ByteArrayInputStream inputStream; 
	private String code;
	private String check;
	
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String code(){
		
		Code code=Code.Instance();
		
		this.setInputStream(code.getImage());//取得带有随机字符串的图片    
		ActionContext.getContext().getSession().put("random", code.getString());//取得随机字符串放入HttpSession 
		
		return "suc";
		
		
	}
	public String check(){
		String random="";
		if(ActionContext.getContext().getSession().get("random")!=null){
			
			random=ActionContext.getContext().getSession().get("random").toString();
			
		}
		if(code!=null&&code.equals(random))
		{
			this.check="ok";
		}
		else{
			this.check="no";
		}
		
		
		return "ok";
		
		
	}
}
