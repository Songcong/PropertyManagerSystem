package serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import service.IPublicUtilityManageService;
import Model.PublicUtilityManage;
import dao.IPublicUtilityManageDao;

import javax.annotation.Resource;

@Service("publicUtilityManageService")
public class PublicUtilityManageService  implements IPublicUtilityManageService{
	
	@Resource(name = "publicUtilityManageDAO")
	private IPublicUtilityManageDao publicUtilityManageDao;
	
	
	
	
	public void addoredit(PublicUtilityManage intent){
		publicUtilityManageDao.attachDirty(intent);
	}
	public PublicUtilityManage edit(int id){
		return publicUtilityManageDao.findById(id);
	}
	public List findall(){
		
		return	publicUtilityManageDao.findAll();
	}
	public void deletebyid(int id){
		publicUtilityManageDao.deletebyid(id);
	}
	public List likeByProperty(String propertyName, Object value){
		return publicUtilityManageDao.likeByProperty(propertyName, value);
	}
	
}
