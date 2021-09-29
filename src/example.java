import java.util.HashMap;
import java.util.Scanner;

public class  example {  //문제: 사용자 번호 저장 및 검색

        public static void main(String [] args) {

            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            int itemCounter = Integer.parseInt(line);

            HashMap<String, String> map = new HashMap<String, String>();

            line = scanner.nextLine();
            String [] nameStr = line.split(" ");
            line = scanner.nextLine();
            String[] numberStr = line.split(" ");

            for(int i = 0; i<itemCounter; i++) {
                map.put(nameStr[i], numberStr[i]);
            }

            line = scanner.nextLine();
            int searchCounter = Integer.parseInt(line);
            line = scanner.nextLine();
            String[] searchStr = line.split(" ");
            for(int i = 0; i < searchCounter; i++) {
                System.out.println(map.get(searchStr[i]));

            }

        }

    }

