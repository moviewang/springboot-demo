package java8.function;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by Movie on 2017/11/9.
 */
public class predicateConsumerDemo {
    public static Student updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer) {
        if (predicate.test(student)) {
            consumer.accept(student);
        }
        return student;
    }


    public static void main(String[] args) {
        Student student = new Student("si", "li", 80.0);
        Student student2 = updateStudentFee(student, student1 -> student1.grade > 80, student1 -> student1.feeDiscount = 0.2);
        student2.printFee();

        Student s = new Student("wang", "li", 88.0);
        Student student1 = updateStudentFee(s, ss -> ss.grade > 80, ss -> ss.feeDiscount = 0.3);
        student1.printFee();
    }
}
