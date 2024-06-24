package com.google.checkstyle.test.chapter3filestructure.rule333orderingandspacing;

import static java.io.File.createTempFile;
import static java.awt.Button.ABORT;
// violation above '.* 'java.awt.Button.ABORT' .* Should be before 'java.io.File.createTempFile'.'
import static javax.swing.WindowConstants.*;
import java.awt.Button;
// violation above ''java.awt.Button' should be separated from previous import group by one line.'
import java.awt.Frame;
import java.awt.Dialog;
// violation above '.* 'java.awt.Dialog' .* Should be before 'java.awt.Frame'.'
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.JTable;
import java.io.File;
// violation above '.* 'java.io.File' .* Should be before 'javax.swing.JTable'.'
import java.io.IOException;
// violation above '.* 'java.io.IOException' .* Should be before 'javax.swing.JTable'.'
import java.io.InputStream;
// violation above '.* 'java.io.InputStream' .* Should be before 'javax.swing.JTable'.'
import java.io.Reader;
// violation above '.* 'java.io.Reader' .* Should be before 'javax.swing.JTable'.'

import com.google.common.base.Ascii;
// 2 violations above:
//                    'Extra separation in import group before 'com.google.common.base.Ascii''
//                    '.* 'com.google.common.base.Ascii' .* Should be before 'javax.swing.JTable'.'

public class InputOrderingAndSpacing1 {}
