//non-compiled with javac: Compilable with Java14
package org.checkstyle.suppressionxpathfilter.patternvariablename;

public class SuppressionXpathRegressionPatternVariableName1 {
   MyClass(Object o1){
       if (o1 instanceof String STRING1) { // warning
       }
   }
}
