//non-compiled with javac: Compilable with Java14
package org.checkstyle.suppressionxpathfilter.recordtypeparametername;

import java.io.Serializable;
import java.util.LinkedHashMap;

record SuppressionXpathRegressionRecordTypeParameterName1
                                    <foo extends Serializable & Cloneable> // warn
                                    (LinkedHashMap<String, Node> linkedHashMap) {
}

