public class linkedlist {
     class Node{
        int studentnum;
        String coursename;
        Node snext;
        Node cnext;

        public Node() {
            studentnum=0;
            coursename=null;
            snext=null;
            cnext=null;
        }

        public Node(int studentnum) {
            this.studentnum = studentnum;
        }

        public Node(String coursename) {
            this.coursename = coursename;
        }

        public Node(int studentnum, String coursename) {
            this.studentnum = studentnum;
            this.coursename = coursename;
        }
    }
    private Node st_head;
    private Node st_tail;
    private Node c_head;
    private Node c_tail;
    int students_len =0;
    int courses_len =0;

    public linkedlist() {
        st_head=null;
        st_tail=null;
        c_head=null;
        c_tail=null;
    }

    public boolean st_isempty(){
        if((st_head==null) && (st_tail==null)){
            return true;
        }else{
            return false;
        }
    }
    public boolean c_isempty(){
        if((c_head==null) && (c_tail==null)){
            return true;
        }else{
            return false;
        }
    }
    public void addstudent(int st_num){
        if (st_isempty()){
            st_head=st_tail=new Node(st_num);
        }else {
            st_tail.snext=new Node(st_num);
            st_tail=st_tail.snext;

        }
        students_len++;
    }
    public void addcourse(String coursename){
        if (c_isempty()){
            c_head=c_tail=new Node(coursename);
        }else {
            c_tail.cnext=new Node(coursename);
            c_tail=c_tail.cnext;
        }
        courses_len++;
    }
    public void studenet_isinlist(int student_num){
        Node cur=st_head;
        boolean flag=false;
        while (cur!=null){
            if (cur.studentnum==student_num){
                flag=true;
                break;
            }
            cur=cur.snext;
        }
        if (flag==true){
            System.out.println("student : "+student_num+ " is found (: ");
        }else{
            System.out.println("student : "+student_num+" is not found ): ");
        }
    }

    public void course_isinlist(String course_name){
        Node cur=c_head;
        boolean flag=false;
        while (cur!=null){
            if (cur.coursename.equals(course_name)){
                flag=true;
                break;
            }
            cur=cur.cnext;
        }
        if (flag==true){
            System.out.println("Course : "+course_name+ " is found (: ");
        }else{
            System.out.println("Course : "+course_name+" is not found ): ");
        }
    }
    public boolean course_isinlistbool(String course_name){
        Node cur=c_head;
        while (cur!=null){
            if (cur.coursename.equals(course_name)){
                return true;
            }
            cur=cur.cnext;
        }
        return false;
    }
    public void print_students(){
        Node cur=st_head;
        if (st_isempty()){
            return;
        }else{
            System.out.print("students in this collage : ");
            while(students_len >0){
                if(students_len==1){
                    System.out.print(cur.studentnum);
                }else {
                    System.out.print(cur.studentnum+" --> ");
                    cur=cur.snext;
                }
                students_len--;
            }

        }
    }
    public void print_courses(){
        Node cur=c_head;
        if (c_isempty()){
            return;
        }else{
            System.out.print("courses in this collage : ");
            while(courses_len>0){
                if (courses_len==1){
                    System.out.print(cur.coursename);
                }else{
                    System.out.print(cur.coursename+" --> ");
                    cur=cur.cnext;
                }
                courses_len--;
            }

        }
    }


    public void enroll(int student_num, String course_name) {
        if (isStudentEnrolled(student_num, course_name)) {
            System.out.println("course is all ready enrolled");
        } else {
            Node newnode = new Node(student_num, course_name);
            Node cur_student = st_head;
            while (cur_student != null && cur_student.studentnum != student_num) {
                cur_student = cur_student.snext;
            }

            if (cur_student == null) {
                System.out.println("Student not found in the system.");
                return;
            }

            Node down = cur_student;
            while (down.cnext != null) {
                down = down.cnext;
            }
            down.cnext = newnode;

            Node cur_course = c_head;
            while (cur_course != null && !cur_course.coursename.equals(course_name)) {
                cur_course = cur_course.cnext;
            }

            if (cur_course == null) {
                System.out.println("Course not found in the system.");
                return;
            }

            Node right = cur_course;
            while (right.snext != null) {
                right = right.snext;
            }
            right.snext = newnode;
        }
    }

    public void print_studentinfo(int student_num){
        Node cur=st_head;
        if (st_isempty()){
            return;
        }else{
            while(cur.studentnum!=student_num){
                cur=cur.snext;
                if (cur==null) {
                    System.out.println("student not fount in system ");
                    return ;
                }
            }
            Node down=cur.cnext;
            System.out.print("courses enrolled by student " + student_num + " are : ");
            while(down!=null){
                if(down.studentnum==student_num) {
                    System.out.print("[ "+down.coursename+" ]"+" ");
                    down = down.cnext;
                }else{
                    down=down.cnext;
                }
            }

        }
    }

    public void print_Courseinfo(String course_name) {
        Node cur = c_head;

        while (cur != null && !cur.coursename.equals(course_name)) {
            cur = cur.cnext;
        }

        if (cur == null) {
            System.out.println("Course not found in the system.");
            return;
        }

        Node right = cur.snext;
        System.out.print("Students in course " + course_name + ": ");
        while (right != null && right.coursename.equals(course_name)) {
            System.out.print("[" + right.studentnum + "] ");
            right = right.snext;
        }
        System.out.println();
    }

    public void delete_course_fromStudent(int studentid, String course_name) {
        Node cur = st_head;

        while (cur != null && cur.studentnum != studentid) {
            cur = cur.snext;
        }

        if (cur == null) {
            System.out.println("Student not found in the system.");
            return;
        }

        Node down = cur.cnext;
        Node prev = cur;

        while (down != null && !down.coursename.equals(course_name)) {
            prev = down;
            down = down.cnext;
        }

        if (down == null) {
            System.out.println("This course is not enrolled by the student.");
            return;
        }

        prev.cnext = down.cnext;

        Node curcourse = c_head;

        while (curcourse != null && !curcourse.coursename.equals(course_name)) {
            curcourse = curcourse.cnext;
        }

        if (curcourse == null) {
            System.out.println("Course not found in the system.");
            return;
        }

        Node right = curcourse.snext;
        Node prevcourse = curcourse;

        while (right != null && right.studentnum != studentid) {
            prevcourse = right;
            right = right.snext;
        }

        prevcourse.snext = right.snext;
    }

    public boolean isStudentEnrolled(int student_num, String course_name) {
        Node cur_student = st_head;
        while (cur_student != null && cur_student.studentnum != student_num) {
            cur_student = cur_student.snext;
        }

        if (cur_student == null) {
            System.out.println("Student not found in the system.");
            return false;
        }

        Node enrolledCourse = cur_student.cnext;
        while (enrolledCourse != null) {
            if (enrolledCourse.coursename.equals(course_name)) {
                return true;
            }
            enrolledCourse = enrolledCourse.cnext;
        }

        return false;
    }


}