package iwamih31.RPGwin;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class Ex extends AbstractTableModel{

	protected static Object itemList[][] = {
		{" ＊","施術名","=","使用MP","｛ "},
		{"１.","祈り"  ,"=",   0    ,"  " },
		{"２.","奇跡"  ,"=",   10   ,"  " },
		{"３.","蘇生"  ,"=",   100  ,"  " },
		{"４.","荒行"  ,"=",   0    ,"  " }
	};

	protected static Character user = Main.getHu();
	protected static String name = user.getName();
	protected static int lev = user.getLev();
	protected static int hp = user.getHp();
	protected static int mp = user.getMp();
	private static int exp = user.getExp();
	protected static int job;
	protected static int ep;
	protected static int useMp ;
	protected static Object useEx;
	protected static String[] exText;
	private static ArrayList<String> array;
	private Object[][] ex;

	Ex(Character memb) {
		user = memb;
		name = user.getName();
		lev = user.getLev();
		hp = user.getHp();
		mp = user.getMp();
		exp = user.getExp();
		ep = user.getEp();
		exText = new String[]{"○○ は ○○ を行った・・・"};
		setEx();
		// exMenu();

//		select(0);

	}

//	public void exMenu() {
//
//		System.out.println("");//////////////////////////////////////////
//		System.out.println("exMenu() します");//////////////////////////////
//		System.out.println("");//////////////////////////////////////////
//
//		Battle.pTable();
//		System.out.println( "" );
//		System.out.print( "どの術を使いますか？" );
//		for (Object[] stocks : itemList) {
//			for (Object stock : stocks) {
//				System.out.print(stock);
//			}
//		}
//		System.out.println("｝");
//		if (Battle.getfMode() == 0)System.out.println("");
//		job = Input.input();
//
//		if(job < 1 || job > 4){
//			exMenu();
//		}else{
//
//		System.out.println("");//////////////////////////////////////////
//		System.out.println("job = " + job + " です");//////////////////////////////
//		System.out.println("");//////////////////////////////////////////
//
//		useEx = itemList[job][1];


//
//		useMp = Integer.parseInt(String.valueOf(itemList[job][3]));
//
//		// System.out.println("");
//		}
//	}

	public void select(int i) {

		System.out.println("");//////////////////////////////////////////
		System.out.println("Ex.select(" + i + ") します");//////////////////
		System.out.println("");//////////////////////////////////////////

		job = (i + 1);

		System.out.println("");//////////////////////////////////////////
		System.out.println("job = " + job + " です");////////////////////
		System.out.println("");//////////////////////////////////////////

		if (job < itemList.length) {

			useEx = itemList[job][1];

			useMp = Integer.parseInt(String.valueOf(itemList[job][3]));
		}

		spell( );
	}

	public void spell( ) {

		switch ( job ) {
			case 1:
				praying( );
				break;
			case 2:
				heal( );
				break;
			case 3:
				resu( );
				break;
			case 4:
				desolation( );
				break;
			default:
				System.out.println( "なにもしなかった" );
				exText = new String[]{"なにもしなかった"};
		}
	}



	protected static void praying() {

			if ( hp <= 10 ) {

				notMp();

			} else {
				int fH = hp;
				int fM = mp;

				exText = new String[2];

				System.out.println( name  + "は" +useEx + "を行った・・・" );

				exText[0] = ( name  + "は" +useEx + "を行った・・・" );

	//			Input.ent();
				int r = new java.util.Random ( ).nextInt( 3 ) + 1;
				int rp = r * ep;
				user.setMp(mp + rp);
				if ( user.getMp() >= lev * ep * 3 ) {
					user.setMp((lev * ep * 3));
				}
				user.setHp((hp - 10));
				if ( user.getHp() <  1 ) {
					user.setHp((0));
				}
				System.out.println( name  + "は[ " +(fH - user.getHp()) + " HP ]と引き換えに[ "+(mp - fM)+" MP ]回復させた!!!" );

				exText[1] = ( name  + "は[ " +(fH - user.getHp()) + " HP ]と引き換えに[ "+(user.getMp() - fM)+" MP ]回復させた!!!" );

			}
		}

	protected static void heal() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("heal() します");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		if (mp < useMp) {

			notMp();

		} else {
			whom();

			Screen.setMode(22501);

		}
	}

	void heal(int who) {
			// TODO 自動生成されたメソッド・スタブ

			System.out.println("");//////////////////////////////////////////
			System.out.println("heal(" + who + ") します");//////////////////////////////
			System.out.println("");//////////////////////////////////////////

			exText = new String[2];

			Member select = Main.getParty()[who];
			int fH = select.getHp();
			if (select.getHp() > 0) {
				System.out.println(name + "は" + useEx + "を行った・・・");

				exText[0] = (name + "は" + select.getName() + "に" + useEx + "を行った・・・");

	//			Input.ent();
				int r = new java.util.Random().nextInt(15) + 1;
				int pP = new java.util.Random().nextInt(5);
				int rp = r + ep * lev - pP;
				select.setHp((select.getHp() + rp));
				if (select.getHp() > (select.getLev() * select.getAp() * 10)) {
					select.setHp(select.getLev() * select.getAp() * 10);
				}
				int rH = select.getHp() - fH;
				System.out.println(select.getName() + "のHPが" + rH + "回復した❤❤❤");

				exText[1] = (select.getName() + "のHPが" + rH + "回復した❤❤❤");

			} else {
				System.out.println(select.getName() + "は死んでいた!!!");

				exText[1] = (select.getName() + "は死んでいた!!!");
			}
	//		Input.ent();
			user.setMp(user.getMp() - useMp);
		}

	protected static void resu() {

		System.out.println("");//////////////////////////////////////////
		System.out.println("resu() します");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		if (mp < useMp) {

			notMp();

		} else {

			whom();

			Screen.setMode(22502);
		}
	}


	void resu(int who) {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println("");//////////////////////////////////////////
		System.out.println("resu(" + who + ") します");//////////////////////////////
		System.out.println("");//////////////////////////////////////////

		exText = new String[2];

		Member select = Main.getParty()[who];
		System.out.println(name + "は" + select.getName() + "に" + useEx + "を行った・・・");

		exText[0] = (name + "は" + select.getName() + "に" + useEx + "を行った・・・");

//		Input.ent();
		int r = new java.util.Random().nextInt(100) + 1;
		if (r < lev * ep) {
			System.out.println(useEx + "は失敗した");

			exText[1] = (useEx + "は失敗した");

//			Input.ent();
			user.setMp(user.getMp() - (useMp / 10));
		} else {
			System.out.println(select.getName() + "は生き返った!!!");

			exText[1] = (select.getName() + "は生き返った!!!");

//			Input.ent();
			select.setHp((int) (select.getAp() * 5));
			select.setMp((int) (select.getEp() * 2));
			user.setMp(user.getMp() - useMp);
		}
	}


	protected static void desolation() {
			if ( mp < useMp ) {

				notMp();

			} else {
				int fH = hp;
				int fM = mp;

				exText = new String[2];

				System.out.println( name  + "は" +useEx + "を行った・・・" );

				exText[0] = (name + "は" + useEx + "を行った・・・");

	//			Input.ent();
				int r = new java.util.Random ().nextInt(3) + 9;
				int rp = r * lev * ep;
				user.setMp((mp + rp));
				if( user.getMp() > lev * ep * 3 ){
					user.setMp(lev * ep * 3);
				}
				user.setHp(1);
				System.out.println(name + "は[ " + (fH - hp) + " HP ]と引き換えに[ " + (mp - fM) + " MP ]回復させた!!!");

				exText[1] = (name + "は[ " + (fH - hp) + " HP ]と引き換えに[ " + (mp - fM) + " MP ]回復させた!!!");

	//			Input.ent();
			}
		}

	protected static void notMp() {

			System.out.println(user.getName() + "のMP=" + mp + " 消費MP=" + useMp);//////////////////
			System.out.println("");
			System.out.println(useEx + "を行うには力が足りません ×××");

			exText = new String[]{useEx + "を行うための力が不足しています ×××"};
	//		Input.ent();
	//		spell();

		}

