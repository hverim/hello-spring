package hello.hello_spring.controller;

public class MemberForm {
    //createMemberForm의 input name="name" 과 매칭됨
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
