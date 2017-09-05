package sfd;

import java.util.Scanner;

/**
 * Created by zhuxinquan on 16-9-6.
 */
public class Main {

    public int submaxFun(Integer[] array){
        if(array == null || array.length == 0)
            System.exit(0);
        int sum = 0;
        int max = array[0];
        for(int i = 0; i < array.length; i++){
            sum += array[i];
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Main myClass = new Main();
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        if(str.equals("")){
            return;
        }
        Integer[] str2int = new Integer[number];
        String[] strsignal = str.split(" ");
        for (int i = 0; i < number; i++) {
            str2int[i] = Integer.parseInt(strsignal[i]);
        }
        int result = myClass.submaxFun(str2int);
        System.out.println(result);
    }
}
