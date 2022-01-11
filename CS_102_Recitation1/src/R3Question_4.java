
public class R3Question_4 {

	public String duplicates(String s, int count) {
		char[] charles = s.toCharArray();
		if(count ==0) {
			if(charles[0] == charles[1]) {
				charles[1] = ' ';
				String say = new String(charles);
				say.replaceAll("\\s", "");
				return say;
			}
			String say = new String(charles);
			say.replaceAll("\\s", "");
			return say;
		}
		else {
			if(charles[count] == charles[count+1]) {
				charles[count+1] = ' ';
				String say = new String(charles);
				duplicates(say,count-1);
			}
			else {
				String say = new String(charles);
				duplicates(say,count-1);
			}
		}
		return "huh";
	}
}
