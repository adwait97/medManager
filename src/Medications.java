public class Medications {
	
	public static String n;
	public static long ndcNum;
	public static int strength;
	public static int quantity;
	public static String schedule;

	public static String getName() {
		return n;
	}
	public static void setName(String name) {
		n = name;
	}
	
	public static long getNdc() {
		return ndcNum;
	}
	
	public static void setNdc(long ndc) {
		ndcNum = ndc;
	}
	public static int getStrength() {
		return strength;
	}
	public static void setStrength(int st) {
		strength = st;
	}
	public static int getQuantity() {
		return quantity;
	}
	public static void setQuantity(int quan) {
		quantity = quan;
	}
	public static String getSchedule() {
		return schedule;
	}
	public static void setSchedule(String sc) {
		schedule = sc;
	}


	}