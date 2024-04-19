
public class Main {
    private final static CourseService courseService = new CourseServiceImp();
    public static void main(String[] args) {
        while (true){
            switch (View.menu()){
                case 0->{System.exit(0);}
                case 1->courseService.addNewCourse();
                case 2-> courseService.getAllCourses();
                case 3->{
                    courseService.getCourseById();
                }
                default -> System.out.println("No Option. :(");
            }
        }
    }
}