//non-compiled with javac: Compilable with Java14
package org.checkstyle.suppressionxpathfilter.patternvariablename;

public class SuppressionXpathRegressionPatternVariableName4 {
    MyClass(Object o1){
        if (o1 instanceof String st) { // warning
        }
    }
}
