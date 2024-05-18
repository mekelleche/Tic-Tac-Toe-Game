import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Game game=new Game();
            int p=1;
            boolean s;
             Scanner sc=new Scanner(System.in);
            System.out.println("player 1 choose X or 0 :");
            String input = sc.next();
            char p1 = input.charAt(0);
            char p2 = (p1 == 'X') ? 'O' : 'X';
            System.out.println("player 1 you : "+p1+" player 2 you "+p2);

        while(true){

            while (p==1){
                game.printBckgoround();
                System.out.println("player 1");
                System.out.println("entre pos :");
                int x=sc.nextInt();
                int y=sc.nextInt();
                s=game.play(x,y,p1);
                if(s) p=2;
                else  System.out.println("pos taken choose again");
                if(game.checkWin(p1)){
                    System.out.println("player 1 WIN");
                    return;
                }
                 if(game.checkDraw()){
                    System.out.println("DRAW");
                    return;
                }
            }
           game.printBckgoround();
            while(p==2){
                System.out.println("player 2");
                 System.out.println("entre pos :");
                int x=sc.nextInt();
                int y=sc.nextInt();
                s=game.play(x,y,p2);
                if(s) p=1;
                else  System.out.println("pos taken choose again");
                if(game.checkWin(p2)) {
                    System.out.println("player 2 WIN");
                    return;
                }
                 if(game.checkDraw()){
                    System.out.println("DRAW");
                    return;
                }
            }

        }

}

}
