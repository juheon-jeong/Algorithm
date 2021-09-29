import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.io.*;
public class temp {
    public static void main(String[] args) throws IOException{
        PrintStream out;
        try {
            out = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Goods> list = new ArrayList<Goods>();
        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split(" ");
            if(str[0].equals("F")){
                list.add(new Fruit(str[1], str[2], Integer.parseInt(str[3])));
            }else{
                list.add(new Electronics(str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3])));
            }
        }
        Collections.sort(list);
        Iterator i = list.iterator();
        Fruit f;
        while(i.hasNext()){
            Goods g = (Goods)i.next();
            out.println(g.name+g.stock);
        }
    }
}
class Fruit extends Goods{
    String isSale;
    public Fruit(String name, String isSale, int stock){
        super(name,stock);
        this.isSale = isSale;
    }
    public int compare(Object o){
        Fruit f = (Fruit)o;
        if(this.isSale.compareTo(f.isSale)>0){
            return 1;
        }else if(this.isSale.compareTo(f.isSale)==0){
            if(this.stock<f.stock){
                return 1;
            }else if(this.stock > f.stock){
                return -1;
            }
            return 0;
        }else{
            return -1;
        }
    }
}
class Electronics extends Goods{
    int num;
    public Electronics(String name, int num, int stock){
        super(name,stock);
        this.num = num;
    }
    public int compare(Object o){
        Electronics e = (Electronics)o;
        if(this.num > e.num){
            return 1;
        }else if(this.num==e.num){
            if(this.stock< e.stock){
                return 1;
            }
            else if(this.stock > e.stock){
                return -1;
            }
            return 0;
        }else{
            return -1;
        }
    }
}
abstract class Goods implements Comparable<Goods>{
    public String name;
    public int stock;

    public Goods(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    @Override
    public int compareTo(Goods o) {
        if(this.getClass() == o.getClass()) {
            return this.compare(o);
        }else {
            return this.getClass().toString().compareTo(o.getClass().toString());
        }
    }

    abstract public int compare(Object o);
}