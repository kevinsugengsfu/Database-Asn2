package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "students")

public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int uid;
  private String name; 
  private int weight;
  private int height;
  private String hairColor;
  private String major;
  private Double gpa;
  private String gender;


  public Student(){
  }
  public Student(String name, int weight, int height, String hairColor, String major, Double gpa, String gender){
    this.name = name;
    this.weight = weight;
    this.height = height;
    this.hairColor = hairColor;
    this.major = major;
    this.gpa = gpa;
    this.gender = gender;
  }

  public int getUid() {
    return uid;
  }
  public void setUid(int uid) {
    this.uid = uid;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getWeight() {
    return weight;
  }
  public void setWeight(int weight) {
    this.weight = weight;
  }
  public int getHeight() {
    return height;
  }
  public void setHeight(int height) {
    this.height = height;
  }
  public String getHairColor() {
    return hairColor;
  }
  public void setHairColor(String hairColor) {
    this.hairColor = hairColor;
  }
  public String getMajor() {
    return major;
  }
  public void setMajor(String major) {
    this.major = major;
  }
  public Double getGpa() {
    return gpa;
  }
  public void setGpa(Double gpa) {
    this.gpa = gpa;
  }

  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }



}
