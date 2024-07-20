package com.google.checkstyle.test.chapter4formatting.rule42blockindentation;

public class InputIndentationCorrectAnnotationArrayInit {
  interface MyInterface {
    @AnAnnotation(values = {"Hello"})
    void works();

    @interface AnAnnotation {
      String[] values();
    }
  }
}
