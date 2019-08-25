//This class will retry the test the number of times as defined in the retryCount section.
//However one demerit of this is we have to define it for every test which we add in our project. And to avoid the same we can define one more class which is the IAnnotationTransformer.

package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int minCount=0;
	int retryCount=3;
	public  boolean retry(ITestResult result) {
		if(minCount <retryCount) {
			System.out.println("Test retried is: " + result.getName() +"retry count is: "+ (minCount+1));
			minCount++;
			//System.out.println("retry count is: "+ minCount);
			return true;
		}
		return false;
	}
}
