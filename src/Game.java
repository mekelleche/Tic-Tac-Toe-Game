public class Game {

    private char[][] background;

    public Game() {
        initializr();
    }

    public void initializr(){
        background= new char[][]{
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };
    }
    public boolean changeX(int x,int y){
        if(background[x][y]==' '){
            background[x][y]='X';
            return true;
        }
        else return false;

    }
     public boolean changeO(int x,int y){
         if(background[x][y]==' '){
            background[x][y]='O';
            return true;
        }
        else return false;
    }
    public boolean play(int x,int y,char m){
        boolean played=false;
        if(m=='X'){
            played=changeX(x,y);
        }
        else if(m=='O'){
            played=changeO(x,y);
        }
         return  played;
    }
    public boolean checkWin(char m){
        String possible1= background[0][0] +String.valueOf(background[0][1])+ background[0][2];
        String possible2 =background[1][0] +String.valueOf(background[1][1])+ background[1][2];
        String possible3 =background[2][0] +String.valueOf(background[2][1])+ background[2][2];
        String possible4 =background[0][0] +String.valueOf(background[1][0])+ background[2][0];
        String possible5 =background[0][1] +String.valueOf(background[1][1])+ background[2][1];
        String possible6 =background[0][2] +String.valueOf(background[1][2])+ background[2][2];
        String possible7 =background[0][0] +String.valueOf(background[1][1])+ background[2][2];
        String possible8 =background[0][2] +String.valueOf(background[1][1])+ background[2][0];
        String mmm=m +String.valueOf(m)+ m;
        return mmm.equals(possible1) || mmm.equals(possible2) || mmm.equals(possible3) || mmm.equals(possible4) ||
                mmm.equals(possible5) || mmm.equals(possible6) || mmm.equals(possible7) || mmm.equals(possible8);
    }
    public boolean checkDraw(){
        int count=0;
         for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(background[i][j]=='X' ||background[i][j]=='O') count++;
            }
       }
        return count == 9;
    }

    public void printBckgoround(){
         for(char[] row:background ){
            for(char i:row){
                System.out.print("|"+i+"|");
            }
           System.out.println();
       }
        System.out.println();
    }

}
