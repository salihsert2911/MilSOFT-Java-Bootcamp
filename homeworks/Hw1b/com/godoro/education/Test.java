package com.godoro.education;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        School schoolGodoro = new School(901, "Godoro Üniversitesi");

        Classroom classroom1 = new Classroom(701, "Mühendislik");
        Classroom classroom2 = new Classroom(702, "Ekonomi");

        Student student1 = new Student(301, "Neşet Ertaş", 45.2);
        Student student2 = new Student(302, "Erkan Ocaklı", 71.3);
        Student student3 = new Student(303, "Mahsuni Şerif", 36.5);
        Student student4 = new Student(304, "Celal Güzelses", 61.2);
        Student student5 = new Student(305, "Mustafa Topaloğlu", 42.2);

        schoolGodoro.setClassroomList(new ArrayList<>());
        classroom1.setStudentList(new ArrayList<>());
        classroom2.setStudentList(new ArrayList<>());

        student1.setClassroom(classroom1);
        student2.setClassroom(classroom2);
        student3.setClassroom(classroom1);
        student4.setClassroom(classroom1);
        student5.setClassroom(classroom2);

        classroom1.setSchool(schoolGodoro);
        classroom2.setSchool(schoolGodoro);

        schoolGodoro.getClassroomList().add(classroom1);
        schoolGodoro.getClassroomList().add(classroom2);

        classroom1.getStudentList().add(student1);
        classroom2.getStudentList().add(student2);
        classroom1.getStudentList().add(student3);
        classroom1.getStudentList().add(student4);
        classroom2.getStudentList().add(student5);

        System.out.println(schoolGodoro.getSchoolId() + " " + schoolGodoro.getSchoolName());
        for (Classroom clasroom : schoolGodoro.getClassroomList()) {
            System.out.println("\t" + clasroom.getClassroomId() + " " + clasroom.getClassroomName());
            for (Student student : clasroom.getStudentList()) {
                System.out.println("\t\t" + student.getStudentId() + " " + student.getStudentName() + " "
                        + student.getAverageMark());
            }
        }
    }
}
