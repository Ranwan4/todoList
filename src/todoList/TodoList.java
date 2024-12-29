/**
 * 
 */
package todoList;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 */
public class TodoList {
	//Scannerクラスをインスタンス化(テキスト入力をするクラス)
	private Scanner scanner = new Scanner(System.in);
	//タスクを格納するリスト
	private ArrayList<Object> tasks = new ArrayList<>();
	private int menu_num;

	/**
	 * @param args
	 */
	
	//low～max以外の数字ならエラーを表示し、再入力を求める
	public int checkNumber(int low, int max) {
		int input_number;	
		while(true) {
			input_number = scanner.nextInt();
			scanner.nextLine();  // nextInt() などで残った改行文字を消すための追加行
			if(low <= input_number && input_number <= max) {
				return input_number;
			}else {
				System.out.println(low + "～" + max + "で入力してください:");
			}
		}	
	}
	
	//メニューを表示、選択を取得するメソッド
	public int viewMenu() {
		int select_number_viewmenu;
		System.out.println("--------------------------------");
		System.out.println("以下から行う操作を選んでください");
		System.out.println("1:タスクの表示");
		System.out.println("2:タスクの追加");
		System.out.println("3:終了");
		System.out.println("数字を入力:");
		select_number_viewmenu = checkNumber(1,3);
		System.out.println("--------------------------------");
		return select_number_viewmenu;
	}
	
	public void viewTask(){
		//タスクを表示する
		if (tasks.isEmpty()) {
			System.out.println("現在、タスクはありません");
		}else {
			System.out.println("タスク一覧");
			for (int i = 0; i < tasks.size(); i++) {
				System.out.println("---------------------");
				System.out.println((i+1) + ": " + tasks.get(i));
				System.out.println("---------------------");
			}
			
		}
		System.out.println("メニューに戻る場合はEnterキーを押下してください");
		scanner.nextLine();
	}
	public void addTask() {
		//タスクを追加する
		ArrayList<Object> task_details = new ArrayList<>();
		String task_title;
		String task_memo;
		int task_manth;
		int task_day;
		
		System.out.println("タスクのタイトル:");
		task_title = scanner.nextLine();
		task_details.add(task_title);
		System.out.println("タスクの概要:");
		task_memo = scanner.nextLine();
		task_details.add(task_memo);
		System.out.println("タスクの締め切り日(指定しない場合は0)");
		System.out.println("月:");
		task_manth = checkNumber(0, 12);
		if(task_manth > 0) {
			task_details.add(task_manth);
			System.out.println("日:");
			task_day = checkNumber(1, 31);
			task_details.add(task_day);
		}
		tasks.add(task_details);
	}
	
	public void run() {
		while(true) {
			//まず実行されると、メニューが表示される
			menu_num = viewMenu();
			if(menu_num == 1) {
				//タスクの表示
				viewTask();
			}else if(menu_num == 2) {
				//タスクの追加
				addTask();
			}else if(menu_num == 3) {
				//終了
				System.out.println("終了します");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		TodoList todoList = new TodoList();
		todoList.run();
	}

}
