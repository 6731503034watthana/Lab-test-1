package com.example.labtest1.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 60)
    private String firstName;

    @NotBlank @Size(max = 60)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Major major; // จำกัด 3 ค่า

    @NotBlank
    private String level = "ม.4";

    @NotNull
    @DecimalMin("0.0") @DecimalMax("4.0")
    private Double grade;

    public Student() {}

    public Student(String firstName, String lastName, Major major, Double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.grade = grade;
        this.level = "ม.4";
    }

    // helper เผื่ออยากโชว์ชื่อเต็มง่ายๆ
    @Transient
    public String getFullName() { return firstName + " " + lastName; }

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Major getMajor() { return major; }
    public String getLevel() { return level; }
    public Double getGrade() { return grade; }

    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setMajor(Major major) { this.major = major; }
    public void setLevel(String level) { this.level = level; }
    public void setGrade(Double grade) { this.grade = grade; }
}
