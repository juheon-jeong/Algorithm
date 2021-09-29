package week9;



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    String name;
    double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }
}

public class first_problem {
    public static void main(String[] args) throws IOException{
        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        ArrayList<Student> list = new ArrayList<>();

        for(int i = 0; i < tc; i++) {


            String [] info = br.readLine().split(" ");
            String ne = info[0];
            double score = Double.parseDouble(info[1]);
            list.add(new Student(ne, score));


        }
            Comparator<Student> My = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                return Double.compare(o2.score, o1.score);
            }
        };
            Collections.sort(list, My);


        for(Student s : list) {
            out.println(s.name);

        }
    }
}
