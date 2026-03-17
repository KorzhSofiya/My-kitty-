package Pr_9;

public class Task2_Local_Anon {
    public String buildTicketId(String base) {
        String pre = "Tiket-";
        class IdBuilder {
            String build() {
                return pre + base;
            }
        }
        IdBuilder builder = new IdBuilder();
        return builder.build();
    }
        public Runnable runOnce(){
            return new Runnable() {
                @Override
                public void run() {
                    System.out.println("From anonym");
                }
            };
        }

}
