class MyThread2 extends Thread{
    public MyThread2(String name){
        super(name);
    }
    @Override
    public void run(){
        if(getName().equals("House Stark") ||getName().equals("House Targaryen") ){
            System.out.println("The house is : " +"["+getName()+"]" );
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(getName().equals("House Lannister") ||getName().equals("House Bolton") ){
            System.out.println("The house is : " +"["+getName()+"]" );
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("The house is : " +"["+getName()+"]" );
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
}
public class Task2{
    public static void main(String[]args ){
        MyThread2 HouseStark=new MyThread2("House Stark");
        MyThread2 HouseTargaryen=new MyThread2("House Targaryen");
        MyThread2 HouseLannister=new MyThread2("House Lannister");
        MyThread2 HouseBolton=new MyThread2("House Bolton");
        MyThread2 HouseTyrell=new MyThread2("House Tyrell");

        HouseStark.setPriority(Thread.MAX_PRIORITY);
        HouseBolton.setPriority(Thread.MIN_PRIORITY);

        HouseStark.run();
        HouseTargaryen.run();
        HouseLannister.run();
        HouseBolton.run();
        HouseStark.start();
        try {
            HouseStark.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HouseTyrell.start();
        try {
            HouseTyrell.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HouseLannister.start();
        try {
            HouseLannister.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HouseBolton.start();
                try {
            HouseStark.join();
            HouseLannister.join();
            HouseBolton.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(HouseStark.isAlive()){
            System.out.println("Not Today");
        }
        if(!HouseBolton.isAlive()){
            System.out.println("You know nothing");
        }
        
    }
}