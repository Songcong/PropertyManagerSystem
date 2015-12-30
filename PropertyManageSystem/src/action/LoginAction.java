package action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.jasper.tagplugins.jstl.core.Out;

import Model.Login;
import Model.Userinfo;
import Utilx.Code;
import ViewModel.LoginViewModel;
import service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "loginAction", results = {
		@Result(name = "ok", location = "/index.jsp"),
		@Result(name = "no", location = "/login.jsp"),
		@Result(name="logout",location="/login.jsp")
		})

@Controller
public class LoginAction extends ActionSupport {
	private Userinfo userinfo;
	private String message;

	private String code;
	
	private String userid;

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Resource(name = "loginService")
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String login() {

		List<Userinfo> list = loginService.Login(userinfo);
		String random = "";
		if (ActionContext.getContext().getSession().get("random") != null) {

			random = ActionContext.getContext().getSession().get("random")
					.toString();

		}
		if (code != null && code.equals(random)) {
			if (list.size() > 0) {
				Userinfo user= list.get(0);
				ActionContext.getContext().getSession().put("username",userinfo.getUsername());
				ActionContext.getContext().getSession().put("userid",user.getUserid());
				
				this.userid=String.valueOf(user.getUserid());
				return "ok";
			} else {
				message = "<script>alert('用户名或密码，登陆失败')</script>";
				return "no";
			}
		}
		else{
			message = "<script>alert('验证码错误')</script>";
			return "no";
		}

	}
	public String logout(){
		if (ActionContext.getContext().getSession().get("username") != null) {

			 ActionContext.getContext().getSession().remove("username");

		}
		
		
		return "logout";
		
		
	}

}