private static void whom() {

		Battle.pTable();
		System.out.println("");
		System.out.print(useEx + "を、誰に行いますか？");
		Battle.pList();
		System.out.println("");

		exText = new String[]{useEx + "を、誰に行いますか？"};

		Screen.setMenu(Main.getpNa());

//		int who = Input.input() - 1;
//		if (who > 4) {
//			resu();
//		} else {

//		resu(who);

//		}

	}

//	public static void setMon(Monster mon) {
//		Ex.mon = mon;
//	}
//
//
//
//	public static Monster getMon() {
//		return mon;
//	}

	public Object[] menu() {
		// TODO 自動生成されたメソッド・スタブ
		Object[] menu = new Object[itemList.length-1];
		for (int i = 0; i < menu.length; i++) {
			menu[i] = itemList[i + 1][1];
		}
		return menu;
	}

	public static void setName(String name) {
		Ex.name = name;
	}

	protected static String getName() {
		return name;
	}

	public static void setJob(int job) {
		Ex.job = job;
	}

	public static int getJob() {
		return job;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		setEx();
		return ex[0][columnIndex].getClass();
	}

	@Override
	public String getColumnName(int column) {
		setEx();
		return (String) ex[column][0];
	}

	@Override
	public int getRowCount() {
		setEx();
		return ex.length;
	}


	@Override
	public int getColumnCount() {
		setEx();
		return ex[0].length;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		setEx();
		return ex[rowIndex][columnIndex];
	}

	private void setEx() {
		ex = new Object[][] {
			{itemList[1][1], "["+itemList[1][3]+"]" },
			{itemList[2][1], "["+itemList[2][3]+"]" },
			{itemList[3][1], "["+itemList[3][3]+"]" },
			{itemList[4][1], "["+itemList[4][3]+"]" }
		};
	}

	protected static void arrayClear() {

		if (array == null){
			array = new ArrayList<String>();
		}else{
			for (int i = array.size(); i > 0; i--) {
				array.remove(i-1);
			}
		}
	}

	public static void setExText(ArrayList<String> arrayList) {

		exText = new String[arrayList.size()];

		for (int i = 0; i < arrayList.size(); i++) {
			exText[i] = arrayList.get(i);
		}
	}

	public String[] getExText() {
		return exText;
	}

	public static void setArray(ArrayList<String> array) {
		Ex.array = array;
	}

	public static ArrayList<String> getArray() {
		return array;
	}
}
