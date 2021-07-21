import java.util.ArrayList;
import java.util.List;

public class TestOne {
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		stringList.add("1");
		stringList.add("2");
		stringList.add("3");
		Object listAsObject = stringList;
		List<String> stringListFrmObj = (ArrayList<String>) listAsObject;
		
		String stringTxt = "Hello";
		Object stringObj = stringTxt;
		String stringTxtfrmObj = (String) stringObj;
		
		System.out.println(stringTxtfrmObj);
		stringListFrmObj.forEach(p -> System.out.println(p));
	}
}
