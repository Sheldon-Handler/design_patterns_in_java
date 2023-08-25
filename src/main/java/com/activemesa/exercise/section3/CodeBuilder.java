package com.activemesa.exercise.section3;

import javassist.bytecode.SignatureAttribute;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

//public class CodeBuilder {
//
//    Person person = new Person();
//    public CodeBuilder(String className) {
//        // todo
//        Person person = new Person();
//
//    }
//
//    public CodeBuilder addField(String name, String type) {
//        // todo
//        switch (type) {
//            case "String":
//                person.name = name;
//                break;
//            case "int":
//                person.age = Integer.parseInt(name);
//                break;
//        }
//        return person;
//    }
//
//    @Override
//    public String toString() {
//        // todo
//
//        return
//        """
//        public class Person
//        {
//          public String name;
//          public int age;
//        }
//        """;
//    }
//}


    class CodeBuilder
    {
        CodeBuilder codeBuilder;
        HashMap<String, String> hashMap = new HashMap<>();

        public CodeBuilder(String className)
        {
            // todo

        }

        public CodeBuilder addField(String name, String type)
        {
            // todo

        }

        @Override
        public String toString()
        {
            // todo

        }
    }



