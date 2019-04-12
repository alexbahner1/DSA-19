import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.HashMap;
=======
>>>>>>> d26023a67aa5d4ee167cbfd4254484f332e69616
import java.util.List;

public class CoinsOnAClock {

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        // TODO
<<<<<<< HEAD
        int hours = hoursInDay;

        char[] answer = new char[hours];
        for(int i= 0; i < hours; i++){answer[i] = '.';}

        HashMap<Character, Integer> Coins = new HashMap<>();
        Coins.put('d', dimes);
        Coins.put('n',nickels);
        Coins.put('p', pennies);

        List<char[]> result = new ArrayList<>();
        helpercoin(Coins, hours, hours, 0, answer, result);
        for(char[] i :result){ System.out.println(Arrays.toString(i));}
        return result;
    }

    public static void helpercoin(HashMap<Character, Integer> Coins,int setmun, int hours, int i, char[] answer, List<char[]> result){
        if(hours <= 0){
            //char[] temp = answer;
//            answers.add(copyOf(board));
            //System.out.println("got");
            result.add(Arrays.copyOf(answer,answer.length));

            return;}
        if (answer[i] != '.'){return;}

        if(Coins.get('d') > 0){
            int ind = (i + 10) % setmun;
            //if(answer[ind] == '.'){
                answer[i] = 'd';
                Coins.put('d', Coins.get('d') -1);
                hours--;
                helpercoin(Coins, setmun, hours, ind, answer, result);
                answer[i] = '.';
                Coins.put('d', Coins.get('d') +1);
                hours++;
           // }
        }
        if(Coins.get('n') > 0){
            int ind = (i + 5) % setmun;
            //if(answer[ind] == '.'){
                answer[i] = 'n';
                Coins.put('n', Coins.get('n') -1);
                hours--;
                helpercoin(Coins, setmun, hours, ind, answer,result);
                answer[i] = '.';
                Coins.put('n', Coins.get('n') +1);
                hours++;
            //}
        }
        if(Coins.get('p') > 0){
            int ind = (i + 1) % setmun;
            //if(answer[ind] == '.'){
                answer[i] = 'p';
                Coins.put('p', Coins.get('p')-1);
                hours--;
                helpercoin(Coins, setmun, hours, ind, answer,result);
                answer[i] = '.';
                Coins.put('p', Coins.get('p') +1);
                hours++;
            //}
        }

    }

}
=======
        List<char[]> result = new ArrayList<>();
        return result;
    }
}
>>>>>>> d26023a67aa5d4ee167cbfd4254484f332e69616
