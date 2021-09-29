package example;

import java.util.*;
import java.io.*;




abstract class Students implements Comparable<Students> {
    public String name;

    public Students(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Students o) {
        if (this.getClass() == o.getClass()) {
            return this.compare(o);
        } else {
            return this.getClass().toString().compareTo(o.getClass().toString());
        }
    }

    abstract public int compare(Object o);
}

class Human extends Students implements Comparable<Students> {
    private int only;

    public Human(String name, int only) {
        super(name);
        this.only = only;

    }

    public int compare(Object o){
        Human s = (Human) o;
        if(this.only < s.only){
            return -1;
        }
        else if(this.only > s.only) {
            return 1;
        }
        else{
            return 0;
        }
    }

}

class Android extends Students  {

    private String model, serial;

    public Android(String name, String model, String serial) {
        super(name);
        this.model = model;
        this.serial = serial;
    }

    public int compare(Object o) {
        Android s = (Android) o;
        if(this.model.compareTo(s.model) == 0) {
            return this.serial.compareTo(s.serial);
        }
        else{
            return this.model.compareTo(s.model);
        }
    }


}

public class sclass {

    public static void main(String [] args) throws Exception {

        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Students> list = new ArrayList<>();
        int testcase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcase; i++) {
            String line = br.readLine();
            String [] lines = line.split(" ");
            if(lines.length == 3) {
                String name = lines[0];
                String model = lines[1];
                String serial = lines[2];
                list.add(new Android(name, model, serial));
            }
            else if (lines.length == 2) {
                String ne = lines[0];
                int only = Integer.parseInt(lines[1]);
                list.add(new Human(ne, only));
            }
            else{
                break;
            }
        }

        Collections.sort(list);

        Iterator iter = list.iterator();

        while(iter.hasNext()) {
            Students k = (Students) iter.next();
            out.println(k.name);
        }

    }
}

