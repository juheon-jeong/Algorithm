import java.util.*;


class Person implements Comparable<Person> {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    public boolean equals(Person o) {
        Person p = (Person) o;
        return  p.id == this.id;
    }
    public int compareTo(Person o){
        if(this.id > o.id){  //오름차순
            return 1;
        }
        else if(this.id < o.id){
            return -1;
        }
        else
            return 0;
    }
}

public class SetPerson{
    public static void main(String[] args) {
        HashSet<Person> pset = new HashSet<>();
        TreeSet<Person> tset = new TreeSet<>();

        System.out.println("\t HashSet");

        pset.add(new Person("lee",1111));
        pset.add(new Person("kim",2222));
        pset.add(new Person("choi",3333));
        pset.add(new Person("park",4444));
        pset.add(new Person("lee",1111));

        for(Person p : pset) {
            System.out.println(p.name + "\t" + p.id);
        }

        System.out.println("\t Treeset");

        tset.add(new Person("lee",1111));
        tset.add(new Person("kim",2222));
        tset.add(new Person("choi",3333));
        tset.add(new Person("park",4444));
        tset.add(new Person("hong", 1111));

        for(Person t : tset){
            System.out.println(t.name + "\t" + t.id);
        }


    }
}