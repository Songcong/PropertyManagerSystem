package ViewModel;

public class ExpensetypeViewModel {

	public ViewClass viewClass;
	
	private String list;
	
	private String input;

	public ExpensetypeViewModel() {
		this.viewClass=new ViewClass();
	}
	public ViewClass getViewClass() {
		return viewClass;
	}

	public void setViewClass(ViewClass viewClass) {
		this.viewClass = viewClass;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
}
