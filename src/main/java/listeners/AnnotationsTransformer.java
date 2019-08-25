package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationsTransformer implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation testAnnnotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		testAnnnotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
