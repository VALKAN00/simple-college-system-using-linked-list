import java.util.Scanner;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        linkedlist l1=new linkedlist();
        l1.addstudent(1);
        l1.addstudent(2);
        l1.addstudent(3);
        l1.addstudent(4);
        l1.addstudent(5);

        l1.addcourse("math");
        l1.addcourse("oop");
        l1.addcourse("prop");
        l1.addcourse("numerical");
        l1.addcourse("data science");

        l1.enroll(2, "math");
        l1.enroll(3, "oop");
        l1.enroll(1, "math");
        l1.enroll(4, "numerical");
        l1.enroll(5, "prop");

        displayMenu();
        System.out.println();
        System.out.println();
        System.out.print("choose an operation : ");

        int operation= sc.nextInt();
        boolean flag=true;
        int sNum =5;
        while (flag) {
            switch (operation) {
                case 1:                                                    // to add student in uni system
                    sNum++;
                    l1.addstudent(sNum);
                    System.out.println("The student has been added ");
                    break;
                case 2:                                                    // to add course to uni system
                    System.out.println("Enter the name of course you want to be added");
                    String cName =sc.next();
                    l1.addcourse( cName);
                    System.out.println("The course has been added succesfull");

                    break;
                case 3:                                                    // to check if student in system or not
                    System.out.println("Enter student number ");
                    int Num=sc.nextInt();
                    l1.studenet_isinlist(Num);
                    break;
                case 4:                                                   // to check if the course in system or not
                    System.out.println("Enter course name ");
                    String Course=sc.next();
                    l1.course_isinlist(Course);
                    break;
                case 5:                                                   // to print all students in uni system
                    l1.print_students();
                    System.out.println();
                    break;
                case 6:                                                   // to print all courses in uni system
                    l1.print_courses();
                    System.out.println();
                    break;
                case 7:                                                   // to enroll a student in a specfic course

                    System.out.println("Enter Student Number");
                    int N=sc.nextInt();

                    System.out.println("Enter course Name ");
                    String C =sc.next();
                    l1.enroll(N,C);
                    System.out.println();
                    break;
                case 8:                                                   // to delete a course  from  a specfic student
                    System.out.println("Enter Student Number");
                    int n=sc.nextInt();
                    System.out.println("Enter course Name ");
                    String c =sc.next();
                    l1.delete_course_fromStudent(n,c);
                    break;
                case 9:                                                  // to print all courses enrolled by a student
                    System.out.println("Enter Student Number");
                    int num=sc.nextInt();
                    l1.print_studentinfo(num);
                    break;
                case 10:                                                 // to print all students enrolled in a course
                    System.out.println("Enter course name ");
                    String course =sc.next();
                    l1.print_Courseinfo(course);
                    break;
                default:
                    System.out.println("choose right operation please");
                    break;
            }
            System.out.print("press 0 for exit or press any number to continue :");
            int x=sc.nextInt();
            if (x==0){
                flag=false;
            }else{
                displayMenu();
                System.out.println();
                System.out.println();
                System.out.print("choose an operation : ");
                operation= sc.nextInt();
            }

        }


    }
    private static void displayMenu() {
        System.out.println("Choose an operation:");
        System.out.println("1. Add student");
        System.out.println("2. Add course");
        System.out.println("3. Check student");
        System.out.println("4. Check course");
        System.out.println("5. Print all students");
        System.out.println("6. Print all courses");
        System.out.println("7. Enroll a course to a student");
        System.out.println("8. Delete a course from a student");
        System.out.println("9. Print all courses enrolled by a student");
        System.out.println("10. Print all students enrolled in a course ");

    }
}

