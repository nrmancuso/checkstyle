#!/bin/bash
OUTPUT="test"
while  [ -n "$OUTPUT" ]
do
    OUTPUT=$(.ci/no-exception-test.sh openjdk14-with-checks-nonjavadoc-error | grep "Caused by: " | grep -oh '([A-z0-9-_+]+\/)*([A-z0-9]+\.(java))' | sed 's|.*/||' | cut -f 1 -d '.' | uniq)
    echo "$OUTPUT"
    echo -e "<module name=\"BeforeExecutionExclusionFileFilter\">\n  <property name=\"fileNamePattern\" value=\"[\\/]$OUTPUT\.java\$\"/>\n</module>" >> config/openjdk14-excluded.files
    rm -rf .ci-temp/contribution
    git add .
    git commit -m "add filter"
done
