///////////////////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code and other text files for adherence to a set of rules.
// Copyright (C) 2001-2023 the original author or authors.
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

package com.puppycrawl.tools.checkstyle.grammar.java21;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.AbstractTreeTestSupport;

public class Java21AstRegressionTest extends AbstractTreeTestSupport {

    @Override
    protected String getPackageLocation() {
        return "com/puppycrawl/tools/checkstyle/grammar/java21";
    }

    @Test
    public void testUnnamedVariable() throws Exception {
        verifyAst(
                getNonCompilablePath(
                        "ExpectedJava21UnnamedVariable.txt"),
                getNonCompilablePath(
                        "InputJava21UnnamedVariable.java"));
    }

    @Test
    public void testUnnamedVariableWithPatternsInSwitch() throws Exception {
        verifyAst(
                getNonCompilablePath(
                        "ExpectedJava21UnnamedVariableWithPatternsInSwitch.txt"),
                getNonCompilablePath(
                        "InputJava21UnnamedVariableWithPatternsInSwitch.java"));
    }

    @Test
    public void testUnnamedVariableJep443Examples() throws Exception {
        verifyAst(
                getNonCompilablePath(
                        "ExpectedJava21UnnamedVariableJep443Examples.txt"),
                getNonCompilablePath(
                        "InputJava21UnnamedVariableJep443Examples.java"));
    }
}
