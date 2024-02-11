package com.skio.models;

public enum UserType {
    DEV("Developer"), QA("Tester"), PROJECT_MGR("Project Manager"), LEAD("Project Lead"), DEVOPS("Dev-Ops");

    private String typeName;

    UserType(String typeName) {
        this.typeName = typeName;
    }
}
