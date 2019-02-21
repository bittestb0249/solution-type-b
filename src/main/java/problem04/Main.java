package problem04;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Record{
	int count;
	int game_try;
	long time;
	Record(int count, int game_try, long time){
		this.count=count;
		this.game_try=game_try;
		this.time=time;
	}
}

public class Main {

	public static void main(String[] args) {
		char[] game = { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O',
				'O' };
		int state = 0;
		int count = 0;
		int game_try = 0;
		long beforeTime;
		long afterTime;
		int choice=0;
		boolean success = false;
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		ArrayList<Record> arr = new ArrayList<Record>();

		while (choice != 1) {
			System.out.println("0:게임스타트, 1:게임종료");
			choice = sc.nextInt();
			if(choice==0) {
				while (success == false) {
					beforeTime = System.currentTimeMillis();
					game_try++;
					count = 0;
					state = 0;
					for (int i = 0; i < game.length * 2; i++) {
						int num1 = ran.nextInt(game.length);
						int num2 = ran.nextInt(game.length);
						char temp = game[num1];
						game[num1] = game[num2];
						game[num2] = temp;
					}
					while (success == false) {
						sc.next();
						state += ran.nextInt(4) + 1;
						count++;
						if (state >= 20) {
							success = true;
							afterTime = System.currentTimeMillis();
							long secDiffTime = (afterTime - beforeTime)/1000;
							arr.add(new Record(count, game_try, secDiffTime));
							for(Record s : arr) {
								System.out.println(s.count+"/"+s.game_try+"/"+s.time);
							}
						}
						if (game[state - 1] == 'O') {
							continue;
						}
						else {
							break;
						}
					}
				}
			}
		}

	}
}
