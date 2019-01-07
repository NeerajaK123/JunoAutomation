import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Driver {

	public static void main(String[] args) {		
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("/data/jenkins_home/Amgen_automation/src/resources/testng.xml");
		testng.setTestSuites(suites);
		testng.run();
	}

}
