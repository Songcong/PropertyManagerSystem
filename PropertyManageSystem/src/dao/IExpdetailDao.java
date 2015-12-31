package dao;

import java.util.List;

import Model.Expdetail;

public interface IExpdetailDao {
	public void attachDirty(Expdetail instance);
	public Expdetail findById(java.lang.Integer id);
	public List findAll();
	public void deletebyid(int id);
	public List likeByProperty(String propertyName, Object value);
}
