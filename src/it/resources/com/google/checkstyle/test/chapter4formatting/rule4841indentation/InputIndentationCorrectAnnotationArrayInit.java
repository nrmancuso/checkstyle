package com.google.checkstyle.test.chapter4formatting.rule4841indentation;

public class InputIndentationCorrectAnnotationArrayInit {
  interface MyInterface {
    @AnAnnotation(values = {"Hello"})
    void works();

    @interface AnAnnotation {
      String[] values();
    }
  }
}
