package question2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Thread1 implements Serializable {
	private static final long serialVersionUID = 10L;
	HashMap<Project, ArrayList<Employee>> hMap;

	public Thread1(HashMap<Project, ArrayList<Employee>> hMap) {
		this.hMap = hMap;
	}

}