package edu.ccrm.util;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Student;

import java.util.Comparator;

public final class ComparatorsUtil {
    private ComparatorsUtil() {}

    public static final Comparator<Student> BY_NAME = Comparator.comparing(Student::getFullName,String.CASE_INSENSITIVE_ORDER);
    public static final Comparator<Student> BY_REGNO = Comparator.comparing(Student::getRegNo);

    public static final Comparator<Course> BY_CREDITS_DESC = Comparator.comparingInt(Course::getCredits).reversed();
    public static final Comparator<Course> BY_TITLE = Comparator.comparing(Course::getTitle,String.CASE_INSENSITIVE_ORDER);
}
