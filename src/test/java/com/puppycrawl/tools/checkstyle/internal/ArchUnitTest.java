///////////////////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code and other text files for adherence to a set of rules.
// Copyright (C) 2001-2022 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
///////////////////////////////////////////////////////////////////////////////////////////////

package com.puppycrawl.tools.checkstyle.internal;

import static com.google.common.truth.Truth.assertWithMessage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.EvaluationResult;
import com.tngtech.archunit.lang.FailureReport;

public class ArchUnitTest {

    @BeforeAll
    public static void init() {
        System.setProperty(
                "org.slf4j.simpleLogger.log.com.tngtech.archunit.core.PluginLoader", "off");
    }

    /**
     * The goal is to ensure all classes of a specific name pattern have non-protected methods,
     * except for those which are annotated with {@code Override}. In the bytecode there is no
     * trace anymore if this method was annotated with {@code Override} or not (limitation of
     * Archunit), eventually we need to make checkstyle's Check on this.
     *
     * @noinspection JUnitTestMethodWithNoAssertions
     * @noinspectionreason JUnitTestMethodWithNoAssertions - asserts in callstack,
     *      but not in this method
     */
    @Test
    public void nonProtectedCheckMethodsTest() {
        // This list contains methods which have been overridden and are set to ignore in this test.
        final String[] methodsWithOverrideAnnotation = {
            "processFiltered",
            "getMethodName",
            "mustCheckName",
            "postProcessHeaderLines",
            "getLogMessageId",
        };
        final String ignoreMethodList = String.join("|", methodsWithOverrideAnnotation);
        final JavaClasses importedClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("com.puppycrawl.tools.checkstyle.checks");

        final ArchRule checkMethodsShouldNotBeProtectedRule =
                methods().that()
                .haveNameNotMatching(".*(" + ignoreMethodList + ")").and()
                .areDeclaredInClassesThat()
                .haveSimpleNameEndingWith("Check").and()
                .areDeclaredInClassesThat()
                .doNotHaveModifier(JavaModifier.ABSTRACT)
                .should().notBeProtected();

        checkMethodsShouldNotBeProtectedRule.check(importedClasses);
    }

    private static final List<String> API_PACKAGE_SUPPRESSION_DETAILS = List.of(
            "Constructor <com.puppycrawl.tools.checkstyle.api.FileText.<init>(java.io.File, " +
                    "java.lang.String)> gets field <com.puppycrawl.tools.checkstyle.utils.CommonUtil." +
                    "EMPTY_STRING_ARRAY> in",
            "Constructor <com.puppycrawl.tools.checkstyle.api.FileText.<init>(java.io.File, java.util.List)> " +
                    "gets field <com.puppycrawl.tools.checkstyle.utils.CommonUtil.EMPTY_STRING_ARRAY>" +
                    " in ",
            "Method <com.puppycrawl.tools.checkstyle.api.AbstractCheck.log(com.puppycrawl.tools.checkstyle.api." +
                    "DetailAST, java.lang.String, [Ljava.lang.Object;)> calls method" +
                    " <com.puppycrawl.tools.checkstyle.utils.CommonUtil.lengthExpandedTabs" +
                    "(java.lang.String, int, int)>",
            "Method <com.puppycrawl.tools.checkstyle.api.AbstractCheck.log(int, int, java.lang.String, " +
                    "[Ljava.lang.Object;)> calls method <com.puppycrawl.tools.checkstyle.utils." +
                    "CommonUtil.lengthExpandedTabs(java.lang.String, int, int)>",
            "Method <com.puppycrawl.tools.checkstyle.api.AbstractFileSetCheck.log(int, int, java.lang.String, " +
                    "[Ljava.lang.Object;)> calls method <com.puppycrawl.tools.checkstyle.utils.CommonUtil." +
                    "lengthExpandedTabs(java.lang.String, int, int)>",
            "Method <com.puppycrawl.tools.checkstyle.api.AbstractFileSetCheck.process(java.io.File, " +
                    "com.puppycrawl.tools.checkstyle.api.FileText)> calls method <com.puppycrawl.tools." +
                    "checkstyle.utils.CommonUtil.matchesFileExtension(java.io.File, [Ljava.lang.String;)> ",
            "Method <com.puppycrawl.tools.checkstyle.api.AbstractFileSetCheck.setFileExtensions([Ljava." +
                    "lang.String;)> calls method <com.puppycrawl.tools.checkstyle.utils.CommonUtil." +
                    "startsWithChar(java.lang.String, char)> in",
            "Method <com.puppycrawl.tools.checkstyle.api.AutomaticBean$PatternConverter.convert(java." +
                    "lang.Class, java.lang.Object)> calls method <com.puppycrawl.tools.checkstyle.utils." +
                    "CommonUtil.createPattern(java.lang.String)> in",
            "Method <com.puppycrawl.tools.checkstyle.api.AutomaticBean$RelaxedStringArrayConverter." +
                    "convert(java.lang.Class, java.lang.Object)> gets field <com.puppycrawl.tools." +
                    "checkstyle.utils.CommonUtil.EMPTY_STRING_ARRAY> in",
            "Method <com.puppycrawl.tools.checkstyle.api.AutomaticBean$UriConverter.convert(java." +
                    "lang.Class, java.lang.Object)> calls method <com.puppycrawl.tools.checkstyle" +
                    ".utils.CommonUtil.getUriByFilename(java.lang.String)> in",
            "Method <com.puppycrawl.tools.checkstyle.api.AutomaticBean$UriConverter.convert(java.lang." +
                    "Class, java.lang.Object)> calls method <com.puppycrawl.tools.checkstyle.utils.C" +
                    "ommonUtil.isBlank(java.lang.String)> in",
            "Method <com.puppycrawl.tools.checkstyle.api.FileContents.lineIsBlank(int)> calls method" +
                    " <com.puppycrawl.tools.checkstyle.utils.CommonUtil.isBlank(java.lang.String)> " +
                    "in"
    );

    /**
     * The goal is to ensure all classes in api package are not dependent on classes in util
     * pacakages.
     *
     */
    @Test
    public void testClassesInApiDoNotDependOnClassesInUtil() {
        final JavaClasses apiPackage = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.puppycrawl.tools.checkstyle.api");

        final String [] utilPackages =  {
                "com.puppycrawl.tools.checkstyle.utils",
                "com.puppycrawl.tools.checkstyle.checks.javadoc.utils"
        };

        final ArchRule classShouldNotDependOnUtilPackages = noClasses()
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage(utilPackages);

        final EvaluationResult result = classShouldNotDependOnUtilPackages.evaluate(apiPackage);
        final EvaluationResult filtered = result.filterDescriptionsMatching(description -> {
            return API_PACKAGE_SUPPRESSION_DETAILS.stream()
                    .noneMatch(description::contains);
        });

        assertWithMessage("api package: " + classShouldNotDependOnUtilPackages.getDescription())
                .that(filtered.getFailureReport().getDetails())
                .isEmpty();
    }

}
