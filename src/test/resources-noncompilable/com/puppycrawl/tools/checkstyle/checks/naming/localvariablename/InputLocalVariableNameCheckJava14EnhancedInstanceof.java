//non-compiled with javac: Compilable with Java14
package com.puppycrawl.tools.checkstyle.checks.naming.localvariablename;

public class InputLocalVariableNameCheckJava14EnhancedInstanceof {
    Object num = 42;
    {
        if (num instanceof Integer i){
            int j = 1;
            int k = i +j;
        }
    }
}
