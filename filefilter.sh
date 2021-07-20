#!/bin/bash
OUTPUT="test"
while  [ -n "$OUTPUT" ]
do
    OUTPUT=$(.ci/no-exception-test.sh openjdk14-with-checks-nonjavadoc-error | grep "Caused by: " | grep -oh '/.*.java' | sed 's./.[\\\\\\/].g' | uniq)
    echo "$OUTPUT"
    echo -e "<module name=\"BeforeExecutionExclusionFileFilter\">\n  <property name=\"fileNamePattern\" value=\"/$OUTPUT\$\"/>\n</module>" >> .ci/openjdk14-excluded.files
    rm -rf .ci-temp/contribution
    git add .ci/openjdk14-excluded.files
    git commit -m "added another file filter"
done