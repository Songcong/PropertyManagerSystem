package service;

import java.util.List;

import Model.Userinfo;

public interface IRegisterService {
	public void register(Userinfo userinfo);
	public Userinfo edit(int id);
	public List<Userinfo> findall();
	public void deletebyid(int id);
	public List likeByProperty(String propertyName, Object value);
}
