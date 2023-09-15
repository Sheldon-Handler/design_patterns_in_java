package com.activemesa.exercise.section3;

import java.util.Vector;


class CodeBuilder {

    private String className;
    private Vector<String> nameVector;
    private Vector<String> typeVector;

    public CodeBuilder(String className) {
        // todo
        this.className = className;
    }


    public CodeBuilder addField(String name, String type) {
        // todo
        nameVector.add(name);
        typeVector.add(type);
        return new CodeBuilder(className);
    }

    @Override
    public String toString() {
        // todo
        String string = "";

        for (int i = 0; i < nameVector.size(); i++) {
            string += typeVector.get(i) + " " + nameVector.get(i) + ";\n";
        }

        return "public class " + className + "\n{\n" + string + "}";
    }
}