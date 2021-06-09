package application.model;

public class Utilities {
	//Stati sull'asse x
	public static final int MOVE_RIGHT = 0;
	public static final int MOVE_LEFT = 1;
	public static final int IDLE_RIGHT = 2;
	public static final int IDLE_LEFT = 3;
	//Stati sull'asse y
	public static final int Y_IDLE = 4;
	public static final int FALLING = 5;
	public static final int JUMPING = 6;
	//Campi di support per animazioni
	public static final int FALL_LEFT = 7;
	public static final int FALL_RIGHT = 8;
	public static final int JUMP_LEFT = 9;
	public static final int JUMP_RIGHT = 10;
	//Campo per aggiormento server
	//public static final int UPDATE = 11;
	//Protocollo client-server
	public static final String POSITION = "pos";
	public static final String MOVE = "m";
	public static final String ENEMY = "e";
	public static final String PLAYER = "p";
	public static final String MESSAGE_SEPARATOR = ";";
	public static final String OK_JOIN = "OK";
	public static final String JOIN_ERROR = "NO";
	public static final String GAME_START = "START";
	public static final String DISCONNECTED = "DISCONNECTED";
	public static final String ROOM_FULL_ERROR = "FULL";
	public static final String NOT_EXIXTS_ROOM = "NOTEXTISTS";
	
	
	
	//I messaggi dal client al server saranno del tipo m xcord ycord
	public static String moveLeft() {
		return MOVE + " " + MOVE_LEFT; 
	}
	public static String moveRight() {
		return MOVE + " " + MOVE_RIGHT; 
	}
	public static String requestIdleLeft() {
		return MOVE + " " + IDLE_LEFT; 
	}
	public static String requestIdleRight() {
		return MOVE + " " + IDLE_RIGHT; 
	}
	public static String requestJump() {
		return MOVE + " " + JUMPING; 
	}
	//I messaggi dal server al client saranno p entity xcord ycord xstate ystate alive/dead
	public static String position(String who,int index,int x,int y,int xState,int yState) {
		return POSITION + " " + who + " " + index + " " + x + " " + y + " " + xState + " " + yState; 
	}
	
	//messaggi dal client al server
	public static final String HOST = "h";
	public static final String JOIN = "j";
	public static final String joinRequest(String code) {
		return JOIN + " " + code;
	}
	
	//campi per il portocollo di connessione al db
	public static final String DB_ACCESS = "DBaccess";
	public static final String LOGIN = "login";
	public static final String SIGNUP = "signup";
	public static final String ALL_CLASSIFICATION = "all_classification";
	public static final String MY_CLASSIFICATION = "my_classification";
	public static final String UPDATE_SCORE = "update_score";
	
	//errori realtivi alla registrazione e al login	
	public static final String SUCCESS_ACCESS = "OK_ACCESS";	
	public static final String USER_ALREADY_EXIST = "USER_EXIST";
	public static final String USER_NOT_EXIST = "USER_NOT_EXIST";
	public static final String WRONG_PASSWORD = "WRONG_PASSWORD";
	public static final String ERROR_CONNECTING_DB = "DB_ERROR";
	public static final String PROGRESS_SAVED = "PROGRESS_SAVED";
	public static final String STILL_NO_CLASSIFICATION = "NO_CLASSIFICATION";
	public static final String START_CLASSIFICATION = "CLASS_START";
	public static final String END_CLASSIFICATION = "CLASS_END";
	
	
	
}
