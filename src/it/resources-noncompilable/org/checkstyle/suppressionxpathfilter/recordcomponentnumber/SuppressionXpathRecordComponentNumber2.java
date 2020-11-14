//non-compiled with javac: Compilable with Java14
package org.checkstyle.suppressionxpathfilter.recordcomponentnumber;

/* Config:
 *
 * max = 1
 */
public class SuppressionXpathRecordComponentNumber2 {
    public record MyRecord(int x, int y) { } // warn
}
