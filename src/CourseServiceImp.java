import model.Course;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class CourseServiceImp implements CourseService{
    @Override
    public void addNewCourse() {
        System.out.println("=".repeat(30));
        String title;
        label1:
        while (true){
            System.out.print("[+] Insert course title: ");
             title = new Scanner(System.in).nextLine();
            if(!title.isEmpty()){
                break label1;
            }
        }
        Course course =
                new Course(new Random().nextInt(100), title, LocalDate.of(2024,2,2).toString(),LocalDate.of(2024,3,3).toString(),true );
        String data = course.getCourseId() + ","
                +course.getCourseTitle()+","
                +course.getCourseStartedDate()+","
                +course.getCourseEndedDate()+","
                +course.getIsAvailable();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("course.csv", true))){
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch (Exception exception){
            System.out.println("[!] Problem during add new Course: " + exception.getMessage());
        }
        System.out.println("[+] Added new course successfully.");
    }
    @Override
    public void getAllCourses() {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        table.addCell("course_id");
        table.addCell("course_name");
        table.addCell("course_started_date");
        table.addCell("course_ended_date");
        table.addCell("course_available");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("course.csv"))){
            String  data;
            for(int i=0;i<5;i++){
                table.setColumnWidth(i,30,30);
            }
            while ((data=bufferedReader.readLine())!=null){
                String [] value = data.split(",");
                table.addCell(value[0],1);
                table.addCell(value[1],1);
                table.addCell(value[2],1);
                table.addCell(value[3],1);
                table.addCell(value[4],1);
            }
            System.out.println(table.render());
        }catch (Exception exception){
            System.out.println("[!] Problem during get all courses: " + exception.getMessage());
        }
    }

    @Override
    public void getCourseById() {
        System.out.println("=".repeat(40));
        System.out.print("[+] Insert course ID: ");
        int courseId = new  Scanner(System.in).nextInt();
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        table.addCell("course_id");
        table.addCell("course_name");
        table.addCell("course_started_date");
        table.addCell("course_ended_date");
        table.addCell("course_available");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("course.csv"))){
            String  data;
            Boolean isFound = false;
            for(int i=0;i<5;i++){
                table.setColumnWidth(i,30,30);
            }
            while ((data=bufferedReader.readLine())!=null){
                String [] value = data.split(",");
                if(courseId==Integer.parseInt(value[0])){
                    isFound = true;
                    table.addCell(value[0],1);
                    table.addCell(value[1],1);
                    table.addCell(value[2],1);
                    table.addCell(value[3],1);
                    table.addCell(value[4],1);
                    break;
                }
            }
            if(isFound.equals(false)){
                System.out.println("[!] Not found course with ID: " + courseId);
            }else {
                System.out.println(table.render());
            }
        }catch (Exception exception){
            System.out.println("[!] Problem during get all courses: " + exception.getMessage());
        }
    }
}
