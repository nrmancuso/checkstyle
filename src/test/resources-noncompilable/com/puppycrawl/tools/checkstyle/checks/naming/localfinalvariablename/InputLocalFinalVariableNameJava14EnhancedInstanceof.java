//non-compiled with javac: Compilable with Java14
package com.puppycrawl.tools.checkstyle.checks.naming.localfinalvariablename;

public class InputLocalFinalVariableNameJava14EnhancedInstanceof {
    Object obj = "string";
    {
        if (obj instanceof Integer var1) {

        }
        else if (obj instanceof String var2) {

        }
    }
}
