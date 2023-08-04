
class MyThread3 extends Thread{
    private volatile long mean;


    public MyThread3(String name){
        super(name);
    }
    @Override
    public void run(){
        long[] fib=new long[50];
        fib[0]=0;
        fib[1]=1;
        for(int i=2; i<fib.length; i++){
            fib[i]=fib[i-1]+fib[i-2];
        }

        if(getName().equals("MyThread1")){
            long count=0;
            long sum1=0;
            int half=25;
            for(int i=0; i< half; i++){
              if(fib[i]%2!=0){
                  count+=1;
                  sum1+=fib[i];
              }  
            }
            mean=(sum1/count);
        }
        if(getName().equals("MyThread2")){
            long count1=0;
            long sum2=0;
            int half=25;
            for(int i=0; i< half; i++){
              if(fib[i]%2==0){
                  count1+=1;
                  sum2+=fib[i];
              }  
            }
            mean=(sum2/count1);
        }
        if(getName().equals("MyThread3")){
            long count2=0;
            long sum3=0;
            int half=25;
            for(int i=half; i< fib.length; i++){
              if(fib[i]%2!=0){
                  count2+=1;
                  sum3+=fib[i];
              }  
            }
            mean=(sum3/count2);
        }
        if(getName().equals("MyThread4")){
            long count3=0;
            long sum4=0;
            int half=25;
            for(int i=half; i< fib.length; i++){
              if(fib[i]%2==0){
                  count3+=1;
                  sum4+=fib[i];
              }  
            }
            mean=(sum4/count3);
        }

    }
    public long getValue() {
        return mean;
    }
    public long secretvalue(long a, long b, long c, long d){
        long result=(a+b+c+d)/4;
        System.out.println(result);
        return result;
    }
}
public class Task3{
    public static void main(String[]args ){
        long mean1=0;
        long mean2=0;
        long mean3=0;
        long mean4=0;
        MyThread3 myThread=new MyThread3("MyThread1");
        MyThread3 myThread2=new MyThread3("MyThread2");
        MyThread3 myThread3=new MyThread3("MyThread3");
        MyThread3 myThread4=new MyThread3("MyThread4");
        MyThread3 myThread5=new MyThread3("MyThread5");

        myThread.start();
        try {
            myThread.join();
            mean1=myThread.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread2.start();
        try {
             myThread2.join();
             mean2=myThread2.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread3.start();
        try {
            myThread3.join();
            mean3=myThread3.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread4.start();
        try {
            myThread4.join();
            mean4=myThread4.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread5.start();
        try {
            myThread5.join();
            myThread4.secretvalue(mean1, mean2, mean3, mean4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        
    }
}