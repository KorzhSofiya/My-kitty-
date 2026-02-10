package Pr5;

public class ReportStarter {
    public static void main(String[] args){
        ReportStarter st = new ReportStarter();
        ReportGeneretor myReport = new DailyReporter();
        myReport.generate();
    }
}

abstract class ReportGeneretor{
    public final void generate(){
        fetchdata();
        formate();
        send();
    }
    protected abstract void fetchdata();
    protected abstract void formate();
    protected void send(){
        System.out.println("sending reportik...");
    }
}
class DailyReporter extends ReportGeneretor{
    @Override
    protected void fetchdata(){
        System.out.println("Load all orders");
    }
    @Override
    protected void formate(){
        System.out.println("Formate to TXT");
    }
}