package org.example.springhibernate.instructor;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.springhibernate.student.Student;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ToString.Exclude
    @ManyToOne(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE,
        CascadeType.DETACH,
        CascadeType.REFRESH
    })
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
        name = "course_student",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public Course(String title, Instructor instructor) {
        this.title = title;
        this.instructor = instructor;
        this.reviews = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    /**
     * 添加课程评论。
     *
     * @param review 需要保存的评论
     */
    public void addReview(Review review) {
        if (review == null) return;

        reviews.add(review);
    }

    /**
     * 添加学生。
     *
     * @param student 报名课程的学生
     */
    public void addStudent(Student student) {
        if (student == null) return;

        students.add(student);
    }
}
