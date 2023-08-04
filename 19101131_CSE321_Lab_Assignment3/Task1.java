import java.util.Scanner;
class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run(){
        Scanner sc= new Scanner(System.in);
        if(!getName().equals("oth")){

            if (getName().equals("add")) {
                System.out.println("Give input for addition");
                int num1= sc.nextInt();
                int num2= sc.nextInt();
                int sum= num1+num2;
                System.out.println("result "+sum);
            }
            // try {
            //     sleep(5000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            if (getName().equals("sub")) {
                System.out.println("Give input for substraction");
                int num1= sc.nextInt();
                int num2= sc.nextInt();
                int sub= num1-num2;
                System.out.println("result "+sub);
            }
            // try {
            //     sleep(5000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            if (getName().equals("mul")) {
                System.out.println("Give input for multiplication");
                int num1= sc.nextInt();
                int num2= sc.nextInt();
                int mul= num1*num2;
                System.out.println("result "+mul);
            }
            // try {
            //     sleep(5000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }

            if (getName().equals("div")) {
                System.out.println("Give input for division");
                int num1= sc.nextInt();
                int num2= sc.nextInt();
                int div= num1/num2;
                System.out.println("result "+div);
            }
            // try {
            //     sleep(3000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }
        else{
            sc.close();
            System.out.println("No valid operation");
        }
}
}
public class Task1{
    public static void main(String[]args ){
        MyThread add= new MyThread("add");
        add.start();
        try {
            add.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            }
        MyThread sub= new MyThread("sub");
        sub.start();
        try {
            sub.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            }
        MyThread mul= new MyThread("mul");
        mul.start();
        try {
            mul.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            }
        MyThread div= new MyThread("div");
        div.start();
        try {
            div.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            }
        MyThread oth= new MyThread("oth");
        oth.start();
    }
}
